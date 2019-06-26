package com.tbd.phoneadvice.mongo.services;


import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.models.User;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import com.tbd.phoneadvice.mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Twitter twitter;

    @RequestMapping(value = "/loadUsers", method = RequestMethod.GET)
    @ResponseBody
    public void loadUsers() {
        List<Tweet> tweetList = tweetRepository.findAll();
        for(int i = 0 ; i < tweetList.size();i++)
        {
            Tweet tweet = tweetList.get(i);
            User user = tweet.getUser();

            try{
                String urlProfile = "https://twitter.com/"+user.getScreenName().replace("@","");
                String urlPhoto = twitter.showUser(user.getId()).getBiggerProfileImageURLHttps();
                String description = twitter.showUser(user.getId()).getDescription();
                String email = twitter.showUser(user.getId()).getEmail();
                Date createdAt = twitter.showUser(user.getId()).getCreatedAt();
                user.setUrlProfile(urlProfile);
                user.setUrlPhoto(urlPhoto);
                user.setCreatedAt(createdAt);
                user.setDescription(description);
                user.setEmail(email);
                userRepository.save(user);

            }catch(TwitterException e){
                System.out.println("\nfalle");
            }
            userRepository.save(user);
        }
    }

    @RequestMapping(value = "/deleteUsers", method = RequestMethod.GET)
    @ResponseBody
    public void deleteUsers() {
        userRepository.deleteAll();
    }
    //OJO: Es posible actualizar tweets con este poroto.



}
