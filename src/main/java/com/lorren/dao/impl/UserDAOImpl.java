package com.lorren.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lorren.dao.UserDAO;
import com.lorren.entity.User;
import com.lorren.mapper.UserMapper;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
    
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public User getUserById(User user) {
       return userMapper.getUser(user.getId()); 
    }
    
    public List<User> getAll() {
        return userMapper.getAll();
     }

}
