package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User read(String login);
    List<User> readAll();
}
