package com.lcc.gyl.business.xsgl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lcc.gyl.base.dao.impl.BaseDaoImpl;
import com.lcc.gyl.business.xsgl.dao.XsfhdzhibDao;
import com.lcc.gyl.domain.busness.Xsfhdzhib;

@Repository("xsdhdzhibDao")
public class XsfhdzhibDaoImpl extends BaseDaoImpl<Xsfhdzhib> implements XsfhdzhibDao{

	public List<Xsfhdzhib> getXsfhdzhibByCondition(String ytdjh, Long ythh) {
		return this.hibernateTemplate.find("from Xsfhdzhib where ytdjh=? and ythh=?",ytdjh,ythh);
	}

}
