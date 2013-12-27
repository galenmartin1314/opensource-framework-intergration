package com.gm.ofi.orm.mybatis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.ofi.orm.mybatis.dao.BaseMapper;
import com.gm.ofi.orm.mybatis.dao.UsersMapper;
import com.gm.ofi.orm.mybatis.model.Users;
import com.gm.ofi.orm.mybatis.model.UsersExample;
import com.gm.ofi.orm.mybatis.service.BaseServiceImpl;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users, UsersExample> {
	@Inject
	private UsersMapper userMapper;
	
	@Override
	protected BaseMapper<Users, UsersExample> getDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}

