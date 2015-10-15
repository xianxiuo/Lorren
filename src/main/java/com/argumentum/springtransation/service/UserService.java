package com.argumentum.springtransation.service;

import java.util.List;

import com.argumentum.springtransation.entity.User;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);
    
    void execute(String sql);

}
