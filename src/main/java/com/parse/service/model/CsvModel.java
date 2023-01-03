package com.parse.service.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsvModel {

    @CsvBindByName(column = "National ID")
    private String id;

    @CsvBindByName(column = "Name")
    private String  name;

    @CsvBindByName(column = "Amount")
    private Double amount;


}
