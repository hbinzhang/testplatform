package com.cpit.testplatform.modules.stat.dao;

import java.util.List;

import com.cpit.testplatform.modules.stat.entity.AlarmStat;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface AlarmStatDao {

	int insert(AlarmStat record);

	List<AlarmStat> selectByDay(AlarmStat key);

	List<AlarmStat> selectByMonth(AlarmStat key);

	int addStat(AlarmStat record);
}