package com.lcc.gyl.business.xsgl.service;

import com.lcc.gyl.business.base.service.BaseBusinessService;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xsddzhub;

public interface XsddService extends BaseBusinessService<Xsddzhub, Xsddzhib>{
	public Object getXsddByDDH(String ddh);
	
	/**
	 * 
	 * @param item  要修改的字段
	 * @param textValue  字段的值
	 */
	public void updateXsdd(String item,String textValue,String ddh,Long hh) throws Exception;
}

