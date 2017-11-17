package com.gsccs.cmcc.info.model;

import java.util.Date;

public class CorpT {

	private String ispcode;

	private String title;
	private String orgcode;
	private String regcode;
	private String regtype;
	private String phone;
	private String email;
	private String domain;
	private String nature;
	private String legaler;

	private String linker;
	private Integer acode;
	private String address;
	private String zipcode;
	private String qqcode;
	private String logo;
	private String status;
	private Date addtime;
	private Long amuserid;
	private String amname;
	private String content;
	//所在地域
	private String acodestr;

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

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode == null ? null : orgcode.trim();
	}

	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode == null ? null : regcode.trim();
	}

	public String getRegtype() {
		return regtype;
	}

	public void setRegtype(String regtype) {
		this.regtype = regtype == null ? null : regtype.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain == null ? null : domain.trim();
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature == null ? null : nature.trim();
	}

	public String getLegaler() {
		return legaler;
	}

	public void setLegaler(String legaler) {
		this.legaler = legaler == null ? null : legaler.trim();
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker == null ? null : linker.trim();
	}

	public Integer getAcode() {
		return acode;
	}

	public void setAcode(Integer acode) {
		this.acode = acode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode == null ? null : zipcode.trim();
	}

	public String getQqcode() {
		return qqcode;
	}

	public void setQqcode(String qqcode) {
		this.qqcode = qqcode == null ? null : qqcode.trim();
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getAmuserid() {
		return amuserid;
	}

	public void setAmuserid(Long amuserid) {
		this.amuserid = amuserid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getAmname() {
		return amname;
	}

	public void setAmname(String amname) {
		this.amname = amname;
	}

	public String getAcodestr() {
		return acodestr;
	}

	public void setAcodestr(String acodestr) {
		this.acodestr = acodestr;
	}
	
	
}