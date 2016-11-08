package com.lcc.gyl.login.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lcc.gyl.base.action.BaseAction;
import com.lcc.gyl.domain.basedata.User;
import com.lcc.gyl.login.service.LoginService;


@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	@Resource(name="loginService")
	private LoginService loginService;
	
	public String authentication(){
		User user = this.loginService.authentication(this.getModel().getUsername(), this.getModel().getPassword());
		
		if (user == null) {
			this.addActionError("用户名或者密码的错误");
			return "login";
		}else{
			this.getSession().setAttribute("user", user);;
			return "index";
		}
	}
	
}
