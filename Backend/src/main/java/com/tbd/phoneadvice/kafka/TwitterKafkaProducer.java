package com.tbd.phoneadvice.kafka;

import com.google.gson.Gson;
import com.tbd.phoneadvice.elasticsearch.repositories.DataTweetRepository;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;

import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;



import com.tbd.phoneadvice.config.KafkaConfiguration;
import com.tbd.phoneadvice.config.TwitterConfiguration;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.kafka.callback.BasicCallback;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@RestController
@Configurable
@RequestMapping(value = "/kafkaProducer")
public class TwitterKafkaProducer {


    private Client client;
    private BlockingQueue<String> queue;
    private Gson gson;
    private Callback callback;
    private Authentication authentication;

    public TwitterKafkaProducer() {
        this.authentication = new OAuth1(
                TwitterConfiguration.CONSUMER_KEY,
                TwitterConfiguration.CONSUMER_SECRET,
                TwitterConfiguration.ACCESS_TOKEN,
                TwitterConfiguration.TOKEN_SECRET);

        queue = new LinkedBlockingQueue<>(10000);
        gson = new Gson();
        callback = new BasicCallback();
    }

    private Producer<Long, String> getProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfiguration.SERVERS);
        properties.put(ProducerConfig.ACKS_CONFIG, "1");
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 500);
        properties.put(ProducerConfig.RETRIES_CONFIG, 0);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(properties);
    }

    public void run(TweetRepository tweetRepository, DataTweetRepository dataRepository, List<String> hashtags) {

        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(hashtags);
        client = new ClientBuilder()
                .hosts(Constants.STREAM_HOST)
                .authentication(authentication)
                .endpoint(endpoint)
                .processor(new StringDelimitedProcessor(queue))
                .build();

        client.connect();

        try (Producer<Long, String> producer = getProducer()) {
            while (true) {

                Tweet tweet = gson.fromJson(queue.take(), Tweet.class);
                Tweet tweetA = new Tweet(tweet.getId(),tweet.getText(),tweet.getLang(),tweet.getUser(),tweet.getRetweetCount(),tweet.getFavoriteCount());
                if(tweetA.getLang().equals("es"))
                {
                    tweetRepository.save(tweetA);
                    dataRepository.save(tweetA);
                }
                String keyLong = tweet.getId();
                long key = Long.parseLong(keyLong);
                String msg = tweet.toString();
                ProducerRecord<Long, String> record = new ProducerRecord<>(KafkaConfiguration.TOPIC, key, msg);
                producer.send(record, callback);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            client.stop();
        }
    }

    public void stop() {client.stop();}
}
