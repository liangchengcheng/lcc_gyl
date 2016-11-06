package com.lcc.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.lcc.gyl.base.dao.impl.BaseDaoImpl;
import com.lcc.gyl.basedata.dao.UserDao;
import com.lcc.gyl.domain.basedata.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
