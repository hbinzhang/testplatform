package com.cpit.testplatform.modules.custom.dao;

import java.util.List;

import com.cpit.testplatform.modules.custom.entity.SourceRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface SourceRuleDao {
	int deleteByPrimaryKey(String name);

	int insert(SourceRule name);

	SourceRule selectByPrimaryKey(String name);

	List<SourceRule> findList(SourceRule rule);
}