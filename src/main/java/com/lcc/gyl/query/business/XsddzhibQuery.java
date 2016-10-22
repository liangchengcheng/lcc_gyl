package com.lcc.gyl.query.business;

import java.util.Map;

import com.lcc.gyl.query.BaseQuery;

public class XsddzhibQuery extends BaseQuery{

	/** 销售订单主表ID */
	private Long xsddzhubid;
	/** 行状态    "1"表示关闭   "2"表示未关闭 */
	private String hstatus;

	public String getHstatus() {
		return hstatus;
	}
	public void setHstatus(String hstatus) {
		this.hstatus = hstatus;
	}
	public Long getXsddzhubid() {
		return xsddzhubid;
	}
	public void setXsddzhubid(Long xsddzhubid) {
		this.xsddzhubid = xsddzhubid;
	}

	
	@Override
	public Map<String, Object> buildWhere() {
		if (xsddzhubid != null) {
			this.keyValues.put("xsddzhub.xsddzhubid", this.xsddzhubid);
		}
		if(hstatus != null){
			this.keyValues.put("hstatus",this.hstatus);
		}
		return this.keyValues;
	}

}
