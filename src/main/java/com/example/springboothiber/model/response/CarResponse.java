package com.example.springboothiber.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarResponse {
    private final String brand;
    private final String model;
}
