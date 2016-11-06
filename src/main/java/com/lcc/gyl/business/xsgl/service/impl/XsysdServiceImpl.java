package com.lcc.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.lcc.gyl.business.xsgl.dao.XsddzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsddzhubDao;
import com.lcc.gyl.business.xsgl.dao.XsysdzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsysdzhubDao;
import com.lcc.gyl.business.xsgl.service.XsysdService;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xsddzhub;
import com.lcc.gyl.domain.busness.Xsysdzhib;
import com.lcc.gyl.domain.busness.Xsysdzhub;
import com.lcc.gyl.utils.GylConstantKey;

public class XsysdServiceImpl extends BaseBusinessServiceImpl<Xsysdzhub, Xsysdzhib> implements XsysdService {
	@Resource(name = "xsysdzhubDao")
	private XsysdzhubDao xsysdzhubDao;
	@Resource(name = "xsysdzhibDao")
	private XsysdzhibDao xsysdzhibDao;
	@Resource(name = "xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	@Resource(name = "xsddzhubDao")
	private XsddzhubDao xsddzhubDao;

	public void saveXsysd(Xsysdzhub xsysdzhub, List<Xsysdzhib> xsysdzhibs) {
		/**
		 * 1、计算累计应收数量，并且把累计应收数量回写到 销售应收单子表中的累计应收数量中 销售订单子表中的累计应收数量中 
		 * 2、判断是否应收关闭 如果应收关闭了，则 1、 销售应搜单子表中的是否应收关闭设置为true 销售订单子表中的是否应收关闭设置为true
		 * 销售订单子表中针对该商品进行行关闭 2、得到销售订单的子表的数据(集合)
		 * 循环遍历集合，判断每一种商品的行是否关闭了，如果都关闭了，说明整个销售订单已经完成了 如果没有都关闭，继续走流程
		 */
		for (Xsysdzhib xsysdzhib : xsysdzhibs) {
			String ytdjh = xsysdzhib.getYtdjh();
			Long ythh = xsysdzhib.getYthh();
			/**
			 * 根据源头单据号和源头行号从销售订单的子表中查找
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			// 到目前为止总的应收数量
			Long ljyssl = xsddzhib.getLjyssl();
			// 把现在的应收数量和原来的应收的总的数量相加，回写到销售订单的子表中
			xsddzhib.setLjyssl(ljyssl + xsysdzhib.getSl());// xsckdzhib.getSfsl()为实际出库数量
			// 把新的总的数量加到xsysdzhib的累计出库数量中
			xsysdzhib.setLjyssl(ljyssl + xsysdzhib.getSl());
			/**
			 * 判断是否应收关闭 xsddzhib.getLjyssl() 累计应收的数量 xsddzhib.getSl()是需要应收的数量
			 */
			if (xsddzhib.getLjyssl().longValue() == xsddzhib.getSl().longValue()) {
				xsddzhib.setIsskjs(true);// 把销售订单子表的是否应收关闭设置为true
				xsysdzhib.setIsysgb(true);// 把销售出库单子表的是否应收关闭设置为true
				/**
				 * 因为该环节是销售的最后一个环节，所以如果一种商品的销售应收完毕以后 关于这种商品的销售订单的子表中的这一行应该设置行关闭
				 */
				xsddzhib.setHstatus(GylConstantKey.XSDDZHIB_HH_CLOSE);

				/**
				 * 根据源头单据号查询销售订单子表
				 */
				List<Xsddzhib> xsddzhibs = this.xsddzhubDao.getXsddzhibByDDH(ytdjh);
				/**
				 * 设置一个boolean类型的变量
				 */
				boolean flag = true;
				for (Xsddzhib xsddzhib2 : xsddzhibs) {
					if (!xsddzhib2.getHstatus().equals(GylConstantKey.XSDDZHIB_HH_CLOSE)) {// 正在遍历的销售订单子表中的该行没有关闭
						flag = false;
						break;
					}
				}
				if (flag) {// 销售订单子表中的所有的行全部关闭了
					Xsddzhub xsddzhub = this.xsddzhubDao.getXsddzhubByDDH(ytdjh);
					// 根据源头单据号设置销售订单的主表状态为关闭
					xsddzhub.setState(GylConstantKey.XSDDZHUB_STATE_CLOSE);
				}
			}
		}

		xsysdzhub.setXsysdzhibs(new HashSet<Xsysdzhib>(xsysdzhibs));
		this.xsysdzhubDao.saveEntry(xsysdzhub);
	}

	@Override
	public BaseDao<Xsysdzhub> getBaseDao_zhu() {
		return this.xsysdzhubDao;
	}

	@Override
	public BaseDao<Xsysdzhib> getBaseDao_zhi() {
		return this.xsysdzhibDao;
	}

}
