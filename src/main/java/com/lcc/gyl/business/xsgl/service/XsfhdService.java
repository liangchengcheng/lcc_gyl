package com.lcc.gyl.business.xsgl.service;

import java.util.List;

import com.lcc.gyl.business.base.service.BaseBusinessService;
import com.lcc.gyl.domain.busness.Xsfhdzhib;
import com.lcc.gyl.domain.busness.Xsfhdzhub;

public interface XsfhdService extends BaseBusinessService<Xsfhdzhub, Xsfhdzhib>{
	public void saveXsfhd(Xsfhdzhub xsfhdzhub,List<Xsfhdzhib> xsfhdzhibs);
}
