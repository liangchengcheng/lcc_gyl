package com.lcc.gyl.business.xsgl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lcc.gyl.base.dao.impl.BaseDaoImpl;
import com.lcc.gyl.business.xsgl.dao.XsddzhubDao;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xsddzhub;

@Repository("xsddzhubDao")
public class XsddzhubDaoImpl extends BaseDaoImpl<Xsddzhub> implements XsddzhubDao {

	public List<Xsddzhib> getXsddzhibByDDH(String ddh) {
		return this.hibernateTemplate.find("from Xsddzhib where xsddzhub.ddh=?",ddh);
	}

	public Xsddzhub getXsddzhubByDDH(String ddh) {
		return (Xsddzhub)this.hibernateTemplate.find("from Xsddzhub where ddh=?",ddh).get(0);
	}

}
