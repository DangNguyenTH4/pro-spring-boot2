package com.example.actuator.indicator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Create ToDoHealthCheck to visit a FileSystem path
 * and perform a check up to see
 * if it is available, readable, and writeable
 */
@Component
public class ToDoHealthCheckIndicator implements HealthIndicator {
    @Value("${todo.path:/tmp}")
    private String path;


    @Override
    public Health health() {
        try {
            File file = new File(path);
            if (file.exists()) {
                if (file.canWrite())
                    return Health.up().withDetail("Oke","hellooke").build();
                return Health.down().build();
            } else {
                return Health.outOfService().build();
            }
        }catch (Exception ex){
            return Health.down(ex).build();
        }
    }
}
