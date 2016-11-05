package com.lcc.gyl.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.lcc.gyl.query.BaseQuery;
import com.lcc.gyl.query.PageResult;

public interface BaseService <T>{

	public PageResult<T> getPageResult(BaseQuery baseQuery);
	
	public Collection<T> getEntries();
	
	public Set<T> getEntriesByIds(Serializable[] ids);
	
	public void savEntry(T t);
	
	public void updateEntry(T t);
	
	public T getEntryById(Serializable id);
	
	public void deleteEntriesByIds(Serializable[] ids);
	
	public void deleteEntryById(Serializable id);
}
