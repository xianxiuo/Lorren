package com.lorren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.lorren.entity.Account;
import com.lorren.mapper.sql.AccountSqlBuilder;

@CacheNamespace(size = 512)
public interface AccountMapper {

    @SelectProvider(type = AccountSqlBuilder.class, method = "selectAllByUserID")
    @Options(flushCache = true, timeout = 10000)
    List<Account> getAccountsByUserID(@Param("userid")Long userID);

    @InsertProvider(type = AccountSqlBuilder.class, method = "insert")
    @Options(flushCache = true, timeout = 20000, keyProperty = "id", useGeneratedKeys = true)
    int insertAccount(Account account);

}
