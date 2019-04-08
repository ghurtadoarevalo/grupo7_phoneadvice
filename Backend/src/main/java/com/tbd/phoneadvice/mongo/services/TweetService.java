package com.tbd.phoneadvice.mongo.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.tbd.phoneadvice.mongo.models.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/test")
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tweet getTweetbyId(@PathVariable String id)
    {
        System.out.println(id);
        return this.repository.findTweetById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Tweet getTweetByName(@PathVariable String name)
    {
        System.out.println(name);
        return this.repository.findTweetByName(name);
    }

    @RequestMapping(value = "/getTweets", method = RequestMethod.GET)
    @ResponseBody
    public List<Tweet> getTweets(){

        return this.repository.findAll();
    }
}
