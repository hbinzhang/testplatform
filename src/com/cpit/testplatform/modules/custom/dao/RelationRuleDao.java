package com.cpit.testplatform.modules.custom.dao;

import java.util.List;

import com.cpit.testplatform.modules.custom.entity.RelationRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface RelationRuleDao {
	int deleteByPrimaryKey(String name);

	int insert(RelationRule record);

	RelationRule selectByPrimaryKey(String name);

	int updateByPrimaryKey(RelationRule record);

	List<RelationRule> findList(RelationRule rule);
}