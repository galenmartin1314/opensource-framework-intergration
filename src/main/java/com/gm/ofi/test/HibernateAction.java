package com.gm.ofi.test;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gm.ofi.action.BaseAction;
import com.gm.ofi.orm.hibernate.model.Users;
import com.gm.ofi.orm.hibernate.service.impl.UsersServiceImpl;

//@Controller("hibernateAction")
//@Scope("session")
public class HibernateAction extends BaseAction {
	@Inject
	private UsersServiceImpl usersService;
	private String result;
	public String isResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String save(){
		for(int i=0;i<100;i++){
		Users obj = new Users();
		obj.setUserid(i);
		obj.setUsername("username");
		obj.setPassword("password");
		result = String.valueOf(usersService.save(obj));
		}
		return "freemarker";
	}
}

