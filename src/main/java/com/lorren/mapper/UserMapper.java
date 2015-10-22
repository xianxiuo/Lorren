package com.lorren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lorren.entity.User;

public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE id = #{userID}") 
    User getUser(@Param("userID")long id);
    
    @Select("SELECT * FROM tb_user") 
    List<User> getAll();

}
