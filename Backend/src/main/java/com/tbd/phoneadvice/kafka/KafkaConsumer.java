package com.tbd.phoneadvice.kafka;


import java.io.StringReader;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tbd.phoneadvice.mongo.models.Tweet;
import com.tbd.phoneadvice.mongo.repositories.TweetRepository;
import lombok.var;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import twitter4j.*;

import twitter4j.json.DataObjectFactory;

@Service
@EnableScheduling
public class KafkaConsumer {

    @Autowired
    Consumer<Long,String> consumer;

    @Autowired
    private TweetRepository tweetRepository;

    private boolean status;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        java.util.Date date = new java.util.Date();

        this.status = true;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
        Gson gson = gsonBuilder.create();
        //JsonReader reader = new JsonReader(new StringReader("s"));
        Type type = new TypeToken<Tweet>() {}.getType();

        while(status) {
            ConsumerRecords<Long, String> records = consumer.poll(Duration.of(1, ChronoUnit.SECONDS));
            for (ConsumerRecord<Long, String> record : records) {

                //Status s = TwitterObjectFactory.createStatus(record.value());

                //System.out.println(record.value());
/*
                try {
                    /*
                    String e = record.value();
                    String p = e.substring(e.indexOf("id"), e.lastIndexOf("}") + 1);
                    String f = "{" + p;
                    Status s = TwitterObjectFactory.createStatus(f);
                    System.out.println("\n"+s+"\n");
                    System.out.println(s.getText());

                    //JsonParser parser = new JsonParser();

                    //String retVal = parser.parse(record.value()).getAsString();

                    //Status s = TwitterObjectFactory.createStatus(retVal);
                    //System.out.println(s.getText());


                }catch(TwitterException name){
                    System.out.println(name);
                }
            */

                //record.value().replace("StatusJSONImpl","");
                //Tweet incomingTweet = new ObjectMapper().readValue(record.value(), Tweet.class);

                    //JsonConvert j = new JsonConvert();
                    //var result = JsonConvert.DeserializeObject(record.value());

                    //String statusJson = TwitterObjectFactory.getRawJSON(record.value());

                    //JSONObject JSON_complete = new JSONObject(statusJson);


                    //Tweet incomingTweet = gson.fromJson(record.value(), type);
                    //String languageTweet = JSON_user.getString("name");

                    //Gson gsons = new Gson();
                    //String json = gsons.toJson( record.value().replace("StatusJSONImpl","") );

                    //System.out.println( json );
                    //JSONObject JSON_complete = new JSONObject(json);

                    //System.out.println(record.value());
                    //JSONObject f = new JSONObject();
                    //JSONObject d = f.getJSONObject(record.value());
                    //TwitterObjectFactory s = TwitterObjectFactory.

                    //String j = TwitterObjectFactory.getRawJSON(record.value());
                    //String e = record.value();
                    //JSONObject d = new twitter4j.JSONObject(e.substring(e.indexOf("{"), e.lastIndexOf("}") + 1).replace("[]","'null'"));
                    //System.out.println("\nACA FALLO");
                    //JSONObject JSON_user = d.getJSONObject("user");
                    //System.out.println("\nACA FALLO denuevo");
                    //String languageTweet = JSON_user.getString("name");
                    //System.out.println(languageTweet);
                    //Status status = TwitterObjectFactory.createStatus(j);

                    //tweetRepository.save(incomingTweet);

                if (status == false) {
                    break;
                }
            }

        }
    }
    public void stop() { this.status = false; }
}

