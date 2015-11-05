package com.lorren.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.lorren.entity.User;
import com.lorren.service.UserService;
import com.lorren.util.ConstantPath;
import com.lorren.util.ConstantValue;

@Controller
@Path(ConstantPath.USERS)
public class UserRest {
    
    private static Logger logger = Logger.getLogger(UserRest.class);  

    @Resource(name = "userService")
    private UserService userService;
    
    @GET
    @Path(ConstantPath.USERS_GET_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersToJSON(@PathParam(ConstantValue.PARAM_ID)@DefaultValue(ConstantValue.VALUE_ALL)String id) {
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
    
    @POST
    @Path(ConstantPath.USERS_CREATE_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUserByJSON(User user) {
        return userService.createUser(user);
    }
    
    @GET
    @Path(ConstantPath.USERS_GET_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersToXML(@PathParam(ConstantValue.PARAM_ID)@DefaultValue(ConstantValue.VALUE_ALL)String id) {
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
    
    @POST
    @RolesAllowed({"ROLE_ADMIN"})
    @Path(ConstantPath.USERS_CREATE_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public User createUserByXML(User user) {
        return userService.createUser(user);
    }
    
}
