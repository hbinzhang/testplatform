/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.stat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpit.testplatform.modules.stat.dao.AlarmStatDao;
import com.cpit.testplatform.modules.stat.entity.AlarmStat;
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
public class StatService extends BaseService {

	@Autowired
	private AlarmStatDao statDao;

	public Page<AlarmStat> findByDay(Page<AlarmStat> page, AlarmStat stat) {
		// 设置分页参数
		stat.setPage(page);
		// 执行分页查询
		page.setList(statDao.selectByDay(stat));
		return page;

	}

	public Page<AlarmStat> findByMonth(Page<AlarmStat> page, AlarmStat stat) {
		// 设置分页参数
		stat.setPage(page);
		// 执行分页查询
		page.setList(statDao.selectByMonth(stat));
		return page;

	}
}
