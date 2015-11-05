package com.lorren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.scripting.velocity.Driver;

import com.lorren.entity.User;
import com.lorren.mapper.sql.UserSqlBuilder;

@CacheNamespace(size = 512)
public interface UserMapper {

    @SelectProvider(type = UserSqlBuilder.class, method = "selectOneByID")
    @Options(flushCache = true, timeout = 10000)
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "createtime", column = "createtime"),
        @Result(property = "updatetime", column = "updatetime"),
        @Result(property = "creator", column = "creator"),
        @Result(property = "name", column = "name"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "enabled", column = "enabled"),
        @Result(property = "accounts", column = "id", javaType = List.class, many = @Many(select = "com.lorren.mapper.AccountMapper.getAccountsByUserID") ) })
    User getUserByID(@Param("id") Long id);

    @SelectProvider(type = UserSqlBuilder.class, method = "selectAll")
    @Options(flushCache = true, timeout = 10000)
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "createtime", column = "createtime"),
        @Result(property = "updatetime", column = "updatetime"),
        @Result(property = "creator", column = "creator"),
        @Result(property = "name", column = "name"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "enabled", column = "enabled"),
        @Result(property = "accounts", column = "id", javaType = List.class, many = @Many(select = "com.lorren.mapper.AccountMapper.getAccountsByUserID") ) })
    List<User> getUserAll();

    @InsertProvider(type = UserSqlBuilder.class, method = "insert")
    @Options(flushCache = true, timeout = 20000, keyProperty = "id", useGeneratedKeys = true)
    int insertUser(User user);
    
    @Lang(Driver.class)
    @Select({"#set($id = -1) select * from tb_user where id = @{id, jdbcType=BIGINT}"})
    @Options(flushCache = true, timeout = 10000)
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "createtime", column = "createtime"),
        @Result(property = "updatetime", column = "updatetime"),
        @Result(property = "creator", column = "creator"),
        @Result(property = "name", column = "name"),
        @Result(property = "email", column = "email"),
        @Result(property = "address", column = "address"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "enabled", column = "enabled"),
        @Result(property = "accounts", column = "id", javaType = List.class, many = @Many(select = "com.lorren.mapper.AccountMapper.getAccountsByUserID") ) })
    List<User> getUsersByCondition();

}
