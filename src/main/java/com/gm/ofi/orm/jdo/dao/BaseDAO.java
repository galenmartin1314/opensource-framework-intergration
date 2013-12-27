package com.gm.ofi.orm.jdo.dao;

public interface BaseDAO<T> {
	boolean save(T obj);
}
