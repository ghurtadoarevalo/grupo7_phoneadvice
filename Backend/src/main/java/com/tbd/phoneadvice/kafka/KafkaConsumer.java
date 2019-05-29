package com.tbd.phoneadvice.kafka;

/*
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class KafkaConsumer {

    @Autowired
    Consumer<Long,String> consumer;

    private boolean status;

    public void run(TweetRepository tweetRepository) {
        java.util.Date date = new java.util.Date();
        ConsumerRecords<Long, String> records=consumer.poll(Duration.of(1, ChronoUnit.SECONDS));
        this.status = true;
        Gson gson = new Gson();
        Type type = new TypeToken<Tweet>() {}.getType();

        for (ConsumerRecord<Long, String> record : records) {

            System.out.println(record.value());
            Tweet incomingTweet = gson.fromJson(record.value(), type);
            System.out.println("\n\n\n\n ahhhhhhhhhhh" + incomingTweet.getUser() + "\n\n\n\n\n");
            if(status == false) { break; }
        }
    }
    public void stop() { this.status = false; }
}

*/