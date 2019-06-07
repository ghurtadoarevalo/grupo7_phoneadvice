package com.tbd.phoneadvice.sentiment.services;

import com.tbd.phoneadvice.elasticsearch.repositories.DataTweetRepository;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.sentiment.Classifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sentiment")
public class SentimentService {

    @Autowired
    private DataTweetRepository dataRepository;

    @Autowired
    private Classifier classifier;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    @ResponseBody
    public void tweetSentiment(@PathVariable final String text){
        List<Tweet> tweetList = dataRepository.findByText(text);
        int positive = 0;
        int negative = 0;
        System.out.println("\nPositivo = "+positive);
        System.out.println("\nNegativo = "+negative);
    }

}
