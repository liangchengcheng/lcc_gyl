package com.lcc.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.lcc.gyl.business.xsgl.dao.XsddzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsfhdzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsfhdzhubDao;
import com.lcc.gyl.business.xsgl.service.XsfhdService;
import com.lcc.gyl.domain.busness.Xsddzhib;
import com.lcc.gyl.domain.busness.Xsfhdzhib;
import com.lcc.gyl.domain.busness.Xsfhdzhub;

@Service("xsfthService")
public class XsfhdServiceImpl extends BaseBusinessServiceImpl<Xsfhdzhub, Xsfhdzhib> implements XsfhdService {
	@Resource(name = "xsfhdzhubDao")
	private XsfhdzhubDao xsfhdzhubDao;
	@Resource(name = "xsfhdzhibDao")
	private XsfhdzhibDao xsfhdzhibDao;

	@Resource(name = "xsddzhibDao")
	private XsddzhibDao xsddzhibDao;

	@Override
	public BaseDao<Xsfhdzhub> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return this.xsfhdzhubDao;
	}

	@Override
	public BaseDao<Xsfhdzhib> getBaseDao_zhi() {
		// TODO Auto-generated method stub
		return this.xsfhdzhibDao;
	}

	public void saveXsfhd(Xsfhdzhub xsfhdzhub, List<Xsfhdzhib> xsfhdzhibs) {
		/**
		 * //提取出源头单据号和源头行号 //根据源头单据号和源头行号去销售发货单表中 //查询出针对源头单据号和源头行号的发货记录，
		 * //把所有的发货记录的每一次发货数量加起来，就是累计 的发货数量 //根据源头单据号和源头行号提取出该商品的销售订单子表中的
		 * //总数，看该总数和发货单的总数是否一致，如果一致，则发货 关闭
		 */

		// 遍历销售发货单的子表的每一个元素
		for (Xsfhdzhib xsfhdzhib : xsfhdzhibs) {
			// 源头单据号 = 销售订单号
			String ytdjh = xsfhdzhib.getYtdjh();
			// 源头行号 = 销售订单的子表中的行号
			Long ythh = xsfhdzhib.getYthh();
			// 初始化累计发货数量的值为0
			Long ljfhsl = 0L;

			// 根据源头单据号和源头行号去销售发货单查找该源头单据号和源头行号所对应的所有的发货记录
			// 根据源头单据号和源头行号查询出来的所有的发货订单子表
			List<Xsfhdzhib> xsfhdzhibs2 = this.xsfhdzhibDao.getXsfhdzhibByCondition(ytdjh, ythh);

			/**
			 * xsfhdzhib2历史的一次发货单 该for循环结束以后， 就把以前的所有的发货单针对该种商品的发货总量加起来了
			 */
			for (Xsfhdzhib xsfhdzhib2 : xsfhdzhibs2) {
				// 实发数量
				ljfhsl = ljfhsl + xsfhdzhib2.getSfsl();
			}

			/*
			 * xsfhdzhib本次的一种商品 xsfhdzhib.getSfsl() 本次该种商品的实发数量
			 * ljfhsl+xsfhdzhib.getSfsl()该种商品的本次数量加上以前的总量
			 * 把以前的对于该种商品的发货总量和本次的直接相加
			 */
			xsfhdzhib.setLjfhsl(ljfhsl + xsfhdzhib.getSfsl());

			/**
			 * 根据源头单据号和源头行号查找需要发货的数量
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythh);
			Long xyfhsl = xsddzhib.getSl();// 把需要发货的数量提取出来
			/**
			 * 回写销售订单子表中的累计发货数量
			 */
			xsddzhib.setLjfhsl(xsfhdzhib.getLjfhsl());

			if (xyfhsl.longValue() == xsfhdzhib.getLjfhsl().longValue()) {// 如果需要发货的数量和累计发货的数量一致，则说明发货完毕
				xsfhdzhib.setIsfhgb(true);// 在发货单的子表中设置关闭
				// 把发货关闭回写到销售订单那子表中
				xsddzhib.setIsfhgb(true);
			}
		}
		
		/**
		 * 保存销售发货单主表和级联保存子表
		 */
		xsfhdzhub.setXsfhdzhibs(new HashSet<Xsfhdzhib>(xsfhdzhibs));
		this.xsfhdzhubDao.saveEntry(xsfhdzhub);
	}

}
