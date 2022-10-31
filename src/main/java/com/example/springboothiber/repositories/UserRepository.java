package com.example.springboothiber.repositories;

import com.example.springboothiber.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User getUserByLogin(String login);
    public List<User> findAll();
}
