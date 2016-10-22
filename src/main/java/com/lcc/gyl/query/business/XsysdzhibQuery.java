package com.lcc.gyl.query.business;

import java.util.Map;

import com.lcc.gyl.query.BaseQuery;

public class XsysdzhibQuery extends BaseQuery {
	
	private Long xsysdzhubid;

	public Long getXsysdzhubid() {
		return xsysdzhubid;
	}

	public void setXsysdzhubid(Long xsysdzhubid) {
		this.xsysdzhubid = xsysdzhubid;
	}
	
	
	@Override
	public Map<String, Object> buildWhere() {
		if (xsysdzhubid != null) {
			this.keyValues.put("xsysdzhub.xsysdzhubid", this.xsysdzhubid);
		}
		return this.keyValues;
	}
}
