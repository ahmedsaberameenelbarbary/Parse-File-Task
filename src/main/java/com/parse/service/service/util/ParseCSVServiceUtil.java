package com.parse.service.service.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.parse.service.config.PropertyConfig;
import com.parse.service.exception.cust.exeption.InvalidFileException;
import com.parse.service.model.CsvModel;
import com.parse.service.util.AppConstants;
import com.parse.service.util.LogMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParseCSVServiceUtil {

    private final PropertyConfig properties;

    public <T> List<T> convertToModel(MultipartFile file, Class<T> responseType) {

        long start = System.currentTimeMillis();

        String methodName = "convertToModel";

        List<T> models;

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<?> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(responseType)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            models = (List<T>) csvToBean.parse();

        } catch (Exception ex) {

            log.error(LogMessage.logErrorMessage, methodName, ex.getMessage(), System.currentTimeMillis() - start);

            throw new InvalidFileException(ex.getCause().getMessage());
        }
        return models;
    }

    public void writeDataInFile(CsvModel model, String fileName) {

        long start = System.currentTimeMillis();

        String methodName = "writeDataInFile";

        try (FileWriter fw = new FileWriter(properties.getBaseDirectory().concat(fileName).concat(AppConstants.File.extension), true);

             BufferedWriter bw = new BufferedWriter(fw);

             PrintWriter out = new PrintWriter(bw)) {

            out.println(model.getId()
                    .concat(" | ")
                    .concat(model.getName())
                    .concat(" | ") + model.getAmount());

            out.println("-----------------------------------");

        } catch (IOException ex) {
            log.error(LogMessage.logErrorMessage, methodName, ex.getMessage(), System.currentTimeMillis() - start);
        }

    }

    public double calculateFees(Double amount) {
        return amount / 10;
    }

    public double addFees(Double amount) {

        return amount + calculateFees(amount);
    }

    public double changeEGPToDollar(Double amount) {

        return amount / 20;
    }

    public double changeEGPToDollarAndAddFees(Double amount) {

        return addFees(changeEGPToDollar(amount));
    }

}
