package com.lorren.springtransation.dao.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lorren.springtransation.dao.UserDAO;
import com.lorren.springtransation.entity.User;

@Transactional
@Repository("userDao")
public class UserDAOJPAImpl extends BaseDAOJPAImpl<User> implements UserDAO {

}
