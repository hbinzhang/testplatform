package com.cpit.testplatform.modules.display.dao;

import com.cpit.testplatform.modules.display.entity.TicketTrack;
import com.cpit.testplatform.modules.display.entity.TicketTrackExample;
import com.cpit.testplatform.modules.display.entity.TicketTrackKey;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface TicketTrackDao {
    int countByExample(TicketTrackExample example);

    int deleteByExample(TicketTrackExample example);

    int deleteByPrimaryKey(TicketTrackKey key);

    int insert(TicketTrack record);

    int insertSelective(TicketTrack record);

    List<TicketTrack> selectByExample(TicketTrackExample example);

    TicketTrack selectByPrimaryKey(TicketTrackKey key);

    int updateByExampleSelective(@Param("record") TicketTrack record, @Param("example") TicketTrackExample example);

    int updateByExample(@Param("record") TicketTrack record, @Param("example") TicketTrackExample example);

    int updateByPrimaryKeySelective(TicketTrack record);

    int updateByPrimaryKey(TicketTrack record);

	List<TicketTrack> findList(TicketTrack track);
}