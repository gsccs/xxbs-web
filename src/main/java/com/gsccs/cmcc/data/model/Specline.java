package com.gsccs.cmcc.data.model;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

public class Specline {

	private Long id;

	@Excel(name = "县市")
	private String areaname;

	@Excel(name = "集团单位名称")
	private String ispname;

	@Excel(name = "集团单位编码")
	private String ispcode;

	@Excel(name = "是否使用专线")
	private String hasline;

	@Excel(name = "运营商")
	private String isptype;

	@Excel(name = "专线类型")
	private String linetype;

	@Excel(name = "带宽")
	private Integer bitsize;

	@Excel(name = "月资费")
	private String feemonth;

	@Excel(name = "缴费方式")
	private String paytype;

	@Excel(name = "协议签订时期")
	private Date signdate;

	@Excel(name = "到期时间")
	private Date enddate;

	@Excel(name = "本年度应缴费时间")
	private Date paydate;

	@Excel(name = "备注")
	private String remark;

	@Excel(name = "协议扫描")
	private String agreeimg;

	@Excel(name = "客户经理")
	private String customer;

	@Excel(name = "年资费")
	private String yeartariff;

	@Excel(name = "合同编号")
	private String pactnumber;

	@Excel(name = "合同名称")
	private String pactname;

	@Excel(name = "合同有效期")
	private String pactvalidity;

	@Excel(name = "计划建设平台工单编号")
	private String worknumber;

	@Excel(name = "计划建设平台专线名称")
	private String speclinename;

	@Excel(name = "ESOP专线编号")
	private String esopnumber;

	@Excel(name = "ESOP专线主题")
	private String esoptheme;

	@Excel(name = "实际开通时间")
	private Date opentime;
	@Excel(name = "BOSS计费号")
	private String bossnumber;

	@Excel(name = "首次收费时间")
	private Date ftolltime;

	@Excel(name = "首次收费金额")
	private Float ftollsum;
	private String areacode;

	private String linename;
	private String corptitle;
	private String payname;
	private String filenames;

	private Long importtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname == null ? null : areaname.trim();
	}

	public String getIspname() {
		return ispname;
	}

	public void setIspname(String ispname) {
		this.ispname = ispname == null ? null : ispname.trim();
	}

	public String getIspcode() {
		return ispcode;
	}

	public void setIspcode(String ispcode) {
		this.ispcode = ispcode == null ? null : ispcode.trim();
	}

	public String getHasline() {
		return hasline;
	}

	public void setHasline(String hasline) {
		this.hasline = hasline == null ? null : hasline.trim();
	}

	public String getIsptype() {
		return isptype;
	}

	public void setIsptype(String isptype) {
		this.isptype = isptype == null ? null : isptype.trim();
	}

	public String getLinetype() {
		return linetype;
	}

	public void setLinetype(String linetype) {
		this.linetype = linetype == null ? null : linetype.trim();
	}

	public Integer getBitsize() {
		return bitsize;
	}

	public void setBitsize(Integer bitsize) {
		this.bitsize = bitsize;
	}

	public String getFeemonth() {
		return feemonth;
	}

	public void setFeemonth(String feemonth) {
		this.feemonth = feemonth == null ? null : feemonth.trim();
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype == null ? null : paytype.trim();
	}

	public Date getSigndate() {
		return signdate;
	}

	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getAgreeimg() {
		return agreeimg;
	}

	public void setAgreeimg(String agreeimg) {
		this.agreeimg = agreeimg == null ? null : agreeimg.trim();
	}

	public String getYeartariff() {
		return yeartariff;
	}

	public void setYeartariff(String yeartariff) {
		this.yeartariff = yeartariff;
	}

	public String getPactnumber() {
		return pactnumber;
	}

	public void setPactnumber(String pactnumber) {
		this.pactnumber = pactnumber;
	}

	public String getPactname() {
		return pactname;
	}

	public void setPactname(String pactname) {
		this.pactname = pactname;
	}

	public String getPactvalidity() {
		return pactvalidity;
	}

	public void setPactvalidity(String pactvalidity) {
		this.pactvalidity = pactvalidity;
	}

	public String getWorknumber() {
		return worknumber;
	}

	public void setWorknumber(String worknumber) {
		this.worknumber = worknumber;
	}

	public String getSpeclinename() {
		return speclinename;
	}

	public void setSpeclinename(String speclinename) {
		this.speclinename = speclinename;
	}

	public String getEsopnumber() {
		return esopnumber;
	}

	public void setEsopnumber(String esopnumber) {
		this.esopnumber = esopnumber;
	}

	public String getEsoptheme() {
		return esoptheme;
	}

	public void setEsoptheme(String esoptheme) {
		this.esoptheme = esoptheme;
	}

	public Date getOpentime() {
		return opentime;
	}

	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}

	public String getBossnumber() {
		return bossnumber;
	}

	public void setBossnumber(String bossnumber) {
		this.bossnumber = bossnumber;
	}

	public Date getFtolltime() {
		return ftolltime;
	}

	public void setFtolltime(Date ftolltime) {
		this.ftolltime = ftolltime;
	}

	public Float getFtollsum() {
		return ftollsum;
	}

	public void setFtollsum(Float ftollsum) {
		this.ftollsum = ftollsum;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getLinename() {
		return linename;
	}

	public void setLinename(String linename) {
		this.linename = linename;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public Long getImporttime() {
		return importtime;
	}

	public void setImporttime(Long importtime) {
		this.importtime = importtime;
	}

	public String getPayname() {
		return payname;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

}