package com.lcc.gyl.domain.busness;

import java.io.Serializable;

public class Xsysdzhib implements Serializable{
	private Long xsysdzhibid;//主键
	private Long sl;//数量 
	private Long hh;
	private String spmc;
	private String spbm;
	private String dw;
	private Float hsje;//含税金额
	private Float se;//税额
	private Float wsje;//无税金额
	private String lydjh;//来源单据号  发票号
	private String lyhh;//来源行号
	private String ytdjh;//源头单据号
	private Long ythh;//源头行号
	private Float dj;//单价
	
	private Long ljyssl;//累计应收数量
	private Boolean isysgb;//是否应收关闭
	
	
	
	public Long getLjyssl() {
		return ljyssl;
	}
	public void setLjyssl(Long ljyssl) {
		this.ljyssl = ljyssl;
	}
	public Boolean getIsysgb() {
		return isysgb;
	}
	public void setIsysgb(Boolean isysgb) {
		this.isysgb = isysgb;
	}
	private Xsysdzhub xsysdzhub;
	
	public String getLyhh() {
		return lyhh;
	}
	public void setLyhh(String lyhh) {
		this.lyhh = lyhh;
	}
	public Long getYthh() {
		return ythh;
	}
	public void setYthh(Long ythh) {
		this.ythh = ythh;
	}
	public Long getSl() {
		return sl;
	}
	public void setSl(Long sl) {
		this.sl = sl;
	}
	public String getYtdjh() {
		return ytdjh;
	}
	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
	}
	public Xsysdzhub getXsysdzhub() {
		return xsysdzhub;
	}
	public void setXsysdzhub(Xsysdzhub xsysdzhub) {
		this.xsysdzhub = xsysdzhub;
	}
	public Long getXsysdzhibid() {
		return xsysdzhibid;
	}
	public void setXsysdzhibid(Long xsysdzhibid) {
		this.xsysdzhibid = xsysdzhibid;
	}
	public Long getHh() {
		return hh;
	}
	public void setHh(Long hh) {
		this.hh = hh;
	}
	
	
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getSpbm() {
		return spbm;
	}
	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Float getHsje() {
		return hsje;
	}
	public void setHsje(Float hsje) {
		this.hsje = hsje;
	}
	public Float getSe() {
		return se;
	}
	public void setSe(Float se) {
		this.se = se;
	}
	public Float getWsje() {
		return wsje;
	}
	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}
	public String getLydjh() {
		return lydjh;
	}
	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}
	public Float getDj() {
		return dj;
	}
	public void setDj(Float dj) {
		this.dj = dj;
	}
}

