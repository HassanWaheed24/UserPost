package com.task.user.serviceInterface;

import com.task.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserById(Long id);
    List<User> getUserByName(String name);
    User addUser(User post);
    User updateUser(Long id, User user);
    User deleteUser(Long id);
}
