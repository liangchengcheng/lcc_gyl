package com.lcc.gyl.business.base.service;

import java.io.Serializable;

import com.lcc.gyl.query.BaseQuery;
import com.lcc.gyl.query.PageResult;

/**
 * 关于业务逻辑的抽象接口
 * @author lcc
 *
 * @param <T>
 * @param <E>
 */
public interface BaseBusinessService<T,E extends Serializable> {
	//返回主表的分页
	public PageResult<T> getEntrties_zhu(BaseQuery baseQuery);
	//返回子表的分页
	public PageResult<E> getEntrties_zi(BaseQuery baseQuery);
	
	/**
	 * 得到订单号的值+1
	 * @return
	 */
	public String getMax();
	
	/**
	 * 保存主表 级联保存子表
	 * @param t
	 */
	public void saveEntry_zhu(T t);
}
