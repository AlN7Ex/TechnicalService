package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.User;
import com.example.springboothiber.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User read(String login) {
        return repository.getUserByLogin(login);
    }

    @Override
    public List<User> readAll() {
        return repository.findAll();
    }
}
