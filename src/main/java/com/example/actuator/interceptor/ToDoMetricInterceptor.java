package com.example.actuator.interceptor;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ToDoMetricInterceptor implements HandlerInterceptor {
    private MeterRegistry meterRegistry;
    private String URI, pathKey, METHOD;

    public ToDoMetricInterceptor(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        URI = request.getRequestURI();
        METHOD = request.getMethod();
        if (!URI.contains("prometheus")) {
            log.info(" >> PATH: {}", URI);
            log.info(" >> METHOD: {}", METHOD);
            pathKey = "api_".concat(METHOD.toLowerCase()).concat(URI.replaceAll("/", "_").toLowerCase());
            this.meterRegistry.counter(pathKey).increment();
        }
    }
}
