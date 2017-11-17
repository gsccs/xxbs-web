package com.gsccs.cmcc.contact.model;

public class ContactwayT {
    private String id;

    private String ispcode;

    private String phone;

    private String cid;
    
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

	public String getIspname() {
		return ispname;
	}

	public void setIspname(String ispname) {
		this.ispname = ispname;
	}
    
    
}