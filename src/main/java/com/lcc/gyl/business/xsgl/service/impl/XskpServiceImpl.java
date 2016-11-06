package com.lcc.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.lcc.gyl.business.xsgl.dao.XsddzhibDao;
import com.lcc.gyl.business.xsgl.dao.XskpzhibDao;
import com.lcc.gyl.business.xsgl.dao.XskpzhubDao;
import com.lcc.gyl.business.xsgl.service.XskpService;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xskpzhib;
import com.lcc.gyl.domain.busness.Xskpzhub;

@Service("xskpService")
public class XskpServiceImpl extends BaseBusinessServiceImpl<Xskpzhub, Xskpzhib> implements XskpService {
	@Resource(name = "xskpzhubDao")
	private XskpzhubDao xskpzhubDao;
	@Resource(name = "xskpzhibDao")
	private XskpzhibDao xskpzhibDao;
	@Resource(name = "xsddzhibDao")
	private XsddzhibDao xsddzhibDao;

	@Override
	public BaseDao<Xskpzhub> getBaseDao_zhu() {
		return this.xskpzhubDao;
	}

	@Override
	public BaseDao<Xskpzhib> getBaseDao_zhi() {
		return this.xskpzhibDao;
	}

	public void saveXskp(Xskpzhub xskpzhub, List<Xskpzhib> xskpzhibs) {
		// 计算发票的总金额 销售发票的子表的每一行的含税金额相加
		Float totalMoney = 0.0F;
		for (Xskpzhib xskpzhib : xskpzhibs) {
			String ytdjh = xskpzhib.getYtdjh();
			Long ythh = xskpzhib.getYthh();
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			// 原来的开票的总和
			Long ljkpsl = xsddzhib.getLjkpsl();
			xskpzhib.setLjkpsl(ljkpsl + xskpzhib.getSl());// 现在的总和写到销售开票子表中
			xsddzhib.setLjkpsl(ljkpsl + xskpzhib.getSl());// 现在的总和写到销售订单子表中
			if (xsddzhib.getLjkpsl().longValue() == xsddzhib.getSl()) {// 开票的总数量和需要的总数量一致
				xskpzhib.setIskpjs(true);// 设置销售开票子表的是否开票关闭为true
				xsddzhib.setIskpgb(true);// 设置销售订单子表的是否开票关闭为true
			}
			totalMoney = xskpzhub.getFpzje() + xskpzhib.getHsje();
		}
		//把totalMoney设置到销售开票的主表中
		xskpzhub.setFpzje(totalMoney);
		xskpzhub.setXskpzhibs(new HashSet<Xskpzhib>(xskpzhibs));
		this.xskpzhubDao.saveEntry(xskpzhub);
	}

}
