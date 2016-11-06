package com.lcc.gyl.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.lcc.gyl.business.xsgl.dao.XsckdzhibDao;
import com.lcc.gyl.business.xsgl.dao.XsckdzhubDao;
import com.lcc.gyl.business.xsgl.dao.XsddzhibDao;
import com.lcc.gyl.business.xsgl.service.XsckdService;
import com.lcc.gyl.domain.busness.Xsckdzhib;
import com.lcc.gyl.domain.busness.Xsckdzhub;
import com.lcc.gyl.domain.busness.Xsddzhib;

@Service("xsckdService")
public class XsckdServiceImpl extends BaseBusinessServiceImpl<Xsckdzhub, Xsckdzhib> implements XsckdService{

	@Resource(name="xsckdzhubDao")
	private XsckdzhubDao xsckdzhubDao;
	@Resource(name="xsckdzhibDao")
	private XsckdzhibDao xsckdzhibDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	
	@Override
	public BaseDao<Xsckdzhub> getBaseDao_zhu() {
		return this.xsckdzhubDao;
	}

	@Override
	public BaseDao<Xsckdzhib> getBaseDao_zhi() {
		return this.xsckdzhibDao;
	}
	
	@Transactional
	public void saveXsckd(Xsckdzhub xsckdzhub, List<Xsckdzhib> xsckdzhibs) {
		// 遍历每一个销售出库单子表单数据（数据是来自页面）
		for(Xsckdzhib xsckdzhib : xsckdzhibs){
			String ytdjh = xsckdzhib.getYtdjh();
			Long ythn = xsckdzhib.getYthh();
			//根据源头的单据号和源头号从销售订单的字表中的查找
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByCondition(ytdjh, ythn);
			//到目前为止的总的出库数量
			Long ljcksl = xsddzhib.getLjcksl();
			//把现在的出库数量和原来的出库的总数量相加 回到销售订单的字表
			xsckdzhib.setLjcksl(ljcksl+xsckdzhib.getSfsl());
			//把心的数量追加到xsckdzhib的累计出库数量中
			xsckdzhib.setLjcksl(ljcksl+xsckdzhib.getSfsl());
			
			/**
			 * 判断是否出库关闭
			 */
			if (xsddzhib.getLjcksl().longValue() == xsddzhib.getSl().longValue()) {
				//把销售订单子表的是否出库关闭设置为true
				xsddzhib.setIsckgb(true);
				//把销售出库单子表的是否出库关闭设置为true
				xsckdzhib.setIsckgb(true);
			}
		}
		xsckdzhub.setXsckdzhibs(new HashSet<Xsckdzhib>(xsckdzhibs));;
		this.xsckdzhubDao.saveEntry(xsckdzhub);
		
	}

}
