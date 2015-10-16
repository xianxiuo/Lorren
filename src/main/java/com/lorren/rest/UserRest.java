package com.lorren.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

import com.lorren.entity.User;
import com.lorren.service.UserService;
import com.lorren.util.ConstantPath;

@Controller
@Path(ConstantPath.USER)
public class UserRest {

    @Resource(name = "userService")
    private UserService userService;
    
    @GET
    @Path(ConstantPath.USER_ALL_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersToJSON() {
        return userService.getAllUsers();
    }
    
    @POST
    @Path(ConstantPath.USER_CREATE_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUserByJSON(User user) {
        return userService.createUser(user);
    }
    
    @GET
    @Path(ConstantPath.USER_ALL_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsersToXML() {
        return userService.getAllUsers();
    }
    
    @POST
    @Path(ConstantPath.USER_CREATE_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public User createUserByXML(User user) {
        return userService.createUser(user);
    }
    
}
