package com.lorren.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lorren.dao.AccountDAO;
import com.lorren.entity.Account;
import com.lorren.mapper.AccountMapper;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
    
    @Resource(name = "accountMapper")
    private AccountMapper accountMapper;
    
    public long insert(Account account) {
        return accountMapper.insertAccount(account);
    }

}
