package com.argumentum.springtransation.dao.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.argumentum.springtransation.dao.UserDAO;
import com.argumentum.springtransation.entity.User;

@Transactional
@Repository("userDao")
public class UserDAOJPAImpl extends BaseDAOJPAImpl<User> implements UserDAO {

}
