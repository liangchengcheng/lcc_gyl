package com.lcc.gyl.login.service;

import com.lcc.gyl.domain.basedata.User;

public interface LoginService {
	public User authentication(String username,String password);
}
