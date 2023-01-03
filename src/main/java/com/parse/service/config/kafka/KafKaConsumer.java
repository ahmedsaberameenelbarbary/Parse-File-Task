package com.parse.service.config.kafka;

import com.parse.service.model.CsvModel;
import com.parse.service.service.util.ParseCSVServiceUtil;
import com.parse.service.util.AppConstants;
import com.parse.service.util.LogMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafKaConsumer {

    private ParseCSVServiceUtil parseCSVServiceUtil;


    @KafkaListener(topics = AppConstants.Topics.lessAmountTopic, groupId = AppConstants.groupId)
    public void consumeLessAmount(CsvModel model) {

        log.info(LogMessage.logReceivedMessage, model);

        parseCSVServiceUtil.writeDataInFile(model,AppConstants.File.lessAmount);

    }

    @KafkaListener(topics = AppConstants.Topics.largeAmountTopic, groupId = AppConstants.groupId)
    public void consumeLargeAmount(CsvModel model) {

        log.info(LogMessage.logReceivedMessage, model);

        parseCSVServiceUtil.writeDataInFile(model,AppConstants.File.largeAmount);
    }

}
