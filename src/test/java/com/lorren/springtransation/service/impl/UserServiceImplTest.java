package com.lorren.springtransation.service.impl;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lorren.springtransation.entity.User;
import com.lorren.springtransation.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})  
public class UserServiceImplTest {
    
    @Resource(name = "userService")
    private UserService userService;
    
    @Before
    public void before() {
    }

    @Test
    public void testStore() {
        User user = new User();
        user.setName("Lorren Wang");
        userService.createUser(user);
    }

    @Test
    public void testDeleteById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFineById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.getAllUsers();
        System.out.println(users);
    }

}
