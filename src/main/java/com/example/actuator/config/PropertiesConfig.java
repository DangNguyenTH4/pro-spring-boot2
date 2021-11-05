package com.example.actuator.config;

import com.example.actuator.interceptor.ToDoMetricInterceptor;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

@EnableConfigurationProperties({ToDoProperties.class})
@Configuration
public class PropertiesConfig {
    @Bean
    public MappedInterceptor metricInterceptor(MeterRegistry meterRegistry){
        return new MappedInterceptor(new String[]{"/**"}, new ToDoMetricInterceptor(meterRegistry));
    }
}
