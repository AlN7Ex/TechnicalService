package com.example.springboothiber.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OwnerResponse {
    private final String firstName;
    private final String lastName;
}
