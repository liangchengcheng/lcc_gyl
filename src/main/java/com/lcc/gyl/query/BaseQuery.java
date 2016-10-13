package com.lcc.gyl.query;

import java.util.HashMap;
import java.util.Map;

/**
 * 1提供一个抽象的方法让子类完成，具体的页面上的表单元素封装成mao 2提供一个map<String,object>由子类使用
 * 
 * @author lcc
 *
 */
public abstract class BaseQuery {

	/** 当前的页码，初始化的值为1 */
	private int currentPage = 1;
	/** 一页显示的条数 */
	private int pageSize = 2;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 把页面上表单中的表单元素封装成map了
	 */
	public Map<String, Object> keyValues = new HashMap<String, Object>();

	public Map<String, Object> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(Map<String, Object> keyValues) {
		this.keyValues = keyValues;
	}

	/**
	 * 把页面上的查询条件封装成一个Map<String,Object> 并且返回
	 * 
	 * @return
	 */
	public abstract Map<String, Object> buildWhere();

}
