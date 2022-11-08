package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.User;
import com.example.springboothiber.model.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User readByLogin(String login);
    User read(Long id);
    List<User> readAll();
    User setRoleToUser(String login, String name);
    User create(UserRequest request);
    boolean delete(Long id);
    boolean update(UserRequest request, Long id);
}
