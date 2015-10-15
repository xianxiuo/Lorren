package com.lorren.springtransation.service;

import java.util.List;

import com.lorren.springtransation.entity.User;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);
    
    void execute(String sql);

}
