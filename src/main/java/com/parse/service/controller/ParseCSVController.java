
package com.parse.service.controller;

import com.parse.service.config.kafka.KafKaConsumer;
import com.parse.service.response.SuccessResponse;
import com.parse.service.service.ParseCSV;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ahmedSaber
 */

@RestController
@RequestMapping("/api/v1/parse")
@RequiredArgsConstructor
@Tag(name = "PARSE-CSV-CONTROLLER")
public class ParseCSVController {

    private final ParseCSV parseCSV;

    private final KafKaConsumer kafKaConsumer;

    @PostMapping("/csv-file")
    @Operation(summary = "parse csv", description = "parsing csv file and convert it into a model ")
    public ResponseEntity<SuccessResponse> parseCSVFile(@RequestParam("file") MultipartFile file) {

        return ResponseEntity
                .ok().body(SuccessResponse.
                        ok(parseCSV.convertToModel(file)));
    }
}

