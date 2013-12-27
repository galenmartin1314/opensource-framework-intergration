package com.gm.ofi.orm.jdo.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.jdo.PersistenceManagerFactory;


public class BaseDAOImpl<T> implements BaseDAO<T> {
	@Inject
	protected PersistenceManagerFactory pmf;

	public PersistenceManagerFactory getPmf() {
		return pmf;
	}

	public void setPmf(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@Override
	public boolean save(T obj) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			pmf.getPersistenceManager().makePersistent(obj);
			flag = true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}

}
