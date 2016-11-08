package com.lcc.gyl.login.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lcc.gyl.login.service.LoginService;

Controller(name="loginAction")
@Scope("prototype")
public class LoginAction  {
	@Resource(name="loginService")
	private LoginService loginService;
	
}
