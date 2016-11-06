package com.lcc.gyl.business.xsgl.service;

import java.util.List;

import com.lcc.gyl.business.base.service.BaseBusinessService;
import com.lcc.gyl.domain.busness.Xskpzhib;
import com.lcc.gyl.domain.busness.Xskpzhub;

public interface XskpService extends BaseBusinessService<Xskpzhub, Xskpzhib>{
	public void saveXskp(Xskpzhub xskpzhub,List<Xskpzhib> xskpzhibs);
}

