package com.cpit.testplatform.modules.display.dao;

import com.cpit.testplatform.modules.display.entity.TicketProcess;
import com.cpit.testplatform.modules.display.entity.TicketProcessExample;
import com.cpit.testplatform.modules.display.entity.TicketProcessKey;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface TicketProcessDao {
    int countByExample(TicketProcessExample example);

    int deleteByExample(TicketProcessExample example);

    int deleteByPrimaryKey(TicketProcessKey key);

    int insert(TicketProcess record);

    int insertSelective(TicketProcess record);

    List<TicketProcess> selectByExample(TicketProcessExample example);

    TicketProcess selectByPrimaryKey(TicketProcessKey key);

    int updateByExampleSelective(@Param("record") TicketProcess record, @Param("example") TicketProcessExample example);

    int updateByExample(@Param("record") TicketProcess record, @Param("example") TicketProcessExample example);

    int updateByPrimaryKeySelective(TicketProcess record);

    int updateByPrimaryKey(TicketProcess record);

	List<TicketProcess> findList(TicketProcess process);
}