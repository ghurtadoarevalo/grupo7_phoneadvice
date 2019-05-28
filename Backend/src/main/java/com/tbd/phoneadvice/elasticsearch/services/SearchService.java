package com.tbd.phoneadvice.elasticsearch.services;

import com.tbd.phoneadvice.elasticsearch.repositories.DataTweetRepository;
import com.tbd.phoneadvice.mongo.models.Tweet;

import com.tbd.phoneadvice.sentiment.Classifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/search")
public class SearchService {

    @Autowired
    DataTweetRepository repository;

    /*
    @Autowired
    private Classifier classifier;
    */

    @GetMapping(value = "/all")
    public Iterable<Tweet> getAll()
    {
        return repository.findAll();
    }

    @GetMapping(value = "/content/{text}")
    public Iterable<Tweet> searchbyContent(@PathVariable final String text)
    {
        return repository.findByText(text);
    }

    @GetMapping(value = "/user/name/{text}")
    public Iterable<Tweet> searchbyUserName(@PathVariable final String text)
    {
        return repository.findByUserName(text);
    }

    /*
    @RequestMapping("/classify")
    public HashMap<String,Double> classify(@RequestParam(value="text") String text) {
        return this.classifier.classify(text);
    }
    */

}
