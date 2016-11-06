package com.lcc.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.lcc.gyl.business.xsgl.dao.XsyddzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsyddzhubDao;
import com.lcc.gyl.business.xsgl.service.XsyddService;
import com.lcc.gyl.domain.busness.Xsyddzhib;
import com.lcc.gyl.domain.busness.Xsyddzhub;

@Service("xsyddService")
public class xsyddService extends BaseBusinessServiceImpl<Xsyddzhub, Xsyddzhib> implements XsyddService{

	@Resource(name="xsyddzhubDao")
	private XsyddzhubDao xsyddzhubDao;
	@Resource(name="xsyddzhibDao")
	private XsyddzhibDao xsyddzhibDao;
	
	@Override
	public BaseDao<Xsyddzhub> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return this.xsyddzhubDao;
	}

	@Override
	public BaseDao<Xsyddzhib> getBaseDao_zhi() {
		// TODO Auto-generated method stub
		return this.xsyddzhibDao;
	}

}
