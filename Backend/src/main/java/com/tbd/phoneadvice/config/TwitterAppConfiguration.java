package com.tbd.phoneadvice.config;

//PROFE


import com.tbd.phoneadvice.kafka.TwitterListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Map;
import java.util.HashMap;

@Configuration
@ConditionalOnClass({TwitterStreamFactory.class,TwitterStream.class, TwitterListener.class})

//@EnableConfigurationProperties(TwitterConfiguration.class)

public class TwitterAppConfiguration {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public static final String CONSUMER_KEY = "V7zUq8rn4yQEYsFR5T8eloOnl";
    public static final String CONSUMER_SECRET = "evBzrijWUwvDdtGMyhh5k4uYbaYLsqnA3iagREHll3KOD2cwrx";
    public static final String ACCESS_TOKEN = "1132408406046846977-LZe7i4H22c8sXXNwycJWeyiZjufSky";
    public static final String TOKEN_SECRET = "UU7zoY4ZwgLBpG10mXvbBdvi5dNIAvg91O1O3Upe3M81W";

    @Bean
    @ConditionalOnMissingBean
    public TwitterStreamFactory twitterStreamFactory() {
        ConfigurationBuilder configurationBuilder=new ConfigurationBuilder();
        configurationBuilder
                .setDebugEnabled(false)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TOKEN_SECRET)
                .setJSONStoreEnabled(true);
        return new TwitterStreamFactory(configurationBuilder.build());
    }
    @Bean
    @ConditionalOnMissingBean
    public TwitterFactory twitterFactory() {
        ConfigurationBuilder configurationBuilder=new ConfigurationBuilder();
        configurationBuilder
                .setDebugEnabled(false)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TOKEN_SECRET);
        return new TwitterFactory(configurationBuilder.build());
    }

    @Bean
    @ConditionalOnMissingBean
    public TwitterStream twitterStream(TwitterStreamFactory twitterStreamFactory) {
        return twitterStreamFactory.getInstance();
    }

    @Bean
    @ConditionalOnMissingBean
    public Twitter twitter(TwitterFactory twitterFactory) {
        return twitterFactory.getInstance();
    }

    @Bean
    @ConditionalOnMissingBean
    public TwitterListener twitterListener() {
        return new TwitterListener();
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}


