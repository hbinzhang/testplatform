package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class ManagedDevice extends DataEntity<ManagedDevice> {

	private static final long serialVersionUID = 6232434454L;

	private String id;
	
	private String neid;
	
	private String neName;
	
	private String neVersion;
	
	private String neType;
	
	private String critical = "0";
	private String major = "0";
	private String minor = "0";
	private String warn = "1";

	public ManagedDevice() {
		super();
	}

	public ManagedDevice(String neid, String neName, String neVersion, String neType) {
		super();
		this.neid = neid;
		this.neName = neName; 
		this.neVersion = neVersion;
		this.neType = neType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNeid() {
		return neid;
	}

	public void setNeid(String neid) {
		this.neid = neid;
	}

	public String getNeName() {
		return neName;
	}

	public void setNeName(String neName) {
		this.neName = neName;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public String getNeType() {
		return neType;
	}

	public void setNeType(String neType) {
		this.neType = neType;
	}

	public String getCritical() {
		return critical;
	}

	public void setCritical(String critical) {
		this.critical = critical;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}
	
	@Override
	public String toString() {
		return "ManagedDevice [id=" + id + ", neid=" + neid + ", neName=" + neName + ", neVersion=" + neVersion
				+ ", neType=" + neType + "]";
	}

	
	
}