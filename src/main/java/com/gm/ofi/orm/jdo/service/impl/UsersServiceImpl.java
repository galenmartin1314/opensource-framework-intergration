package com.gm.ofi.orm.jdo.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.ofi.orm.jdo.dao.BaseDAO;
import com.gm.ofi.orm.jdo.dao.impl.UsersDAOImpl;
import com.gm.ofi.orm.jdo.model.Users;
import com.gm.ofi.orm.jdo.service.BaseServiceImpl;
@Service
public class UsersServiceImpl extends BaseServiceImpl<Users> {
	@Inject
	private UsersDAOImpl userDAO;
	@Override
	public BaseDAO<Users> getDao() {
		// TODO Auto-generated method stub
		return userDAO;
	}
	
}
