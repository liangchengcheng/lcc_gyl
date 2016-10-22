package com.lcc.gyl.query.business;

import java.util.Date;
import java.util.Map;

import com.lcc.gyl.query.BaseQuery;

public class XsysdzhubQuery extends BaseQuery {
	private Long ddh;
	private String gs;
	private Date rq;//日期
	private Date qsrq;//起算日期
	private String ks;//客商
	private String bm;//部门
	private String ywy;//业务员
	private String sxbz;//生效标志
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String shr;//审核人
	private Date shrq;//审核日期
	private String qzr;//签字人
	private Date qzrq;//签字日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	
	@Override
	public Map<String, Object> buildWhere() {
		if(this.ddh != null){
			this.keyValues.put("ddh", ddh);
		}
		if(this.gs != null){
			this.keyValues.put("gs", gs);
		}
		if(this.rq!=null){
			this.keyValues.put("rq",rq);
		}
		if(this.qsrq!=null){
			this.keyValues.put("qsrq",qsrq);
		}
		
		if(this.ks!=null){
			this.keyValues.put("ks",ks);
		}
		if(this.bm!=null){
			this.keyValues.put("bm",bm);
		}
		if(this.ywy!=null){
			this.keyValues.put("ywy",ywy);
		}
		if(this.sxbz!=null){
			this.keyValues.put("sxbz",sxbz);
		}
		
		if(this.zdr!=null){
			this.keyValues.put("zdr",zdr);
		}
		if(this.zdrq!=null){
			this.keyValues.put("zdrq",zdrq);
		}
		if(this.shr!=null){
			this.keyValues.put("shr",shr);
		}
		if(this.shrq!=null){
			this.keyValues.put("shrq",shrq);
		}
		if(this.qzr!=null){
			this.keyValues.put("qzr",qzr);
		}
		if(this.qzrq!=null){
			this.keyValues.put("qzrq",qzrq);
		}
		if(this.xgr!=null){
			this.keyValues.put("xgr",xgr);
		}
		if(this.xgrq!=null){
			this.keyValues.put("xgrq",xgrq);
		}
		return this.keyValues;
	}
}
