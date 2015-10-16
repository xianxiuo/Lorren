package com.lorren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lorren.dao.UserDAO;
import com.lorren.entity.User;
import com.lorren.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDAO userDao;

    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    public User createUser(User user) {
        return this.userDao.merge(user);
    }
}
