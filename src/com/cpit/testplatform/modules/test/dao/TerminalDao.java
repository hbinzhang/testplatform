package com.cpit.testplatform.modules.test.dao;

import com.cpit.testplatform.modules.test.entity.Terminal;
import com.cpit.testplatform.modules.test.entity.TerminalExample;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 测试终端DAO
 * @author cxw
 *
 */
@MyBatisDao
public interface TerminalDao extends CrudDao<Terminal> {
	int countByExample(TerminalExample example);

	int deleteByExample(TerminalExample example);

	List<Terminal> selectByExample(TerminalExample example);

	int updateByExampleSelective(@Param("record") Terminal record,
			@Param("example") TerminalExample example);

	int updateByExample(@Param("record") Terminal record,
			@Param("example") TerminalExample example);

	int updateByPrimaryKeySelective(Terminal record);

	Terminal getByName(String name);

}