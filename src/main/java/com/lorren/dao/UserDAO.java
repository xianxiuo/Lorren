package com.lorren.dao;

import java.util.List;

import com.lorren.entity.User;

public interface UserDAO {
    
    List<User> getAll();

    User getUserById(User user);

}