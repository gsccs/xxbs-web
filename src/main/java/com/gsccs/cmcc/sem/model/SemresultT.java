package com.gsccs.cmcc.sem.model;

public class SemresultT {
	
	private Integer id;
	private String productid;
	private String smereult;
	private String reportid;
	private String propid;
	private String corpid;
	private String amuserid;
	private String addtime;

	private String productname;
	private String corptitle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid == null ? null : productid.trim();
	}

	public String getSmereult() {
		return smereult;
	}

	public void setSmereult(String smereult) {
		this.smereult = smereult == null ? null : smereult.trim();
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid == null ? null : reportid.trim();
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid == null ? null : corpid.trim();
	}

	public String getAmuserid() {
		return amuserid;
	}

	public void setAmuserid(String amuserid) {
		this.amuserid = amuserid == null ? null : amuserid.trim();
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime == null ? null : addtime.trim();
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getPropid() {
		return propid;
	}

	public void setPropid(String propid) {
		this.propid = propid;
	}

}