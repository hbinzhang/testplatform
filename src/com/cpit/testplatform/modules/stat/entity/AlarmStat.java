package com.cpit.testplatform.modules.stat.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class AlarmStat extends AlarmStatKey {

	private String neLabel;

    private Integer total;
    
    private Integer duration;
    
    private Integer criticalCount;
    private Integer majorCount;
    private Integer minorCount;
    private Integer warnCount;

	/**
	 * 当前实体分页对象
	 */
	protected Page<AlarmStat> page;

    public String getNeLabel() {
        return neLabel;
    }

    public void setNeLabel(String neLabel) {
        this.neLabel = neLabel;
    }

    public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

	public Integer getCriticalCount() {
		return criticalCount;
	}

	public void setCriticalCount(Integer criticalCount) {
		this.criticalCount = criticalCount;
	}

	public Integer getMajorCount() {
		return majorCount;
	}

	public void setMajorCount(Integer majorCount) {
		this.majorCount = majorCount;
	}

	public Integer getMinorCount() {
		return minorCount;
	}

	public void setMinorCount(Integer minorCount) {
		this.minorCount = minorCount;
	}

	public Integer getWarnCount() {
		return warnCount;
	}

	public void setWarnCount(Integer warnCount) {
		this.warnCount = warnCount;
	}

	@JsonIgnore
	@XmlTransient
	public Page<AlarmStat> getPage() {
		if (page == null){
			page = new Page<AlarmStat>();
		}
		return page;
	}
	
	public Page<AlarmStat> setPage(Page<AlarmStat> page) {
		this.page = page;
		return page;
	}
    
	@Override
	public String toString() {
		return "AlarmStat [neLabel=" + neLabel + ", total=" + total + ", duration=" + duration + ", criticalCount="
				+ criticalCount + ", majorCount=" + majorCount + ", minorCount=" + minorCount + ", warnCount="
				+ warnCount + ", page=" + page + "]";
	}
    
}