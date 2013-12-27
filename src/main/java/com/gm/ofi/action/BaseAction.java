package com.gm.ofi.action;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction extends ActionSupport implements Preparable,Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 清空ActionError
	 */
	public void prepare(){
		clearErrorsAndMessages();
	}
}
