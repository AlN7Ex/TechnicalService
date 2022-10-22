package com.example.springboothiber.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarResponse {
    private final String model;
    private final String brand;
}
