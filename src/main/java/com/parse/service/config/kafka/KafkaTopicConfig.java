package com.parse.service.config.kafka;

import com.parse.service.util.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic lessAmountTopic(){
        return TopicBuilder.name( AppConstants.Topics.lessAmountTopic).build();
    }

    @Bean
    public NewTopic largeAmountTopic(){
        return TopicBuilder.name( AppConstants.Topics.largeAmountTopic).build();
    }
}
