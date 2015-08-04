package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
/**
 * 测试终端
 * @author zhb
 */

public class Manager extends DataEntity<Manager> {

	private static final long serialVersionUID = 6232434454L;

	private String id;
	
	private String loginName;
	
	private String name;

	private String title;

	private String mobile;
	
	private String passwordOld;
	
	private String password;
	
	private String passwordAgain;
	
	private String email;
	
	public Manager(String id, String name, String loginName, String title, String mobile, String password
			, String email) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.name = name;
		this.title = title;
		this.mobile = mobile;
		this.password = password;
		this.email = email;
	}

	public Manager() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswordAgain() {
		return password;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", loginName=" + loginName + ", title=" + title + 
				", mobile=" + mobile + ", email=" + email + ", password="
				+ password + "]";
	}
	
}