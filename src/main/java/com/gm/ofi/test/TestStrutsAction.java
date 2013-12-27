package com.gm.ofi.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gm.ofi.action.BaseAction;
@Controller("testStrutsAction")
@Scope("session")
public class TestStrutsAction extends BaseAction {
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String save(){
		setMessage("The Struts2 MVC!");
		return "freemarker";
	}

}
