package com.tbd.phoneadvice.config;
import com.tbd.phoneadvice.sentiment.Classifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;


@Configuration
public class SentimentAnalysisApplicationConfiguration {

    @Bean
    public Classifier classifier() {
        return new Classifier();
    }

}
