package com.gm.ofi.orm.mybatis.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseService<T,E> {
	/**
	 * 
	 * @param T Mybatis Example对象
	 * @return 查询数量
	 */
    int countByExample(E example);

    /**
	 * 
	 * @param T Mybatis Example对象
	 * @return 影响行数
	 */
    int deleteByExample(E example);

    /**
     * 
     * @param id 数据表主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Serializable id);

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    int insert(T record);

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    int insertSelective(T record);

    /**
	 * 
	 * @param T Mybatis Example对象
	 * @return POJO实体列表
	 */
    List<T> selectByExample(E example);

    /**
     * 
     * @param id 数据表主键
     * @return POJO实体对象
     */
    T selectByPrimaryKey(Serializable id);

    /**
     * 
     * @param record POJO实体对象
     * @param example Mybatis Example对象
     * @return 影响行数
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    /**
     * 
     * @param record POJO实体对象
     * @param example Mybatis Example对象
     * @return 影响行数
     */
    int updateByExample(@Param("record") T record, @Param("example") E example);

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 
     * @param record POJO实体对象
     * @return 影响行数
     */
    int updateByPrimaryKey(T record);
}
