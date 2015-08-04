package com.cpit.testplatform.modules.backup.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class BackupHistory {
    private Integer id;

    private Date startTime;

    private Integer duration;

    private Integer type;

    private Byte result;

    private String filePath;

    private Integer fileSize;
    
    //查询条件
    private Date endTime;
    
	/**
	 * 当前实体分页对象
	 */
	protected Page<BackupHistory> page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    
	@JsonIgnore
	@XmlTransient
	public Page<BackupHistory> getPage() {
		if (page == null){
			page = new Page<BackupHistory>();
		}
		return page;
	}
	
	public Page<BackupHistory> setPage(Page<BackupHistory> page) {
		this.page = page;
		return page;
	}

	@JsonIgnore
	@XmlTransient
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
}