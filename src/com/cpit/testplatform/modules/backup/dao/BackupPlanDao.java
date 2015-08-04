package com.cpit.testplatform.modules.backup.dao;

import java.util.List;

import com.cpit.testplatform.modules.backup.entity.BackupPlan;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface BackupPlanDao {

	int deleteByPrimaryKey(Integer id);

	int insert(BackupPlan record);

	BackupPlan selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(BackupPlan record);

	List<BackupPlan> findList();
}