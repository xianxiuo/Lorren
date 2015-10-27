package com.lorren.mapper.provider;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.lorren.entity.User;
import com.lorren.mapper.sql.UserSqlBuilder;

public interface UserProvider {

    @SelectProvider(type = UserSqlBuilder.class, method = "selectOneByID")
    @Results({ @Result(property = "id", column = "id"), @Result(property = "createtime", column = "createtime"),
            @Result(property = "updatetime", column = "updatetime"), @Result(property = "creator", column = "creator"),
            @Result(property = "name", column = "name"), @Result(property = "email", column = "email"),
            @Result(property = "address", column = "address"), @Result(property = "phone", column = "phone"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "accounts", column = "id", javaType = List.class, many = @Many(select = "com.lorren.mapper.AccountMapper.getAccountsByUserID") ), })
    User getUserByID(@Param("id") Long id);

    @SelectProvider(type = UserSqlBuilder.class, method = "selectAll")
    @Results({ @Result(property = "id", column = "id"),@Result(property = "createtime", column = "createtime"),
            @Result(property = "updatetime", column = "updatetime"), @Result(property = "creator", column = "creator"),
            @Result(property = "name", column = "name"), @Result(property = "email", column = "email"),
            @Result(property = "address", column = "address"), @Result(property = "phone", column = "phone"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "accounts", column = "id", javaType = List.class, many = @Many(select = "com.lorren.mapper.AccountMapper.getAccountsByUserID") ), })
    List<User> getUserAll();

}
