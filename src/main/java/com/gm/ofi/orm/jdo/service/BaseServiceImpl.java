package com.gm.ofi.orm.jdo.service;

import com.gm.ofi.orm.jdo.dao.BaseDAO;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	public abstract BaseDAO<T> getDao();
	@Override
	public boolean save(T obj) {
		// TODO Auto-generated method stub
		return getDao().save(obj);
	}

}
