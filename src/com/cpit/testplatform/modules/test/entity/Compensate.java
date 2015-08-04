package com.cpit.testplatform.modules.test.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class Compensate extends DataEntity<Compensate> {

	private static final long serialVersionUID = 6232434454L;

	private String id;
	
	private String startTime;
	
	private String endTime;
	
	private String devices;
	
	private String intervals;

	public Compensate() {
		super();
	}

	public Compensate(String id, String startTime, String endTime, String devices) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.devices = devices;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDevices() {
		return devices;
	}

	public void setDevices(String devices) {
		this.devices = devices;
	}
	
	public String getIntervals() {
		return intervals;
	}

	public void setIntervals(String intervals) {
		this.intervals = intervals;
	}

	@Override
	public String toString() {
		return "Compensate [id=" + id + ", startTime=" + ", intervals=" + intervals + ", endTime=" + endTime + ", devices=" + devices
				+ "]";
	}


	
	
}