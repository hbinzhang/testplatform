package com.cpit.testplatform.modules.test.dao;

import com.cpit.testplatform.modules.test.entity.AreaDevice;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface AreaDeviceDao extends CrudDao<AreaDevice> {
	AreaDevice getByName(String name);
	void deleteByAreaCode(String areaCode);
}