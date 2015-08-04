/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.stat.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpit.testplatform.modules.stat.entity.AlarmStat;
import com.cpit.testplatform.modules.stat.entity.AlarmStatKey;
import com.cpit.testplatform.modules.stat.service.StatService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 统计Controller
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/stat")
public class StatController extends BaseController {

	@Autowired
	private StatService systemService;
	
	@ModelAttribute
	public AlarmStat get(@RequestParam(required=false) String neId, @RequestParam(required=false) Date statTime) {
		AlarmStat stat = new AlarmStat();
		if (StringUtils.isNotBlank(neId)){
			stat.setNeId(neId);
			stat.setStatTime(statTime);;
		}
		return stat;
	}


//	@RequiresPermissions("test:terminal:view")
	@RequestMapping(value = {"region/"})
	public String statRegion(AlarmStat stat, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<AlarmStat> page = query(stat, request, response, model);
		request.getSession().setAttribute("statCondition",
				new AlarmStatKey(stat.getStatTime(), stat.getNeId()));
		Integer regionType = stat.getTotal();
		if (regionType != null && regionType.intValue() == 2) {
			return "modules/stat/regionStatByRegion";
		} else {
			return "modules/stat/regionStat";
		}
	}

//	@RequiresPermissions("test:terminal:view")
	@RequestMapping(value = {"alarm/table"})
	public String alarmTable(AlarmStat stat, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("alarmTable stat is: " + stat);
		Page<AlarmStat> page = query(stat,request,response,model);
		request.getSession().setAttribute("statCondition", new AlarmStatKey(stat.getStatTime(), stat.getNeId()));
		System.out.println("alarmTable result: " + page.getList().size());
		return "modules/stat/alarmTable";
	}

	@RequestMapping(value = {"alarm/chart"})
	public String alarmChart(AlarmStat stat, HttpServletRequest request, HttpServletResponse response, Model model) {
		AlarmStatKey statInSession = (AlarmStatKey)request.getSession().getAttribute("statCondition");
		System.out.println("alarmChart stat in session is: " + statInSession);
		if (stat == null) {
			stat = new AlarmStat();
		}
		stat.setStatTime(statInSession.getStatTime());
		stat.setNeId(statInSession.getNeId());
		Page<AlarmStat> page = query(stat,request,response,model);
		System.out.println("alarmChart result: " + page.getList().size());
		
		StringBuffer neNames = new StringBuffer();
		neNames.append("categories: [");
		StringBuffer criCount = new StringBuffer();
		criCount.append("data: [");
		StringBuffer majCount = new StringBuffer();
		majCount.append("data: [");
		StringBuffer minCount = new StringBuffer();
		minCount.append("data: [");
		StringBuffer warCount = new StringBuffer();
		warCount.append("data: [");
		
		List<AlarmStat> lls = page.getList();
		if (lls != null && lls.size() > 0) {
			for (AlarmStat as : lls) {
				neNames.append("'" + as.getNeLabel() + "'");
				neNames.append(",");
				
				criCount.append(as.getCriticalCount());
				criCount.append(",");
				
				majCount.append(as.getMajorCount());
				majCount.append(",");
				
				minCount.append(as.getMinorCount());
				minCount.append(",");
				
				warCount.append(as.getWarnCount());
				warCount.append(",");
			}
			neNames.deleteCharAt(neNames.length() - 1);
			criCount.deleteCharAt(criCount.length() - 1);
			majCount.deleteCharAt(majCount.length() - 1);
			minCount.deleteCharAt(minCount.length() - 1);
			warCount.deleteCharAt(warCount.length() - 1);
		}
		neNames.append("]");
		criCount.append("]");
		majCount.append("]");
		minCount.append("]");
		warCount.append("]");
		
		model.addAttribute("nenames", neNames.toString());
		model.addAttribute("criCount", criCount.toString());
		model.addAttribute("majCount", majCount.toString());
		model.addAttribute("minCount", minCount.toString());
		model.addAttribute("warCount", warCount.toString());
		
		System.out.println("alarmChart nenames is: " + neNames);
		System.out.println("alarmChart criCount is: " + criCount);
		System.out.println("alarmChart majCount is: " + majCount);
		System.out.println("alarmChart minCount is: " + minCount);
		System.out.println("alarmChart warCount is: " + warCount);
		return "modules/stat/alarmChart";
	}

	@RequestMapping(value = {"alarm/timechart"})
	public String alarmTChart(AlarmStat stat, HttpServletRequest request, HttpServletResponse response, Model model) {
		AlarmStatKey statInSession = (AlarmStatKey)request.getSession().getAttribute("statCondition");
		System.out.println("alarmChart stat in session is: " + statInSession);
		if (stat == null) {
			stat = new AlarmStat();
		}
		stat.setStatTime(statInSession.getStatTime());
		stat.setNeId(statInSession.getNeId());
		Page<AlarmStat> page = query(stat,request,response,model);
		System.out.println("alarmTChart result: " + page.getList().size());
		List<AlarmStat> lls = page.getList();
		StringBuffer neNames = new StringBuffer();
		// categories: ['海淀桥', '七里庄', '大红门', '北京SCA', '定慧桥']
		neNames.append("categories: [");
		
		StringBuffer alarmtimes = new StringBuffer();
		/* data: [5, 3, 4, 7, 2] */
		alarmtimes.append("data: [");
		
		if (lls != null && lls.size() > 0) {
			for (AlarmStat as : lls) {
				neNames.append("'" + as.getNeLabel() + "'");
				neNames.append(",");
				
				alarmtimes.append(as.getDuration());
				alarmtimes.append(",");
			}
			neNames.deleteCharAt(neNames.length() - 1);
			alarmtimes.deleteCharAt(alarmtimes.length() - 1);
		}
		neNames.append("]");
		alarmtimes.append("]");
		model.addAttribute("nenames", neNames.toString());
		model.addAttribute("alarmtimes", alarmtimes.toString());
		System.out.println("alarmChart nenames is: " + neNames);
		System.out.println("alarmChart alarmtimes is: " + alarmtimes);
		return "modules/stat/alarmTimeChart";
	}
	
	protected Page<AlarmStat> query(AlarmStat stat,HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("query is: " + stat);
		Calendar c = Calendar.getInstance();
		if (stat.getStatTime() != null) {
			c.setTime(stat.getStatTime());
		}
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		String type = stat.getNeId();
		Page<AlarmStat> page;
		if (type == null || type.isEmpty() || "day".equals(type.trim())){
			//以日统计
			//今天
			Date now = c.getTime();
			stat.setStatTime(now);
			
			page = systemService.findByDay(new Page<AlarmStat>(request, response), stat);
		}else{
			c.set(Calendar.DATE, 1);
			Date now = c.getTime();
			stat.setStatTime(now);
			page = systemService.findByMonth(new Page<AlarmStat>(request, response), stat);
		}
		model.addAttribute("stat", stat);
        model.addAttribute("page", page);
        return page;
	}
}
