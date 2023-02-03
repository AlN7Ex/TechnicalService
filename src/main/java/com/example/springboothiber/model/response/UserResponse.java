package com.example.springboothiber.model.response;

import com.example.springboothiber.model.entity.Role;
import lombok.Data;
import java.util.Set;

@Data
public class UserResponse {
    private Long id;
    private String login;
    private String firstname;
    private String lastname;
    private int age;
    private Set<Role> roles;

    public UserResponse(
            Long id,
            String login,
            String firstname,
            String lastname,
            int age,
            Set<Role> roles) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
