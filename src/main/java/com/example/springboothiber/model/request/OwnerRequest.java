package com.example.springboothiber.model.request;

import lombok.Data;

@Data
public class OwnerRequest {
    private String firstName;
    private String lastName;
    private int age;
}
