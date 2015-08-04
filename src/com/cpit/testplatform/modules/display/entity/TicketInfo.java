package com.cpit.testplatform.modules.display.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class TicketInfo {
    private String ticketId;

    private String neId;

    private String neLabel;

    private String maintainerId;

    private Date createTime;

    private String detail;

    private Integer flag;

    private Date endTime;

    private String result;

    private String maintainerName;

	/**
	 * 当前实体分页对象
	 */
	protected Page<TicketInfo> page;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getNeId() {
        return neId;
    }

    public void setNeId(String neId) {
        this.neId = neId;
    }

    public String getNeLabel() {
        return neLabel;
    }

    public void setNeLabel(String neLabel) {
        this.neLabel = neLabel;
    }

    public String getMaintainerId() {
        return maintainerId;
    }

    public void setMaintainerId(String maintainerId) {
        this.maintainerId = maintainerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

	public String getMaintainerName() {
		return maintainerName;
	}

	public void setMaintainerName(String maintainerName) {
		this.maintainerName = maintainerName;
	}
    
	@JsonIgnore
	@XmlTransient
	public Page<TicketInfo> getPage() {
		if (page == null){
			page = new Page<TicketInfo>();
		}
		return page;
	}
	
	public Page<TicketInfo> setPage(Page<TicketInfo> page) {
		this.page = page;
		return page;
	}

    
}