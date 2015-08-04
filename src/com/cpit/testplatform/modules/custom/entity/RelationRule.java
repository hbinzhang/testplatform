package com.cpit.testplatform.modules.custom.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class RelationRule {
    private String name;

    private String alarmType;

    private Integer timeRange;

    private String relatedAlarmType;

	/**
	 * 当前实体分页对象
	 */
	protected Page<RelationRule> page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(Integer timeRange) {
        this.timeRange = timeRange;
    }

    public String getRelatedAlarmType() {
        return relatedAlarmType;
    }

    public void setRelatedAlarmType(String relatedAlarmType) {
        this.relatedAlarmType = relatedAlarmType;
    }
    
	@JsonIgnore
	@XmlTransient
	public Page<RelationRule> getPage() {
		if (page == null){
			page = new Page<RelationRule>();
		}
		return page;
	}
	
	public Page<RelationRule> setPage(Page<RelationRule> page) {
		this.page = page;
		return page;
	}

}