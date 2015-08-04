package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class Alarm extends DataEntity<Alarm> {
	private static final long serialVersionUID = 12312312321l;
	
	private String streamCode = "";
	private String type;
	private String name;
	private String neid;
	private String neName;
	private String alarmSource;
	private String level;
	private String effect;
	private String description;
	private String createTime;
	private String clear;
	private String clearTime;
	private String ack;
	private String ackTime;
	private String maintainerId;
	
	public Alarm() {
		super();
	}

	public Alarm(String streamCode, String type, String name, String level, String effect, String description,
			String createTime, String isClear, String clearTime, String isAck, String ackTime, String maintainerId) {
		super();
		this.streamCode = streamCode;
		this.type = type;
		this.name = name;
		this.level = level;
		this.effect = effect;
		this.description = description;
		this.createTime = createTime;
		this.clear = isClear;
		this.clearTime = clearTime;
		this.ack = isAck;
		this.ackTime = ackTime;
		this.maintainerId = maintainerId;
	}
	
	public String getNeName() {
		return neName;
	}

	public void setNeName(String neName) {
		this.neName = neName;
	}

	public String getAlarmSource() {
		return alarmSource;
	}

	public void setAlarmSource(String alarmSrouce) {
		this.alarmSource = alarmSrouce;
	}
	
	public String getNeid() {
		return neid;
	}

	public void setNeid(String neid) {
		this.neid = neid;
	}

	public String getStreamCode() {
		return streamCode;
	}

	public void setStreamCode(String streamCode) {
		this.streamCode = streamCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String isClear) {
		this.clear = isClear;
	}

	public String getClearTime() {
		return clearTime;
	}

	public void setClearTime(String clearTime) {
		this.clearTime = clearTime;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String isAck) {
		this.ack = isAck;
	}

	public String getAckTime() {
		return ackTime;
	}

	public void setAckTime(String ackTime) {
		this.ackTime = ackTime;
	}

	public String getMaintainerId() {
		return maintainerId;
	}

	public void setMaintainerId(String maintainerId) {
		this.maintainerId = maintainerId;
	}

	@Override
	public String toString() {
		return "Alarm [streamCode=" + streamCode + ", type=" + type + ", name=" + name + ", neid=" + neid + ", neName="
				+ neName + ", alarmSrouce=" + alarmSource + ", level=" + level + ", effect=" + effect + ", description="
				+ description + ", createTime=" + createTime + ", clear=" + clear + ", clearTime=" + clearTime
				+ ", ack=" + ack + ", ackTime=" + ackTime + ", maintainerId=" + maintainerId + ", remarks=" + remarks
				+ ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate="
				+ updateDate + ", delFlag=" + delFlag + ", id=" + id + ", currentUser=" + currentUser + ", page=" + page
				+ ", sqlMap=" + sqlMap + ", isNewRecord=" + isNewRecord + ", getNeName()=" + getNeName()
				+ ", getAlarmSrouce()=" + getAlarmSource() + ", getNeid()=" + getNeid() + ", getStreamCode()="
				+ getStreamCode() + ", getType()=" + getType() + ", getName()=" + getName() + ", getLevel()="
				+ getLevel() + ", getEffect()=" + getEffect() + ", getDescription()=" + getDescription()
				+ ", getCreateTime()=" + getCreateTime() + ", getClear()=" + getClear() + ", getClearTime()="
				+ getClearTime() + ", getAck()=" + getAck() + ", getAckTime()=" + getAckTime() + ", getMaintainerId()="
				+ getMaintainerId() + ", getRemarks()=" + getRemarks() + ", getCreateBy()=" + getCreateBy()
				+ ", getCreateDate()=" + getCreateDate() + ", getUpdateBy()=" + getUpdateBy() + ", getUpdateDate()="
				+ getUpdateDate() + ", getDelFlag()=" + getDelFlag() + ", getId()=" + getId() + ", getCurrentUser()="
				+ getCurrentUser() + ", getPage()=" + getPage() + ", getSqlMap()=" + getSqlMap() + ", getIsNewRecord()="
				+ getIsNewRecord() + ", getGlobal()=" + getGlobal() + ", getDbName()=" + getDbName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
