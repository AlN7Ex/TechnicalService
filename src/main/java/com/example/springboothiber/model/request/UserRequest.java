package com.example.springboothiber.model.request;

import lombok.Data;

@Data
public class UserRequest {
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
}
