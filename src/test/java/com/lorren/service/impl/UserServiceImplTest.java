package com.lorren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lorren.entity.User;
import com.lorren.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:/*-spring.xml"})  
public class UserServiceImplTest {
    
    @Resource(name = "userService")
    private UserService userService;
    
    @Before
    public void before() {
    }

    @Test
    public void testStore() {
//        User user = new User();
//        user.setName("Lorren Wang");
//        userService.createUser(user);
        Assert.assertTrue(true);
    }

    @Test
    public void testDeleteById() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFineById() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        Assert.assertTrue(true);
    }

}
