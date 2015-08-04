package com.cpit.testplatform.modules.test.dao;

import java.util.List;
import java.util.Map;

import com.cpit.testplatform.modules.test.entity.Alarm;
import com.cpit.testplatform.modules.test.entity.AreaDevice;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface AlarmDao extends CrudDao<Alarm> {
	List<Alarm> getAll();
	List<Alarm> getByNeid(String neid);
	Alarm getByStreamCode(String code);
	int getAlarmCountByLevel(Map cond);
}