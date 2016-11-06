package com.lcc.gyl.business.xsgl.dao;

import java.util.List;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.domain.busness.Xsfhdzhib;

public interface XsfhdzhibDao extends BaseDao<Xsfhdzhib>{
	public List<Xsfhdzhib> getXsfhdzhibByCondition(String ytdjh,Long ythh);
}
