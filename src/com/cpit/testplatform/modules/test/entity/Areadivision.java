package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
/**
 * @author zhb
 */

public class Areadivision extends DataEntity<Areadivision> {

	private static final long serialVersionUID = 6232434454L;

	private String id;
	
	private String code;
	
	private String name;

	private String maintainers;

	private String devices;

	public Areadivision() {
		super();
	}

	public Areadivision(String id, String code, String name, String maintainers, String devices) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.maintainers = maintainers;
		this.devices = devices;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaintainers() {
		return maintainers;
	}

	public void setMaintainers(String maintainers) {
		this.maintainers = maintainers;
	}

	public String getDevices() {
		return devices;
	}

	public void setDevices(String devices) {
		this.devices = devices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Areadivision [id=" + id + ", code=" + code + ", name=" + name + ", maintainers=" + maintainers
				+ ", devices=" + devices + "]";
	}

	
}