package com.lcc.gyl.query.business;

import java.util.Map;

import com.lcc.gyl.query.BaseQuery;

public class XsfhdzhibQuery extends BaseQuery{

	private Long xsfhdzhubid;

	public Long getXsfhdzhubid() {
		return xsfhdzhubid;
	}
	public void setXsfhdzhubid(Long xsfhdzhubid) {
		this.xsfhdzhubid = xsfhdzhubid;
	}
	
	
	@Override
	public Map<String, Object> buildWhere() {
		if (xsfhdzhubid != null) {
			this.keyValues.put("xsfhdzhub.xsfhdzhubid", this.xsfhdzhubid);
		}
		return this.keyValues;
	}

}
