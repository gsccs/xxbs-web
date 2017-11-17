package com.gsccs.cmcc.contact.model;

import org.jeecgframework.poi.excel.annotation.Excel;

public class ContactT {
	
    private String id;
    @Excel(name="ispcode")
    private String ispcode;
    @Excel(name="标题")
    private String title;
    private Integer areacode;
    private String duty;
    private String phone;
    @Excel(name="name")
    private String name;
    private String isptype;
    private String status;
    
    
    //查询显示
    private String corptitle;

    private String areaname;

    private String ispname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIspcode() {
        return ispcode;
    }

    public void setIspcode(String ispcode) {
        this.ispcode = ispcode == null ? null : ispcode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getAreacode() {
        return areacode;
    }

    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getIspname() {
		return ispname;
	}

	public void setIspname(String ispname) {
		this.ispname = ispname;
	}
    
    
}