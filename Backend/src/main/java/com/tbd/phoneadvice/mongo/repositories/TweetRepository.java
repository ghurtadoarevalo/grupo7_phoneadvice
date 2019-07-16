package com.tbd.phoneadvice.mongo.repositories;

import com.tbd.phoneadvice.mongo.models.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String >{
    Tweet findTweetById(String id);
    List<Tweet> findByUserId(Long id);
}
