package com.lorren.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lorren.dao.UserDAO;
import com.lorren.entity.User;
import com.lorren.mapper.UserMapper;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public User getById(Long id) {
       return userMapper.getUserByID(id); 
    }
    
    public List<User> getAll() {
        return userMapper.getUserAll();
     }
    
    public int insert(User user) {
        return userMapper.insertUser(user);
    }

    public int update(User user) {
        // TODO Auto-generated method stub
        return 0;
    }

}
