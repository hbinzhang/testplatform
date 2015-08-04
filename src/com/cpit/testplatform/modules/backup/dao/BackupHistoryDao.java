package com.cpit.testplatform.modules.backup.dao;

import java.util.List;

import com.cpit.testplatform.modules.backup.entity.BackupHistory;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface BackupHistoryDao {

	int deleteByPrimaryKey(Integer id);

	int insert(BackupHistory record);

	BackupHistory selectByPrimaryKey(Integer id);

	List<BackupHistory> findList(BackupHistory history);
}