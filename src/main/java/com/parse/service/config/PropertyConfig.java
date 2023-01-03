package com.parse.service.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({@PropertySource(value = "classpath:application.yml", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:application-${spring.profiles.active}.yml", ignoreResourceNotFound = true)})
@Getter
public class PropertyConfig {

    @Value("${file.upload.base-directory}")
    private String baseDirectory;

}
