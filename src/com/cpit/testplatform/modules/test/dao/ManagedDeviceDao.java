package com.cpit.testplatform.modules.test.dao;

import java.util.List;

import com.cpit.testplatform.modules.test.entity.ManagedDevice;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface ManagedDeviceDao extends CrudDao<ManagedDevice> {
	ManagedDevice getByName(String name);
	List<ManagedDevice> getAll();
	ManagedDevice getByNeid(String neid);
}