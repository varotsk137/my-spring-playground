package com.playground.mail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class PropertiesConfiguration {
    private String host;
    private Integer port;
    private String username;
    private String password;
}
