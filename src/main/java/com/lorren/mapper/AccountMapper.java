package com.lorren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lorren.entity.Account;

public interface AccountMapper {
    
    @Select("select * from app.tb_account where userid = #{userid}")
    List<Account> getAccountsByUserID(@Param("userid")Long userID);
    
    @Insert({
        "insert into app.tb_account( ",
            "userid, username, password, token, enabled, createtime, updatetime, creator ",
        ") values( ",
            "#{userid}, #{username}, #{password}, #{token}, #{enabled}, #{createtime}, #{updatetime}, #{creator} ",
        ")" })
    long insertAccount(Account account);

}
