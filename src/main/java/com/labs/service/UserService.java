package com.labs.service;

import com.labs.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    User addUser(User user);
    User updateUser(String id, User user);
    boolean deleteUser(String id);
}
