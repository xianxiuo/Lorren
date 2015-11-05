package com.lorren.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lorren.dao.AccountDAO;
import com.lorren.dao.UserDAO;
import com.lorren.entity.Account;
import com.lorren.entity.User;
import com.lorren.service.UserService;
import com.lorren.util.SecurityUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDAO")
    private UserDAO userDAO;
    @Resource(name = "accountDAO")
    private AccountDAO accountDAO;

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }
    
    public User getUser(Long id) {
        return null == id ? null : userDAO.getById(id);
    }

    public User createUser(User user) {
        user = resetUser(user);
        userDAO.insert(user);
        if (!CollectionUtils.isEmpty(user.getAccounts())) {
            for (Account account : user.getAccounts()) {
                account = resetAccount(account, user.getId());
                accountDAO.insert(account);
            }
        }
        return user;
    }
    
    public List<User> getUsersByCondition() {
        return userDAO.getUsersByCondition();
    }
    
    private User resetUser(User user) {
        long now = (new Date()).getTime();
        user.setCreatetime(new Timestamp(now));
        user.setUpdatetime(new Timestamp(now));
        user.setCreator(-1L);
        return user;
    }
    
    private Account resetAccount(Account account, Long userID) {
        long now = (new Date()).getTime();
        account.setUserid(userID);
        account.setToken(SecurityUtils.generateToken());
        account.setPassword(SecurityUtils.encodePassword(account.getPassword()));
        account.setCreatetime(new Timestamp(now));
        account.setUpdatetime(new Timestamp(now));
        account.setCreator(-1L);
        return account;
    }
}
