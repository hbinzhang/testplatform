package com.cpit.testplatform.modules.stat.entity;

import java.io.Serializable;
import java.util.Date;

public class AlarmStatKey implements Serializable {
	
	private static final long serialVersionUID = 986532415478L;

	private Date statTime;

    private String neId;

    public AlarmStatKey() {
		super();
	}

	public AlarmStatKey(Date statTime, String neId) {
		super();
		this.statTime = statTime;
		this.neId = neId;
	}

	public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public String getNeId() {
        return neId;
    }

    public void setNeId(String neId) {
        this.neId = neId;
    }

	@Override
	public String toString() {
		return "AlarmStatKey [statTime=" + statTime + ", neId=" + neId + "]";
	}
    
}