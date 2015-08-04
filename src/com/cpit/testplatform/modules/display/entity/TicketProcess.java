package com.cpit.testplatform.modules.display.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class TicketProcess extends TicketProcessKey {
    private String processResult;

	/**
	 * 当前实体分页对象
	 */
	protected Page<TicketProcess> page;

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }
    
	@JsonIgnore
	@XmlTransient
	public Page<TicketProcess> getPage() {
		if (page == null){
			page = new Page<TicketProcess>();
		}
		return page;
	}
	
	public Page<TicketProcess> setPage(Page<TicketProcess> page) {
		this.page = page;
		return page;
	}

}