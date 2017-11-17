package com.gsccs.cmcc.sem.model;

import java.util.Date;
import java.util.List;


public class Recomds {

	private String reportid;
	private String amuserid;
	private String corpid;
	private Date addtime;
	
	List<SemrecomdT> results;
	public String getReportid() {
		return reportid;
	}
	public void setReportid(String reportid) {
		this.reportid = reportid;
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
	public List<SemrecomdT> getResults() {
		return results;
	}
	public void setResults(List<SemrecomdT> results) {
		this.results = results;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	
}
