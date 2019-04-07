package com.tbd.phoneadvice.mongo.repositories;

import com.tbd.phoneadvice.mongo.models.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, Long >{

    Tweet findTweetById(String id);
    Tweet findTweetByName(String name);
}