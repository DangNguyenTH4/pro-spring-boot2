package com.example.actuator.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({ToDoProperties.class})
@Configuration
public class PropertiesConfig {
}
