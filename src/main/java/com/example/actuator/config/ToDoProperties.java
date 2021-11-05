package com.example.actuator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/*
If you remember, to use a @ConfigurationProperties
marked class, it is necessary to call it with @EnableConfigurationProperties.
Let’s create the ToDoConfig class to support it
 */
@Data
@ConfigurationProperties(prefix = "todo")
public class ToDoProperties {
    private String path;
}
