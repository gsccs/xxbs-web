package com.gsccs.cmcc.info.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IctprojectT {
    private String id;

    private String corpname;

    private String ispcode;

    private String name;

    private String brief;

    private String buildcontent;

    private Float ussm;

    private Date winnindate;

    private Date signdate;

    private Date planstartdate;
    
    private String planstartdateStr;

    private Date planenddate;
    
    private String planenddateStr;

    private Date realstartdate;

    private Date realenddate;

    private Integer builddays;

    private String construction;

    private Float planlandussm;

    private Date planlanddate;

    private String amuserid;

    private String telephone;

    private String status;

    private String remark;

    private String cooper;

    private Integer ordernum;

    private String statusname;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCorpname() {
        return corpname;
    }

    public void setCorpname(String corpname) {
        this.corpname = corpname == null ? null : corpname.trim();
    }

    public String getIspcode() {
        return ispcode;
    }

    public void setIspcode(String ispcode) {
        this.ispcode = ispcode == null ? null : ispcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getBuildcontent() {
        return buildcontent;
    }

    public void setBuildcontent(String buildcontent) {
        this.buildcontent = buildcontent == null ? null : buildcontent.trim();
    }

    public Float getUssm() {
        return ussm;
    }

    public void setUssm(Float ussm) {
        this.ussm = ussm;
    }

    public Date getWinnindate() {
        return winnindate;
    }

    public void setWinnindate(Date winnindate) {
        this.winnindate = winnindate;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public Date getPlanstartdate() {
        return planstartdate;
    }

    public void setPlanstartdate(Date planstartdate) {
        this.planstartdate = planstartdate;
    }

    public Date getPlanenddate() {
        return planenddate;
    }

    public void setPlanenddate(Date planenddate) {
        this.planenddate = planenddate;
    }

    public Date getRealstartdate() {
        return realstartdate;
    }

    public void setRealstartdate(Date realstartdate) {
        this.realstartdate = realstartdate;
    }

    public Date getRealenddate() {
        return realenddate;
    }

    public void setRealenddate(Date realenddate) {
        this.realenddate = realenddate;
    }

    public Integer getBuilddays() {
        return builddays;
    }

    public void setBuilddays(Integer builddays) {
        this.builddays = builddays;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction == null ? null : construction.trim();
    }

    public Float getPlanlandussm() {
        return planlandussm;
    }

    public void setPlanlandussm(Float planlandussm) {
        this.planlandussm = planlandussm;
    }

    public Date getPlanlanddate() {
        return planlanddate;
    }

    public void setPlanlanddate(Date planlanddate) {
        this.planlanddate = planlanddate;
    }

    public String getAmuserid() {
        return amuserid;
    }

    public void setAmuserid(String amuserid) {
        this.amuserid = amuserid == null ? null : amuserid.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCooper() {
        return cooper;
    }

    public void setCooper(String cooper) {
        this.cooper = cooper == null ? null : cooper.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

	public String getPlanstartdateStr() {
		if (planstartdate != null) {
			planstartdateStr = new SimpleDateFormat("yyyy-MM-dd")
					.format(planstartdate);
		}
		return planstartdateStr;
	}

	public void setPlanstartdateStr(String planstartdateStr) {
		this.planstartdateStr = planstartdateStr;
	}

	public String getPlanenddateStr() {
		if (planenddate != null) {
			planenddateStr = new SimpleDateFormat("yyyy-MM-dd")
					.format(planenddate);
		}
		return planenddateStr;
	}

	public void setPlanenddateStr(String planenddateStr) {
		this.planenddateStr = planenddateStr;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
    
    
}