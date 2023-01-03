package com.parse.service.config.kafka;

import com.parse.service.model.CsvModel;
import com.parse.service.service.util.ParseCSVServiceUtil;
import com.parse.service.util.AppConstants;
import lombok.AllArgsConstructor;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaMessage {

    private ParseCSVServiceUtil parseCSVServiceUtil;


    protected Message<CsvModel>  setMessage(CsvModel obj) {

            String topic ="";

                    if(obj.getAmount() > 1000 ) {

                     topic=   AppConstants.Topics.largeAmountTopic;

                     obj.setAmount(parseCSVServiceUtil.changeEGPToDollarAndAddFees(obj.getAmount()));

                    }else {

                       topic= AppConstants.Topics.lessAmountTopic;

                       obj.setAmount(parseCSVServiceUtil.addFees(obj.getAmount()));
                    }

            return MessageBuilder
                    .withPayload(obj)
                    .setHeader(KafkaHeaders.TOPIC, topic)
                    .build();

    }
}