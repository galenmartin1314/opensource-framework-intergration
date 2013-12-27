package com.gm.ofi.orm.hibernate.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.ofi.orm.hibernate.dao.BaseDAO;
import com.gm.ofi.orm.hibernate.dao.impl.UsersDAOImpl;
import com.gm.ofi.orm.hibernate.model.Users;
import com.gm.ofi.orm.hibernate.service.BaseServiceImpl;
import com.gm.ofi.orm.hibernate.service.UsersService;
@Service
public class UsersServiceImpl extends BaseServiceImpl<Users> implements UsersService {
	@Inject
	private UsersDAOImpl userDAO;

	@Override
	protected BaseDAO<Users> getDAO(String who) {
		// TODO Auto-generated method stub
		if(who.equals("default"))
			return userDAO;
		else
			return null;
	}
}
