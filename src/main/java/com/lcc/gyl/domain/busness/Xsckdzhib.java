package com.lcc.gyl.domain.busness;

import java.io.Serializable;
import java.util.Date;

public class Xsckdzhib implements Serializable {
	private Long xsckdzhibid;// 主键
	private Long hh;// 行号
	private String spbm;// 存货编码
	private String spmc;// 存货名称
	private String xh;// 型号
	private String dw;// 单位
	private Date scrq;// 生产日期
	private Date sxrq;// 失效日期
	private Long yfsl;// 应发数量
	private Long sfsl;// 实发数量
	private Float dj;// 单价
	private Float je;// 金额
	private Date ckrq;// 出库日期
	private String zp;// 赠品
	private String ytdjh;// 源头单据号
	private Long ythh;// 源头行号
	private String lydjh;// 来源单据号
	private Long lyhh;// 来源行号
	private Long ljcksl = 0L; // 累计出库数量
	private Boolean isckgb = false;// 是否出库关闭

	private Xsckdzhub xsckdzhub;// 销售出库单子表

	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getLydjh() {
		return lydjh;
	}

	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}

	public Long getLyhh() {
		return lyhh;
	}

	public void setLyhh(Long lyhh) {
		this.lyhh = lyhh;
	}

	public Long getXsckdzhibid() {
		return xsckdzhibid;
	}

	public void setXsckdzhibid(Long xsckdzhibid) {
		this.xsckdzhibid = xsckdzhibid;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
		this.hh = hh;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public Date getScrq() {
		return scrq;
	}

	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public Long getYfsl() {
		return yfsl;
	}

	public void setYfsl(Long yfsl) {
		this.yfsl = yfsl;
	}

	public Long getSfsl() {
		return sfsl;
	}

	public void setSfsl(Long sfsl) {
		this.sfsl = sfsl;
	}

	public Float getDj() {
		return dj;
	}

	public void setDj(Float dj) {
		this.dj = dj;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	public Date getCkrq() {
		return ckrq;
	}

	public void setCkrq(Date ckrq) {
		this.ckrq = ckrq;
	}

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getYtdjh() {
		return ytdjh;
	}

	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
	}

	public Long getYthh() {
		return ythh;
	}

	public void setYthh(Long ythh) {
		this.ythh = ythh;
	}

	public Long getLjcksl() {
		return ljcksl;
	}

	public void setLjcksl(Long ljcksl) {
		this.ljcksl = ljcksl;
	}

	public Boolean getIsckgb() {
		return isckgb;
	}

	public void setIsckgb(Boolean isckgb) {
		this.isckgb = isckgb;
	}

	public Xsckdzhub getXsckdzhub() {
		return xsckdzhub;
	}

	public void setXsckdzhub(Xsckdzhub xsckdzhub) {
		this.xsckdzhub = xsckdzhub;
	}
}
