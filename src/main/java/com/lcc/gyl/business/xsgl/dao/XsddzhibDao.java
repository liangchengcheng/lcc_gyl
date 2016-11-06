package com.lcc.gyl.business.xsgl.dao;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.domain.busness.Xsddzhib;

public interface XsddzhibDao extends BaseDao<Xsddzhib>{
	/**
	 * 根据源头单据号和源头行号查找销售订单的子表
	 * @param ytdjh
	 * @param ythh
	 * @return
	 */
	public Xsddzhib getXsddzhibByCondition(String ytdjh,Long ythh);
}
