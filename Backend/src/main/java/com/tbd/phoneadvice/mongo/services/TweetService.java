package com.tbd.phoneadvice.mongo.services;

import com.tbd.phoneadvice.kafka.TwitterKafkaProducer;
//import com.tbd.phoneadvice.kafka.KafkaConsumer;
//import com.tbd.phoneadvice.kafka.TwitterListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import com.tbd.phoneadvice.mongo.models.Tweet;

import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tweet")
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;


    @Autowired
    private TwitterKafkaProducer producer;

    /*
    @Autowired
    private TwitterListener listener;

    @Autowired
    private KafkaConsumer consumer;
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tweet getTweetbyId(@PathVariable String id)
    {
        return this.tweetRepository.findTweetById(id);
    }

    @RequestMapping(value = "/getTweets", method = RequestMethod.GET)
    @ResponseBody
    public List<Tweet> getTweets(){

        return this.tweetRepository.findAll();
    }


    @RequestMapping(value = "/startKafka", method = RequestMethod.GET)
    public void startGet(){

        //Se obtendra lista de hastags a partir de la info almacenada en bd mysql.
        //De momento se creara esta solo para test o para entrega 1er sprint.

        List<String> hashtags = new ArrayList<>();

        hashtags.add("huawei");
        hashtags.add("samsung");
        hashtags.add("apple");
        hashtags.add("sony");

        this.producer.run(this.tweetRepository,hashtags);
    }

    @RequestMapping(value = "/stopKafka", method = RequestMethod.GET)
    public List<Tweet> stopGet(){
        this.producer.stop();
        return tweetRepository.findAll();
    }

}