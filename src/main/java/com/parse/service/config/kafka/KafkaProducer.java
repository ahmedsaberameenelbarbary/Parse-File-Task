package com.parse.service.config.kafka;

import com.parse.service.model.CsvModel;
import com.parse.service.util.GenericUtil;
import com.parse.service.util.LogMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaProducer {

    private KafkaTemplate<String, CsvModel> kafkaTemplate;
    private KafkaMessage kafkaMessage;


    public void sendMessage(List<CsvModel> models) {

        sendModelList(models);

    }

    private void sendModelList(List<CsvModel> models) {

        if (GenericUtil.isObjectEmpty(models))
            return;

        log.info(LogMessage.logSentMessage, models.size());

        models.forEach(obj -> kafkaTemplate.send(kafkaMessage.setMessage(obj)));
    }

}