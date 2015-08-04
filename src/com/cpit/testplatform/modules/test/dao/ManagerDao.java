package com.cpit.testplatform.modules.test.dao;

import com.cpit.testplatform.modules.test.entity.Manager;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface ManagerDao extends CrudDao<Manager> {
	Manager getByName(String name);
}