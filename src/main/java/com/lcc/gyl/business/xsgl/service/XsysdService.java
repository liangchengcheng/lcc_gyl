package com.lcc.gyl.business.xsgl.service;

import java.util.List;
import com.lcc.gyl.business.base.service.BaseBusinessService;
import com.lcc.gyl.domain.busness.Xsysdzhib;
import com.lcc.gyl.domain.busness.Xsysdzhub;

public interface XsysdService extends BaseBusinessService<Xsysdzhub, Xsysdzhib>{
	public void saveXsysd(Xsysdzhub xsysdzhub,List<Xsysdzhib> xsysdzhibs);
}

