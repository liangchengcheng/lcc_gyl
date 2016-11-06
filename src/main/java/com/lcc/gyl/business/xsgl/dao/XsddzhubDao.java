package com.lcc.gyl.business.xsgl.dao;

import java.util.List;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xsddzhub;

public interface XsddzhubDao extends BaseDao<Xsddzhub>{
	public List<Xsddzhib> getXsddzhibByDDH(String ddh);
	public Xsddzhub getXsddzhubByDDH(String ddh);
}
