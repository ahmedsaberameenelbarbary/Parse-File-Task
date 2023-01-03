package com.parse.service.service;

import com.parse.service.model.CsvModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ParseCSV {

    List<CsvModel> convertToModel(MultipartFile file);
}
