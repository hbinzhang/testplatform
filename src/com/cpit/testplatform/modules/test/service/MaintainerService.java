/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.test.service;

//import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpit.testplatform.modules.test.dao.MaintainerDao;
import com.cpit.testplatform.modules.test.entity.Maintainer;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * 终端管理，相关实体的管理类
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class MaintainerService extends BaseService implements InitializingBean {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	private MaintainerDao dao;
	

//	@Autowired
//	private IdentityService identityService;

	//-- User Service --//
	public Maintainer get(String id) {
		return dao.get(id);
	}

	
	public Page<Maintainer> find(Page<Maintainer> page, Maintainer maintainer) {
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		maintainer.getSqlMap().put("dsf", dataScopeFilter(maintainer.getCurrentUser(), "o", "a"));
		// 设置分页参数
		maintainer.setPage(page);
		// 执行分页查询
		page.setList(dao.findList(maintainer));
		return page;
	}
	
	/**
	 * 无分页查询终端列表
	 * @param terminal
	 * @return
	 */
	public List<Maintainer> find(Maintainer terminal){
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		terminal.getSqlMap().put("dsf", dataScopeFilter(terminal.getCurrentUser(), "o", "a"));
		List<Maintainer> list = dao.findList(terminal);
		return list;
	}

	@Transactional(readOnly = false)
	public void save(Maintainer user) {
		if (StringUtils.isBlank(user.getId())){
			user.preInsert();
			dao.insert(user);
		}else{
			// 更新用户数据
			user.preUpdate();
			dao.update(user);
		}
	}
	
	@Transactional(readOnly = false)
	public void update(Maintainer user) {
		user.preUpdate();
		dao.update(user);
	}
	
	@Transactional(readOnly = false)
	public void delete(Maintainer user) {
		dao.delete(user);
	}
	
	
	
	

	
	///////////////// Synchronized to the Activiti //////////////////
	
	// 已废弃，同步见：ActGroupEntityServiceFactory.java、ActUserEntityServiceFactory.java

//	/**
//	 * 是需要同步Activiti数据，如果从未同步过，则同步数据。
//	 */
//	private static boolean isSynActivitiIndetity = true;
	public void afterPropertiesSet() throws Exception {
		if (!Global.isSynActivitiIndetity()){
			return;
		}
	}


	public Maintainer getTerminalByName(String name) {
		return dao.getByName(name);
	}
	
	
}
