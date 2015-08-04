package com.cpit.testplatform.modules.custom.dao;

import com.cpit.testplatform.modules.custom.entity.SeverityRule;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface SeverityRuleDao {

	int insert(SeverityRule record);

	SeverityRule select();

	int update(SeverityRule record);

}