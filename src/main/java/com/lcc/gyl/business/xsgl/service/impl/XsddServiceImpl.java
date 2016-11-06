package com.lcc.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.beans.PropertyDescriptor;
import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.lcc.gyl.business.xsgl.dao.XsddzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsddzhubDao;
import com.lcc.gyl.business.xsgl.service.XsddService;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xsddzhub;
import com.lcc.gyl.utils.GylConstantKey;

@Service("xsddService")
public class XsddServiceImpl extends BaseBusinessServiceImpl<Xsddzhub, Xsddzhib> implements XsddService {

	@Resource(name = "xsddzhubDao")
	private XsddzhubDao xsddzhubDao;
	@Resource(name = "xsddzhibDao")
	private XsddzhibDao xsddzhibDao;

	public Object getXsddByDDH(String ddh) {
		Xsddzhub xsddzhub = this.xsddzhubDao.getXsddzhubByDDH(ddh);
		String state = xsddzhub.getState();
		if (GylConstantKey.XSDDZHUB_STATE_CLOSE.equals(state)) {
			return "1";
		} else {
			return xsddzhub;
		}
	}

	@Transactional
	public void updateXsdd(String item, String textValue, String ddh, Long hh) throws Exception {
		String type = item.split("_")[1];
		String fileKey = item.split("_")[0];
		// fileKey的值 就是 spmc
		if ("zhu".equals(type)) {
			Xsddzhub xsddzhub = this.xsddzhubDao.getXsddzhubByDDH(ddh);
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fileKey, xsddzhub.getClass());
			propertyDescriptor.getWriteMethod().invoke(xsddzhub, textValue);
		} else if ("zhi".equals(type)) {
			// 要修改的是子表
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ddh, hh);
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fileKey, xsddzhib.getClass());
			propertyDescriptor.getWriteMethod().invoke(xsddzhib, textValue);
		}

	}

	@Override
	public BaseDao<Xsddzhub> getBaseDao_zhu() {
		return this.xsddzhubDao;
	}

	@Override
	public BaseDao<Xsddzhib> getBaseDao_zhi() {
		return this.xsddzhibDao;
	}

}
