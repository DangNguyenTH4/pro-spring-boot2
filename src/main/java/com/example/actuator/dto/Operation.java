package com.example.actuator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Operation {
    private String name;
    private boolean successful;
}
