package com.gsccs.cmcc.data.model;

import org.jeecgframework.poi.excel.annotation.Excel;

public class ContactD {
	
	@Excel(name="地区编码")
    private String areaname;

	@Excel(name="集团单位名称")
    private String ispname;

	@Excel(name="集团单位编码")
    private String ispcode;
	
	@Excel(name="姓名")
    private String name;
	
	@Excel(name="职务")
    private String duty;
	
	@Excel(name="电话号码")
    private String phone;
	
	@Excel(name="运营商")
    private String isptype;
	
    private String status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIsptype() {
        return isptype;
    }

    public void setIsptype(String isptype) {
        this.isptype = isptype == null ? null : isptype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}