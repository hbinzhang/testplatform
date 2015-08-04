package com.cpit.testplatform.modules.custom.entity;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

public class SourceRule {
    private String name;

	/**
	 * 当前实体分页对象
	 */
	protected Page<SourceRule> page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@JsonIgnore
	@XmlTransient
	public Page<SourceRule> getPage() {
		if (page == null){
			page = new Page<SourceRule>();
		}
		return page;
	}
	
	public Page<SourceRule> setPage(Page<SourceRule> page) {
		this.page = page;
		return page;
	}

}