package com.gm.ofi.orm.mybatis.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gm.ofi.orm.mybatis.dao.BaseMapper;

public abstract class BaseServiceImpl<T,E> implements BaseService<T, E> {
//	protected abstract BaseMapper<T, E> getDAO();
	protected abstract BaseMapper<T, E> getDAO();
	
	/**
	 * 
	 * @param T Mybatis Example对象
	 * @return 查询数量
	 */
    public int countByExample(E example){
    	return getDAO().countByExample(example);
    }
	
    /**
	 * 
	 * @param T Mybatis Example对象
	 * @return 影响行数
	 */
    public int deleteByExample(E example){
    	return getDAO().deleteByExample(example);
    }

    /**
     * 
     * @param id 数据表主键
     * @return 影响行数
     */
    public int deleteByPrimaryKey(Serializable id){
    	return getDAO().deleteByPrimaryKey(id);
    }

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    public int insert(T record){
    	return getDAO().insert(record);
    }

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    public int insertSelective(T record){
    	return getDAO().insertSelective(record);
    }

    /**
	 * 
	 * @param T Mybatis Example对象
	 * @return POJO实体列表
	 */
    public List<T> selectByExample(E example){
    	return getDAO().selectByExample(example);
    }

    /**
     * 
     * @param id 数据表主键
     * @return POJO实体对象
     */
    public T selectByPrimaryKey(Serializable id){
    	return getDAO().selectByPrimaryKey(id);
    }

    /**
     * 
     * @param record POJO实体对象
     * @param example Mybatis Example对象
     * @return 影响行数
     */
    public int updateByExampleSelective(@Param("record") T record, @Param("example") E example){
    	return getDAO().updateByExampleSelective(record, example);
    }

    /**
     * 
     * @param record POJO实体对象
     * @param example Mybatis Example对象
     * @return 影响行数
     */
    public int updateByExample(@Param("record") T record, @Param("example") E example){
    	return getDAO().updateByExample(record, example);
    }

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    public int updateByPrimaryKeySelective(T record){
    	return getDAO().updateByPrimaryKeySelective(record);
    }

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    public int updateByPrimaryKey(T record){
    	return getDAO().updateByPrimaryKey(record);
    }
}
