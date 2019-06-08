package com.tbd.phoneadvice.mongo.services;

//import com.tbd.phoneadvice.kafka.TwitterKafkaProducer;
import com.tbd.phoneadvice.kafka.KafkaConsumer;
import com.tbd.phoneadvice.kafka.TwitterListener;
import com.tbd.phoneadvice.mysql.models.WordBrand;
import com.tbd.phoneadvice.mysql.models.WordPhone;
import com.tbd.phoneadvice.mysql.models.WordSpecification;
import com.tbd.phoneadvice.mysql.repositories.Word_brandRepository;
import com.tbd.phoneadvice.mysql.repositories.Word_phoneRepository;
import com.tbd.phoneadvice.mysql.repositories.Word_specificationRepository;
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

    /*
    @Autowired
    private TwitterKafkaProducer producer;
    */

    @Autowired
    private TwitterListener listener;

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private Word_brandRepository word_brandRepository;

    @Autowired
    private Word_phoneRepository word_phoneRepository;

    @Autowired
    private Word_specificationRepository word_specificationRepository;



    @RequestMapping(value = "/startKafka", method = RequestMethod.GET)
    @ResponseBody
    public void start()
    {
        List<String> filtro = new ArrayList<>();

        List<WordBrand> listA = word_brandRepository.findAll();
        List<WordPhone> listB = word_phoneRepository.findAll();
        List<WordSpecification> listC = word_specificationRepository.findAll();

        for(int i = 0 ; i < listA.size();i++)
        {
            String contenido = listA.get(i).getContent();
            filtro.add(contenido);
        }
        for(int i = 0 ; i < listB.size();i++)
        {
            String contenido = listB.get(i).getContent();
            filtro.add(contenido);
        }
        /*
        for(int i = 0 ; i < listC.size();i++)
        {
            String contenido = listC.get(i).getContent();
            filtro.add(contenido);
        }
        */


        listener.run(filtro);
        consumer.run();
    }
    /*
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
*/
    @RequestMapping(value = "/stopKafka", method = RequestMethod.GET)
    public List<Tweet> stopGet(){
        this.consumer.stop();
        return tweetRepository.findAll();
    }

}