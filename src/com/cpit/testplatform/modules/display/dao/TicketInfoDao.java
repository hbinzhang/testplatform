package com.cpit.testplatform.modules.display.dao;

import com.cpit.testplatform.modules.display.entity.TicketInfo;
import com.cpit.testplatform.modules.display.entity.TicketInfoExample;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface TicketInfoDao {
    int countByExample(TicketInfoExample example);

    int deleteByExample(TicketInfoExample example);

    int deleteByPrimaryKey(String ticketId);

    int insert(TicketInfo record);

    int insertSelective(TicketInfo record);

    List<TicketInfo> selectByExample(TicketInfoExample example);

    TicketInfo selectByPrimaryKey(String ticketId);

    int updateByExampleSelective(@Param("record") TicketInfo record, @Param("example") TicketInfoExample example);

    int updateByExample(@Param("record") TicketInfo record, @Param("example") TicketInfoExample example);

    int updateByPrimaryKeySelective(TicketInfo record);

    int updateByPrimaryKey(TicketInfo record);

	List<TicketInfo> findList(TicketInfo ticket);
}