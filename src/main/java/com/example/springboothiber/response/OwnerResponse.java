package com.example.springboothiber.response;

import lombok.Data;

import java.util.List;

@Data
public class OwnerResponse {
    private String firstName;
    private String lastName;
    private List<CarResponse> cars;
}
