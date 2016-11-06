package com.lcc.gyl.business.base.service.impl;

import java.io.Serializable;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.BaseBusinessService;
import com.lcc.gyl.query.BaseQuery;
import com.lcc.gyl.query.PageResult;
import com.sun.org.apache.regexp.internal.recompile;

public abstract class BaseBusinessServiceImpl<T, E extends Serializable> implements BaseBusinessService<T, E> {
	// 得到主表的dao
	public abstract BaseDao<T> getBaseDao_zhu();

	// 得到字表的dao
	public abstract BaseDao<E> getBaseDao_zhi();

	/**
	 * 得到主表的分页
	 */
	public PageResult<T> getEntrties_zhu(BaseQuery baseQuery) {
		return this.getBaseDao_zhu().findPageResult(baseQuery);
	}
	
	/**
	 * 得到字表的分页
	 */
	public PageResult<E> getEntrties_zi(BaseQuery baseQuery) {
		return this.getBaseDao_zhi().findPageResult(baseQuery);
	}
	
	public String getMax(){
		return this.getBaseDao_zhu().getMax();
	}
	
	/**
	 * 保存主表，级联保存子表
	 */
	public void saveEntry_zhu(T t) {
		// TODO Auto-generated method stub
		this.getBaseDao_zhu().saveEntry(t);
	}
	
	
}
