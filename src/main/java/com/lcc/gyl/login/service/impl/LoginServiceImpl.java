package com.lcc.gyl.login.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lcc.gyl.domain.basedata.User;
import com.lcc.gyl.login.dao.LoginDao;
import com.lcc.gyl.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	public User authentication(String username, String password) {
		return this.loginDao.authentication(username, password);
	}

}
