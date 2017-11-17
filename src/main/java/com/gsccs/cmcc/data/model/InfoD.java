package com.gsccs.cmcc.data.model;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

public class InfoD {
	
	@Excel(name="县市")
    private String areaname;
	
	@Excel(name="摸底时间")
    private Date knowdate;
	
	@Excel(name="集团编号")
    private String ispcode;
	
	@Excel(name="集团名称")
    private String ispname;
	
	@Excel(name="客户经理姓名")
    private String usrename;
	
	@Excel(name="项目名称")
    private String pname;
	
	@Excel(name="项目建设内容")
    private String pcontent;
	
	@Excel(name="项目投资金额（万元）")
    private Float money;
	
	@Excel(name="项目实施时间")
    private Date startdate;
	
	@Excel(name="项目谈判预计时间")
    private Date negotiatedate;
	
	@Excel(name="资金来源")
    private String moneysource;
	
	@Excel(name="合作厂家")
    private String partner;
	
	@Excel(name="是否使用座机")
    private String isplane;
	
	@Excel(name="固话运营商")
    private String planetype;
	
	@Excel(name="座机数量")
    private Integer planenum;
	
	@Excel(name="月资费/部")
    private Float fee;
	
	@Excel(name="到期时间")
    private Date enddate;
	
	@Excel(name="通知发送方式")
    private String iscx;
	
	@Excel(name="移动管家")
    private String isydgj;
	
	@Excel(name="舆情监控")
    private String isyqjk;
	
	@Excel(name="云主机")
    private String isyzj;
	
	@Excel(name="企业建站")
    private String isqyjz;
	
	@Excel(name="协同办公")
    private String isxtbg;
	
	@Excel(name="集团通讯录")
    private String isjttxl;
	
	@Excel(name="外勤通")
    private String iswqt;
	
	@Excel(name="移动终端管理")
    private String ismdm;
	
	@Excel(name="其他产品")
    private String other;

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public Date getKnowdate() {
        return knowdate;
    }

    public void setKnowdate(Date knowdate) {
        this.knowdate = knowdate;
    }

    public String getIspcode() {
        return ispcode;
    }

    public void setIspcode(String ispcode) {
        this.ispcode = ispcode == null ? null : ispcode.trim();
    }

    public String getIspname() {
        return ispname;
    }

    public void setIspname(String ispname) {
        this.ispname = ispname == null ? null : ispname.trim();
    }

    public String getUsrename() {
        return usrename;
    }

    public void setUsrename(String usrename) {
        this.usrename = usrename == null ? null : usrename.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getNegotiatedate() {
        return negotiatedate;
    }

    public void setNegotiatedate(Date negotiatedate) {
        this.negotiatedate = negotiatedate;
    }

    public String getMoneysource() {
        return moneysource;
    }

    public void setMoneysource(String moneysource) {
        this.moneysource = moneysource == null ? null : moneysource.trim();
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner == null ? null : partner.trim();
    }

    public String getIsplane() {
        return isplane;
    }

    public void setIsplane(String isplane) {
        this.isplane = isplane == null ? null : isplane.trim();
    }

    public String getPlanetype() {
        return planetype;
    }

    public void setPlanetype(String planetype) {
        this.planetype = planetype == null ? null : planetype.trim();
    }

    public Integer getPlanenum() {
        return planenum;
    }

    public void setPlanenum(Integer planenum) {
        this.planenum = planenum;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getIscx() {
        return iscx;
    }

    public void setIscx(String iscx) {
        this.iscx = iscx == null ? null : iscx.trim();
    }

    public String getIsydgj() {
        return isydgj;
    }

    public void setIsydgj(String isydgj) {
        this.isydgj = isydgj == null ? null : isydgj.trim();
    }

    public String getIsyqjk() {
        return isyqjk;
    }

    public void setIsyqjk(String isyqjk) {
        this.isyqjk = isyqjk == null ? null : isyqjk.trim();
    }

    public String getIsyzj() {
        return isyzj;
    }

    public void setIsyzj(String isyzj) {
        this.isyzj = isyzj == null ? null : isyzj.trim();
    }

    public String getIsqyjz() {
        return isqyjz;
    }

    public void setIsqyjz(String isqyjz) {
        this.isqyjz = isqyjz == null ? null : isqyjz.trim();
    }

    public String getIsxtbg() {
        return isxtbg;
    }

    public void setIsxtbg(String isxtbg) {
        this.isxtbg = isxtbg == null ? null : isxtbg.trim();
    }

    public String getIsjttxl() {
        return isjttxl;
    }

    public void setIsjttxl(String isjttxl) {
        this.isjttxl = isjttxl == null ? null : isjttxl.trim();
    }

    public String getIswqt() {
        return iswqt;
    }

    public void setIswqt(String iswqt) {
        this.iswqt = iswqt == null ? null : iswqt.trim();
    }

    public String getIsmdm() {
        return ismdm;
    }

    public void setIsmdm(String ismdm) {
        this.ismdm = ismdm == null ? null : ismdm.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}