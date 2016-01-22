package com.lorren.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lorren.entity.User;
import com.lorren.service.UserService;
import com.lorren.util.ConstantPath;
import com.lorren.util.ConstantValue;

@Controller
@RequestMapping(ConstantPath.USERS)
public class UserRest {
    
    private static Logger logger = Logger.getLogger(UserRest.class);  

    @Resource(name = "userService")
    private UserService userService;
    
    @RequestMapping(value = ConstantPath.USERS_GET_JSON, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<User> getUsersToJSON(@PathVariable(ConstantValue.PARAM_ID) String id) {
        List<User> users = new ArrayList<User>();
        if (id.equalsIgnoreCase(ConstantValue.VALUE_ALL)) {
            users = userService.getAllUsers();
        } else if (id.equalsIgnoreCase("condition")) {
            users = userService.getUsersByCondition();
        } else {
            Long longID = null;
            try {
                longID = Long.parseLong(id);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
            users.add(userService.getUser(longID));
        }
        return users;
    }
    
    @RequestMapping(value = ConstantPath.USERS_CREATE_JSON, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public User createUserByJSON(@RequestBody User user) {
        return userService.createUser(user);
    }
    
}
