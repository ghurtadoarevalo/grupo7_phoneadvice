package com.tbd.phoneadvice.kafka;


import javax.annotation.PostConstruct;

import com.google.gson.Gson;
import com.mongodb.util.JSON;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.models.User;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import com.tbd.phoneadvice.mongo.services.TweetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;

import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.kafka.core.KafkaTemplate;

@RestController
@Configurable
@RequestMapping(value = "/kafkaProducer")
public class TwitterListener {

    @Autowired
    private TwitterStream twitterStream;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private TweetRepository tweetRepository;


    @Value(value = "${kafka.topicName}")
    private String topicName;

    public void run(List<String> palabras) {
        twitterStream.addListener(new StatusListener()
        {
            public void onStatus(Status status) {
                String tweetJson = TwitterObjectFactory.getRawJSON(status);
                kafkaTemplate.send(topicName,tweetJson);
            }

            @Override
            public void onException(Exception arg0) {
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
            }

            @Override
            public void onStallWarning(StallWarning arg0) {
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
            }
        });

        String[] listaFinal = palabras.toArray(new String[0]);
        FilterQuery filter = new FilterQuery();
        filter.track(listaFinal);
        filter.language(new String[]{"es"});
        twitterStream.filter(filter);



    }


    public TwitterStream getTwitterStream() {
        return twitterStream;
    }

    public void setTwitterStream(TwitterStream twitterStream) {
        this.twitterStream = twitterStream;
    }
}
