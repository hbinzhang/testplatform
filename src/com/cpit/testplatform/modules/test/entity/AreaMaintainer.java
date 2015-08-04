package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class AreaMaintainer extends DataEntity<Maintainer> {

	private static final long serialVersionUID = 6232434454L;

	private String id;
	
	private String areaCode;
	
	private String maintainerName;

	public AreaMaintainer() {
		super();
	}

	public AreaMaintainer(String id, String areaCode, String maintainerName) {
		super();
		this.id = id;
		this.areaCode = areaCode;
		this.maintainerName = maintainerName;
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

	public String getMaintainerName() {
		return maintainerName;
	}

	public void setMaintainerName(String maintainerName) {
		this.maintainerName = maintainerName;
	}

	@Override
	public String toString() {
		return "AreaMaintainer [id=" + id + ", areaCode=" + areaCode + ", maintainerName=" + maintainerName + "]";
	}

	
	
}