package com.cpit.testplatform.modules.test.dao;

import com.cpit.testplatform.modules.test.entity.AreaMaintainer;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface AreaMaintainerDao extends CrudDao<AreaMaintainer> {
	AreaMaintainer getByName(String name);
	void deleteByAreaCode(String areaCode);
}