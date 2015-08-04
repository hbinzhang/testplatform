/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.custom.service;

//import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpit.testplatform.modules.custom.dao.RelationRuleDao;
import com.cpit.testplatform.modules.custom.dao.SeverityRuleDao;
import com.cpit.testplatform.modules.custom.dao.SourceRuleDao;
import com.cpit.testplatform.modules.custom.entity.RelationRule;
import com.cpit.testplatform.modules.custom.entity.SeverityRule;
import com.cpit.testplatform.modules.custom.entity.SourceRule;
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
public class FilterService extends BaseService {

	@Autowired
	private SourceRuleDao sourceDao;

	@Autowired
	private SeverityRuleDao severityDao;

	@Autowired
	private RelationRuleDao relationDao;


	public SeverityRule findSeverity() {
		return severityDao.select();
	}

	@Transactional(readOnly = false)
	public void saveSeverity(SeverityRule rule) {
		severityDao.update(rule);
	}

	public Page<RelationRule> findRelation(Page<RelationRule> page,
			RelationRule rule) {
		// 设置分页参数
		rule.setPage(page);
		// 执行分页查询
		page.setList(relationDao.findList(rule));
		return page;
	}

	public RelationRule getRelationRuleByName(String name) {
		return relationDao.selectByPrimaryKey(name);
	}

	@Transactional(readOnly = false)
	public void saveRelation(RelationRule rule) {
		int count = relationDao.updateByPrimaryKey(rule);
		if (count == 0){
			relationDao.insert(rule);
		}
	}

	@Transactional(readOnly = false)
	public void deleteRelation(RelationRule rule) {
		relationDao.deleteByPrimaryKey(rule.getName());
	}

	public Page<SourceRule> findSource(Page<SourceRule> page, SourceRule rule) {
		// 设置分页参数
		rule.setPage(page);
		// 执行分页查询
		page.setList(sourceDao.findList(rule));
		return page;
	}

	@Transactional(readOnly = false)
	public void saveSource(SourceRule rule) {
		sourceDao.insert(rule);
	}

	@Transactional(readOnly = false)
	public void deleteSource(SourceRule rule) {
		sourceDao.deleteByPrimaryKey(rule.getName());
	}

	public SourceRule getSourceRuleByName(String name) {
		return sourceDao.selectByPrimaryKey(name);
	}


}
