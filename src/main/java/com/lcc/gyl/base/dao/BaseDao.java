package com.lcc.gyl.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import com.lcc.gyl.query.BaseQuery;
import com.lcc.gyl.query.PageResult;

public interface BaseDao<T> {

	/**
	 * 分页查询
	 * @param baseQuery
	 * @return
	 */
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	
	/**
	 * 不分页查询
	 * @return
	 */
	public Collection<T> findEntry();
	
	/**
	 * 保存
	 * @param t
	 */
	public void saveEntry(T t);
	
	/**
	 * 修改
	 * @param t
	 */
	public void updateEntry(T t);
	
	/**
	 * 根据ids删除一些数据
	 * @param ids
	 */
	public void deleteEntryByIDS(Serializable[] ids);
	
	public void  deleteEntry(Serializable id);
	
	/**
	 * 根据id取出一个数据来
	 */
	public T getEntryById(Serializable id);
	
	/**
	 * 根据ids取出很多数据
	 */
	public Set<T> getEntriesByIds(Serializable[]ids);
	
	/**
	 * 查询每一个表的总的记录数
	 * @param baseQuery
	 * @return
	 */
	public int getCount(final BaseQuery baseQuery);
	
	/**
	 * 计算某个订单号的最大值
	 * @return
	 */
	public String getMax();
	
}
