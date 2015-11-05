package com.lorren.service;

import java.util.List;

import com.lorren.entity.User;

public interface UserService {

    List<User> getAllUsers();
    
    User getUser(Long id);

    User createUser(User user);
    
    List<User> getUsersByCondition();

}
