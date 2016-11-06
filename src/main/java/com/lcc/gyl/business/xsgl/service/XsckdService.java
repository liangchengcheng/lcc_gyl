package com.lcc.gyl.business.xsgl.service;

import java.util.List;

import com.lcc.gyl.business.base.service.BaseBusinessService;
import com.lcc.gyl.domain.busness.Xsckdzhib;
import com.lcc.gyl.domain.busness.Xsckdzhub;

public interface XsckdService extends BaseBusinessService<Xsckdzhub, Xsckdzhib>{
	public void saveXsckd(Xsckdzhub xsckdzhub,List<Xsckdzhib> xsckdzhibs);
}
