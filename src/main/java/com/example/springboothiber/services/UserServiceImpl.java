package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.Role;
import com.example.springboothiber.model.entity.User;
import com.example.springboothiber.model.request.UserRequest;
import com.example.springboothiber.model.response.UserResponse;
import com.example.springboothiber.repositories.RoleRepository;
import com.example.springboothiber.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserResponse readByLogin(String login) {
        User userByLogin = userRepository.getUserByLogin(login);
        if (userByLogin == null){
            return null;
        }

        return new UserResponse(
                userByLogin.getId(),
                userByLogin.getLogin(),
                userByLogin.getFirstname(),
                userByLogin.getLastname(),
                userByLogin.getAge(),
                userByLogin.getRoles()
        );
    }

    @Override
    public UserResponse read(Long id) {
        User userById = userRepository.getUserById(id);
        if (userById == null) {
            return null;
        }
        return new UserResponse(
                userById.getId(),
                userById.getLogin(),
                userById.getFirstname(),
                userById.getLastname(),
                userById.getAge(),
                userById.getRoles()
        );
    }

    @Override
    public List<UserResponse> readAll() {
        List<User> users = userRepository.findAll();
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getLogin(),
                        user.getFirstname(),
                        user.getLastname(),
                        user.getAge(),
                        user.getRoles()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public User setRoleToUser(String login, String name) {
        User userByLogin = userRepository.getUserByLogin(login);
        Role roleByName = roleRepository.getRoleByName(name);
        if (userByLogin != null && roleByName != null) {
            userByLogin.addRole(roleByName);
        }
        return null;
    }

    @Override
    public User create(UserRequest request) {
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setAge(request.getAge());
        Role role = roleRepository.getRoleByName("USER");
        user.addRole(role);

        userRepository.save(user);

        return user;
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.getUserById(id) != null) {
            userRepository.deleteById(id);

            return true;
        }
        return false;
    }

    @Override
    public boolean update(UserRequest request, Long id) {
        User userById = userRepository.getUserById(id);
        if (userById == null) {
            return false;
        }
        userById.setLogin(request.getLogin());
        userById.setPassword(request.getPassword());
        userById.setFirstname(request.getFirstname());
        userById.setLastname(request.getLastname());
        userById.setAge(request.getAge());

        userRepository.save(userById);

        return true;
    }


}
