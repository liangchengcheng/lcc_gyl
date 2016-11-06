package com.lcc.gyl.business.xsgl.dao.impl;

import com.lcc.gyl.base.dao.impl.BaseDaoImpl;
import com.lcc.gyl.business.xsgl.dao.XsddzhibDao;
import com.lcc.gyl.domain.busness.Xsddzhib;

public class XsddzhibDaoImpl extends BaseDaoImpl<Xsddzhib> implements XsddzhibDao{

	public Xsddzhib getXsddzhibByCondition(String ytdjh, Long ythh) {
		return (Xsddzhib)this.hibernateTemplate
				.find("from Xsddzhib where xsddzhub.ddh=? and hh=?",ytdjh,ythh)
				.get(0);
	}

}
