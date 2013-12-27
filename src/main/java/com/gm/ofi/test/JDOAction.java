package com.gm.ofi.test;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gm.ofi.action.BaseAction;
import com.gm.ofi.orm.jdo.model.Users;
import com.gm.ofi.orm.jdo.service.impl.UsersServiceImpl;
@Controller("jdoAction")
@Scope("session")
public class JDOAction extends BaseAction {
	@Inject
	private UsersServiceImpl usersService;
	private String result = "helloo!! Welcome to use JDO ORM Framework!!!";
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String save(){
		Users obj = new Users();
		obj.setUserid(100);
		obj.setUsername("username");
		obj.setPassword("password");
		usersService.save(obj);
		return "save";
	}
}
