package com.lorren.dao.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lorren.dao.UserDAO;
import com.lorren.entity.User;

@Transactional
@Repository("userDao")
public class UserDAOJPAImpl extends BaseDAOJPAImpl<User> implements UserDAO {

}
