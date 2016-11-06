package com.lcc.gyl.business.xsgl.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lcc.gyl.domain.busness.Xsfhdzhib;
import com.lcc.gyl.query.business.XsfhdzhubQuery;

@Controller("xsfhdAction")
@Scope("prototype")
public class XsfhdAction {
	private XsfhdzhubQuery query_zhu = new XsfhdzhubQuery();
	private List<Xsfhdzhib> xsfhdzhibs;

	public XsfhdzhubQuery getQuery_zhu() {
		return query_zhu;
	}

	public void setQuery_zhu(XsfhdzhubQuery query_zhu) {
		this.query_zhu = query_zhu;
	}

	public List<Xsfhdzhib> getXsfhdzhibs() {
		return xsfhdzhibs;
	}

	public void setXsfhdzhibs(List<Xsfhdzhib> xsfhdzhibs) {
		this.xsfhdzhibs = xsfhdzhibs;
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		return null;
	}
}
