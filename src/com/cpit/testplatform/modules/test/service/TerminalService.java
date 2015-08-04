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

import com.cpit.testplatform.modules.test.dao.TerminalDao;
import com.cpit.testplatform.modules.test.entity.Terminal;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
//import org.activiti.engine.IdentityService;
//import org.activiti.engine.identity.Group;
import com.thinkgem.jeesite.modules.sys.entity.Role;

/**
 * 终端管理，相关实体的管理类
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class TerminalService extends BaseService implements InitializingBean {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	private TerminalDao terminalDao;
	

//	@Autowired
//	private IdentityService identityService;

	//-- User Service --//
	public Terminal getTerminal(String id) {
		return terminalDao.get(id);
	}

	
	public Page<Terminal> findTerminal(Page<Terminal> page, Terminal terminal) {
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		terminal.getSqlMap().put("dsf", dataScopeFilter(terminal.getCurrentUser(), "o", "a"));
		// 设置分页参数
		terminal.setPage(page);
		// 执行分页查询
		page.setList(terminalDao.findList(terminal));
		return page;
	}
	
	/**
	 * 无分页查询终端列表
	 * @param terminal
	 * @return
	 */
	public List<Terminal> findTerminal(Terminal terminal){
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		terminal.getSqlMap().put("dsf", dataScopeFilter(terminal.getCurrentUser(), "o", "a"));
		List<Terminal> list = terminalDao.findList(terminal);
		return list;
	}

	@Transactional(readOnly = false)
	public void saveTerminal(Terminal user) {
		if (StringUtils.isBlank(user.getId())){
			user.preInsert();
			terminalDao.insert(user);
		}else{
			// 更新用户数据
			user.preUpdate();
			terminalDao.update(user);
		}
	}
	
	@Transactional(readOnly = false)
	public void updateTerminal(Terminal user) {
		user.preUpdate();
		terminalDao.update(user);
	}
	
	@Transactional(readOnly = false)
	public void deleteTerminal(Terminal user) {
		terminalDao.delete(user);
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
//		if (isSynActivitiIndetity){
//			isSynActivitiIndetity = false;
//	        // 同步角色数据
//			List<Group> groupList = identityService.createGroupQuery().list();
//			if (groupList.size() == 0){
//			 	Iterator<Role> roles = roleDao.findAllList(new Role()).iterator();
//			 	while(roles.hasNext()) {
//			 		Role role = roles.next();
//			 		saveActivitiGroup(role);
//			 	}
//			}
//		 	// 同步用户数据
//			List<org.activiti.engine.identity.User> userList = identityService.createUserQuery().list();
//			if (userList.size() == 0){
//			 	Iterator<User> users = userDao.findAllList(new User()).iterator();
//			 	while(users.hasNext()) {
//			 		saveActivitiUser(users.next());
//			 	}
//			}
//		}
	}


	public Terminal getTerminalByName(String name) {
		return terminalDao.getByName(name);
	}
	
	
}
