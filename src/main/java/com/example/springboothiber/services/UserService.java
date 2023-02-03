package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.User;
import com.example.springboothiber.model.request.UserRequest;
import com.example.springboothiber.model.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserResponse readByLogin(String login);
    UserResponse read(Long id);
    List<UserResponse> readAll();
    User setRoleToUser(String login, String name);
    User create(UserRequest request);
    boolean delete(Long id);
    boolean update(UserRequest request, Long id);
}
