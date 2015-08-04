/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.display.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpit.testplatform.modules.display.dao.TicketInfoDao;
import com.cpit.testplatform.modules.display.dao.TicketProcessDao;
import com.cpit.testplatform.modules.display.dao.TicketTrackDao;
import com.cpit.testplatform.modules.display.entity.TicketInfo;
import com.cpit.testplatform.modules.display.entity.TicketProcess;
import com.cpit.testplatform.modules.display.entity.TicketTrack;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 告警过滤规则管理，相关实体的管理类
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class TicketService extends BaseService {

	@Autowired
	private TicketInfoDao ticketDao;
	@Autowired
	private TicketTrackDao trackDao;
	@Autowired
	private TicketProcessDao processDao;

	public TicketInfo getTicket(String ticketId) {
		return ticketDao.selectByPrimaryKey(ticketId);
	}

	public Page<TicketInfo> findTicketList(Page<TicketInfo> page,
			TicketInfo ticket) {
		// 设置分页参数
		ticket.setPage(page);
		// 执行分页查询
		page.setList(ticketDao.findList(ticket));
		return page;
	}

	public Page<TicketTrack> findTrackList(Page<TicketTrack> page,
			TicketTrack track) {
		// 设置分页参数
		track.setPage(page);
		// 执行分页查询
		page.setList(trackDao.findList(track));
		return page;
	}

	public Page<TicketProcess> findProcessList(Page<TicketProcess> page,
			TicketProcess process) {
		// 设置分页参数
		process.setPage(page);
		// 执行分页查询
		page.setList(processDao.findList(process));
		return page;
	}
}
