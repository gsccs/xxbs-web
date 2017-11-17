package com.gsccs.cmcc.sem.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SemrecomdT {

	private Integer id;
	private String reportid;
	private String productid;
	private String remresult;
	private String amuserid;
	private String corpid;
	private Date addtime;

	private String addtimeStr;
	
	private String producttitle;
	
	private String corptitle;
	
	private String recomresult;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getRemresult() {
		return remresult;
	}

	public void setRemresult(String remresult) {
		this.remresult = remresult;
	}

	public String getAmuserid() {
		return amuserid;
	}

	public void setAmuserid(String amuserid) {
		this.amuserid = amuserid;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getProducttitle() {
		return producttitle;
	}

	public void setProducttitle(String producttitle) {
		this.producttitle = producttitle;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getRecomresult() {
		return recomresult;
	}

	public void setRecomresult(String recomresult) {
		this.recomresult = recomresult;
	}

	public String getAddtimeStr() {
		String	dateFormat = "yyyy-MM-dd HH:mm:ss";
		if (addtime != null) {
			addtimeStr = new SimpleDateFormat(dateFormat).format(addtime);
		}
		return addtimeStr;
	}

	public void setAddtimeStr(String addtimeStr) {
		this.addtimeStr = addtimeStr;
	}
}