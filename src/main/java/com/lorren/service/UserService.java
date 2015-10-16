package com.lorren.service;

import java.util.List;

import com.lorren.entity.User;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

}
