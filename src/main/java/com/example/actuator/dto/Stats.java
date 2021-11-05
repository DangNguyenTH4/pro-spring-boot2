package com.example.actuator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stats {
    private long count;
    private long completed;
}
