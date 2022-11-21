package com.example.springboothiber.controllers;

import com.example.springboothiber.model.entity.User;
import com.example.springboothiber.model.request.UserRequest;
import com.example.springboothiber.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1")
public class UserController {

    private final UserService service;

    public User getUserById(@PathVariable Long id) {
        return service.read(id);
    }

    @GetMapping(value = "/users")
    public User getUserByLogin(@RequestParam String login) {
        return service.readByLogin(login);
    }
    @GetMapping(value = "/users/")
    public List<User> getUsers() {
        return service.readAll();
    }

    // Admin endpoint?
//    @PutMapping(value = "/api/v1/users")
//    public User setRoleToUserByLogin(@RequestParam String login,
//                                     @RequestParam String name) {
//        return service.setRoleToUser(login, name);
//    }

    @PostMapping(value = "/users")
    public User createUserWithDefaultRole(@RequestBody UserRequest request) {
        return service.create(request);
    }

    // Update by unique login seems like better
    @PutMapping(value = "/users/{id}")
    public boolean updateUser(@RequestBody UserRequest request, @PathVariable Long id) {
        return service.update(request, id);
    }

}
