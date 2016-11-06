package com.lcc.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.base.service.impl.BaseServiceImpl;
import com.lcc.gyl.basedata.dao.UserDao;
import com.lcc.gyl.basedata.service.UserService;
import com.lcc.gyl.domain.basedata.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public BaseDao getBaseDao() {
		return this.userDao;
	}

}
