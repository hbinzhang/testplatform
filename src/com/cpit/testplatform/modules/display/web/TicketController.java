/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.display.web;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpit.testplatform.modules.display.entity.TicketInfo;
import com.cpit.testplatform.modules.display.entity.TicketProcess;
import com.cpit.testplatform.modules.display.entity.TicketTrack;
import com.cpit.testplatform.modules.display.service.TicketService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 故障工单Controller
 * 
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/display/ticket")
public class TicketController extends BaseController {

	@Autowired
	private TicketService systemService;

	@ModelAttribute("ticket")
	public TicketInfo get(@RequestParam(required = false) String ticketId) {
		if (StringUtils.isNotBlank(ticketId)) {
			TicketInfo t = systemService.getTicket(ticketId);
			if (t == null) {
				t = new TicketInfo();
			}
			return t;
		} else {
			return new TicketInfo();
		}
	}

	@RequestMapping(value = { "ticketlist" })
	public String ticketlist(TicketInfo ticket, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<TicketInfo> page = systemService.findTicketList(new Page<TicketInfo>(
				request, response), ticket);
		model.addAttribute("page", page);
		return "modules/display/ticketList";
	}

	@RequestMapping(value = { "ticketform" })
	public String ticketform(TicketInfo ticket, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		TicketInfo detail = systemService.getTicket(ticket.getTicketId());
		model.addAttribute("ticket", detail);
		return "modules/display/ticketForm";
	}

	@RequestMapping(value = { "tracklist" })
	public String tracklist(TicketTrack track, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<TicketTrack> page = systemService.findTrackList(
				new Page<TicketTrack>(request, response), track);
		model.addAttribute("track", track);
		model.addAttribute("page", page);
		model.addAttribute("mapdata", getPoints(page));
		return "modules/display/ticketTrackList";
	}

	/**
	 * 取出坐标数据，用于地图标注
	 * @param page 工单轨迹列表
	 * @return 坐标数据，数组字符串格式[[],[]]
	 */
	private String getPoints(Page<TicketTrack> page){
		List<TicketTrack> list = page.getList();
		StringBuilder s = new StringBuilder();
		s.append('[');
		DecimalFormat f = new DecimalFormat("0.0000");
		for (TicketTrack track:list){
			s.append('[').append(f.format(track.getLongtitude())).append(',')
					.append(f.format(track.getLatitude())).append("],");
		}
		if (s.length()==1){
			s.append(']');
		}else{
			//替换,为]
			s.setCharAt(s.length()-1, ']');
		}
		return s.toString();
	}
	
	@RequestMapping(value = { "processlist" })
	public String processlist(TicketProcess process, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<TicketProcess> page = systemService.findProcessList(
				new Page<TicketProcess>(request, response), process);
		model.addAttribute("process", process);
		model.addAttribute("page", page);
		return "modules/display/ticketProcessList";
	}

}
