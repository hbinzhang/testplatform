/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.backup.service;

//import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpit.testplatform.modules.backup.dao.BackupHistoryDao;
import com.cpit.testplatform.modules.backup.dao.BackupPlanDao;
import com.cpit.testplatform.modules.backup.entity.BackupHistory;
import com.cpit.testplatform.modules.backup.entity.BackupPlan;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 告警过滤规则管理，相关实体的管理类
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class BackupService extends BaseService {

	@Autowired
	private BackupHistoryDao historyDao;

	@Autowired
	private BackupPlanDao planDao;

	public BackupPlan getBackupPlan(Integer id) {
		return planDao.selectByPrimaryKey(id);
	}

	public List<BackupPlan> findPlan() {
		return planDao.findList();
	}

	@Transactional(readOnly = false)
	public void savePlan(BackupPlan plan) {
		planDao.insert(plan);

	}

	@Transactional(readOnly = false)
	public void deletePan(BackupPlan plan) {
		planDao.deleteByPrimaryKey(plan.getId());

	}

	public Page<BackupHistory> findHistory(Page<BackupHistory> page,
			BackupHistory history) {
		// 设置分页参数
		history.setPage(page);
		// 执行分页查询
		page.setList(historyDao.findList(history));
		return page;
	}

	@Transactional(readOnly = false)
	public void deleteHistory(BackupHistory history) {
		historyDao.deleteByPrimaryKey(history.getId());

	}

	public BackupHistory getBackupHistory(Integer id) {
		return historyDao.selectByPrimaryKey(id);
	}

}
