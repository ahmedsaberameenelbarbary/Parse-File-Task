
package com.parse.service.service.impl;

import com.parse.service.config.kafka.KafkaProducer;
import com.parse.service.exception.cust.exeption.UnParseException;
import com.parse.service.model.CsvModel;
import com.parse.service.service.ParseCSV;
import com.parse.service.service.util.ParseCSVServiceUtil;
import com.parse.service.util.GenericUtil;
import com.parse.service.util.LogMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParseCSVServiceImpl implements ParseCSV {

    private final KafkaProducer kafkaProducer;

    private final ParseCSVServiceUtil serviceUtil;

    public List<CsvModel> convertToModel(MultipartFile file) {

        long start = System.currentTimeMillis();

        String methodName = "convertToModel";

        try {

            List<CsvModel> models = serviceUtil.convertToModel(file, CsvModel.class);

            if (GenericUtil.isNotEmptyList(models))
                kafkaProducer.sendMessage(models);

            log.info(LogMessage.logEndMessage, methodName, System.currentTimeMillis() - start);

            return models;

        } catch (Exception ex) {

            log.error(LogMessage.logErrorMessage, methodName, ex.getMessage(), System.currentTimeMillis() - start);

            throw new UnParseException(ex.getMessage());
        }

    }


}
