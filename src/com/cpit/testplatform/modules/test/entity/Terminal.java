package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
/**
 * 测试终端
 * @author cxw
 *
 */
public class Terminal extends DataEntity<Terminal> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6303099617938929817L;

	private String id;

	private String type;

	private String manufacturer;

	private String name;

	private String code;

	private String protocal;

	private String ip;

	private String port;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProtocal() {
		return protocal;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}