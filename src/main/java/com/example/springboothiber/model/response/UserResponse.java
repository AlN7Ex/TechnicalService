package com.example.springboothiber.model.response;

import com.example.springboothiber.model.entity.Role;
import lombok.Data;
import java.util.Set;

@Data
public class UserResponse {
    private String login;
    private String firstname;
    private String lastname;
    private int age;
    private Set<Role> roles;

    public void addRole(Role role) {
        roles.add(role);
    }
}
