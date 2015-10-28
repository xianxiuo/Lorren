package com.lorren.dao;

import java.util.List;

import com.lorren.entity.User;

public interface UserDAO {
    
    List<User> getAll();

    User getById(Long id);
    
    int insert(User user);
    
    int update(User user);

}