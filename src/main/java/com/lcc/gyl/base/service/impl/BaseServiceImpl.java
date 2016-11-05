package com.lcc.gyl.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.base.service.BaseService;
import com.lcc.gyl.query.BaseQuery;
import com.lcc.gyl.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T>{

	public abstract BaseDao getBaseDao();
	
	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		return this.getBaseDao().findPageResult(baseQuery);
	}

	public Collection<T> getEntries() {
		return this.getBaseDao().findEntry();
	}

	public Set<T> getEntriesByIds(Serializable[] ids) {
		return this.getBaseDao().getEntriesByIds(ids);
	}

	public void savEntry(T t) {
		this.getBaseDao().saveEntry(t);
		
	}

	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
		
	}

	public T getEntryById(Serializable id) {
		return (T)this.getBaseDao().getEntryById(id);
	}

	public void deleteEntriesByIds(Serializable[] ids) {
		this.getBaseDao().deleteEntryByIDS(ids);
		
	}

	public void deleteEntryById(Serializable id) {
		this.getBaseDao().deleteEntry(id);
		
	}
	
}
