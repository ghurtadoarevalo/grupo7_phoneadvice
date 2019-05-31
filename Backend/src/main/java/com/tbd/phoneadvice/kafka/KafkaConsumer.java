package com.tbd.phoneadvice.kafka;


import java.io.StringReader;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.models.User;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import lombok.var;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import twitter4j.*;

import twitter4j.json.DataObjectFactory;

@Service
@EnableScheduling
public class KafkaConsumer {

    @Autowired
    Consumer<Long,String> consumer;

    @Autowired
    private TweetRepository tweetRepository;

    private boolean status;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        this.status = true;
        while(status) {
            ConsumerRecords<Long, String> records = consumer.poll(Duration.of(1, ChronoUnit.SECONDS));
            for (ConsumerRecord<Long, String> record : records) {
                try{
                    System.out.println("\n");
                    System.out.println(record.value());
                    System.out.println("\n");
                    Status s = TwitterObjectFactory.createStatus(record.value());
                    String country = "null",countryCode = "null",region = "null";
                    Double latitude = -1.0,longitude = -1.0;
                    if(s.getPlace() != null) {
                        country = s.getPlace().getCountry();
                        countryCode = s.getPlace().getCountryCode();
                        region = s.getPlace().getName();
                    }
                    if(s.getGeoLocation() != null)
                    {
                        latitude = s.getGeoLocation().getLatitude();
                        longitude = s.getGeoLocation().getLongitude();
                    }
                    User user = new User(s.getUser().getId(),s.getUser().getName(),s.getUser().getScreenName(),s.getUser().getLocation(),s.getUser().getFollowersCount());
                    Tweet tweet = new Tweet(s.getId(),s.getText(),s.getLang(),user,s.getRetweetCount(),s.getFavoriteCount(),country,countryCode,region,latitude,longitude);
                    this.tweetRepository.save(tweet);

                }catch(TwitterException name) { System.out.println(name); }

                if (status == false) {
                    break;
                }
            }

        }
    }
    public void stop() { this.status = false; }
}

