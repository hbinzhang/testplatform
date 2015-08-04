package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class AreaDevice extends DataEntity<Maintainer> {

	private static final long serialVersionUID = 6232434454L;

	private String id;
	
	private String areaCode;
	
	private String deviceId;
	
	private String deviceName;

	public AreaDevice() {
		super();
	}

	public AreaDevice(String id, String areaCode, String deviceName, String deviceId) {
		super();
		this.id = id;
		this.areaCode = areaCode;
		this.deviceId = deviceId;
		this.deviceName = deviceName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Override
	public String toString() {
		return "AreaDevice [id=" + id + ", areaCode=" + areaCode + ", deviceId=" + deviceId + ", deviceName="
				+ deviceName + "]";
	}

	
	
}