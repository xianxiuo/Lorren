package com.lorren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.lorren.entity.User;

public interface UserMapper {

    @Select("select * from tb_user where id = #{id}")
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

    @Select("select * from tb_user")
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

    @Insert({
        "insert into app.tb_user( ",
            "name, email, address, phone, enabled, createtime, updatetime, creator ",
        ") values( ",
            "#{name}, #{email}, #{address}, #{phone}, #{enabled}, #{createtime}, #{updatetime}, #{creator} ",
        ")"})
//    parameterType="EStudent" useGeneratedKeys="true" keyProperty="id"
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    @SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = {"select LAST_INSERT_ID()"})
    long insertUser(User user);

}
