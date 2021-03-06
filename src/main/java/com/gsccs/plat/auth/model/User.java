package com.gsccs.plat.auth.model;

import java.io.Serializable;

/**
 * 系统用户
 * 
 * @author x.d zhang
 * 
 */
public class User implements Serializable {

	private Long id; // 编号
	private String account; 	// 用户登录名
	private String password; 	// 密码
	private String title; 		// 用户名称
	private Long orgid; 		// 所属公司
	private Integer areaid; 	//所在地域
	private String salt; 		// 加密密码的盐
	private Boolean locked = Boolean.FALSE;

	// 公司名称
	private String orgname;
	private String areastr; 	//所在地域

	public User() {
	}

	public User(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return account + salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	

	public String getAreastr() {
		return areastr;
	}

	public void setAreastr(String areastr) {
		this.areastr = areastr;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", orgid=" + orgid + ", account='"
				+ account + '\'' + ", password='" + password + '\''
				+ ", salt='" + salt + '\'' + ", locked=" + locked + '}';
	}
}
