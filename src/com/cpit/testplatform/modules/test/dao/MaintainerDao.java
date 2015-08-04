package com.cpit.testplatform.modules.test.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.cpit.testplatform.modules.test.entity.Maintainer;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface MaintainerDao extends CrudDao<Maintainer> {
	Maintainer getByName(String name);
	void addOne(Maintainer m);
}