package com.lcc.gyl.login.dao;

import com.lcc.gyl.domain.basedata.User;

public interface LoginDao {
	public User authentication(String username,String password);

}
