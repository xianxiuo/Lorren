package com.argumentum.springtransation.service.impl;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.argumentum.springtransation.entity.User;
import com.argumentum.springtransation.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})  
public class UserServiceImplTest {
    
    private static final String CREATE_USER = "create table tb_user(id integer primary key generated by default as identity, name varchar(20))";

    @Resource(name = "userService")
    private UserService userService;
    
    @Before
    public void before() {
//        System.out.println("Before =============================================");
//        userService.execute("CREATE TABLE tb_user(id INTEGER, name VARCHAR(200))");
//        userService.execute("COMMIT;");
//        User user = new User();
//        user.setName("Lorren Wang");
//        userService.createUser(user);
//        user.setName("Sorimo Chen");
//        userService.createUser(user);
//        user.setName("Darimo Chen");
//        userService.createUser(user);
//        user.setName("Sara Wang");
//        userService.createUser(user);
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