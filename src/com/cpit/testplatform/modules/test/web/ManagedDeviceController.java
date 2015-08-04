/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.test.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cpit.testplatform.modules.test.dao.AlarmDao;
import com.cpit.testplatform.modules.test.dao.ManagedDeviceDao;
import com.cpit.testplatform.modules.test.entity.Alarm;
import com.cpit.testplatform.modules.test.entity.Areadivision;
import com.cpit.testplatform.modules.test.entity.Maintainer;
import com.cpit.testplatform.modules.test.entity.ManagedDevice;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * @author zhb
 */
@Controller
@RequestMapping(value = "${adminPath}/test/managedDevice")
public class ManagedDeviceController extends BaseController {

	@Autowired
	private ManagedDeviceDao daoMd;
	@Autowired
	private AlarmDao daoAl;
	
	@ModelAttribute
	public ManagedDevice get(@RequestParam(required=false) String id) {
		System.out.println("ManagedDevice get invoke id: " + id);
		if (StringUtils.isNotBlank(id)){
			ManagedDevice m = daoMd.get(id);
			if (m == null) {
				new ManagedDevice();
			}
			return m;
		}else{
			return new ManagedDevice();
		}
	}

	/**
	 * no paging
	 * @param managedDevice
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
//	@RequiresPermissions("test:Areadivision:view")
//	@RequestMapping(value = {"nelist", ""})
//	public String nelist(ManagedDevice managedDevice, HttpServletRequest request, HttpServletResponse response, Model model) {
//		System.out.println("nelist invoke");
//		Page<ManagedDevice> page = new Page<ManagedDevice>(request, response);
//		List<ManagedDevice> all = daoMd.getAll();
//		for (ManagedDevice a : all) {
//			Map<String, String> cond = new HashMap<String, String>();
//			cond.put("level", "严重告警");
//			cond.put("neid", a.getNeid());
//			a.setCritical(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
//			cond.put("level", "主要告警");
//			a.setMajor(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
//			cond.put("level", "次要告警");
//			a.setMinor(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
//			cond.put("level", "警告告警");
//			a.setWarn(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
//		}
//		System.out.println("nelist all: " + all);
//		page.setList(all);
//        model.addAttribute("page", page);
//		return "modules/test/managedDeviceList";
//	}
	
	@RequestMapping(value = {"nelist", ""})
	public String nelist(ManagedDevice managedDevice, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("nelist invoke");
		Page<ManagedDevice> page = new Page<ManagedDevice>(request, response);
		managedDevice.setPage(page);
		page.setList(daoMd.findList(managedDevice));

		for (ManagedDevice a : page.getList()) {
			Map<String, String> cond = new HashMap<String, String>();
			cond.put("level", "严重告警");
			cond.put("neid", a.getNeid());
			a.setCritical(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
			cond.put("level", "主要告警");
			a.setMajor(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
			cond.put("level", "次要告警");
			a.setMinor(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
			cond.put("level", "警告告警");
			a.setWarn(String.valueOf(daoAl.getAlarmCountByLevel(cond)));
		}
        model.addAttribute("page", page);
		return "modules/test/managedDeviceList";
	}

//	@RequiresPermissions("test:Areadivision:view")
	@RequestMapping(value = "nealarmlist")
	public String nealarmlist(@RequestParam("neid") String neid, HttpServletRequest request, HttpServletResponse response, ManagedDevice managedDevice, Model model) {
		System.out.println("nealarmlist invoke : " + neid);
		List<Alarm> all = daoAl.getByNeid(neid);
		Page<Alarm> page = new Page<Alarm>(request, response);
		if (all == null || all.size() == 0) {
			model.addAttribute("page", page);
			model.addAttribute("neid", neid);
			return "modules/test/managedDeviceNeAlarmList";
		}
		for (Alarm a : all) {
			ManagedDevice md = daoMd.getByNeid(a.getNeid());
			if (md == null) {
				continue;
			}
			a.setNeName(md.getNeName());
		}
		page.setList(all);
		model.addAttribute("page", page);
		model.addAttribute("neid", neid);
		return "modules/test/managedDeviceNeAlarmList";
	}

//	@RequiresPermissions("test:Areadivision:view")
	@RequestMapping(value = "alarminfo")
	public String alarminfo(@RequestParam("alarmStreamCode") String alarmStreamCode, HttpServletRequest request, HttpServletResponse response, ManagedDevice managedDevice, Model model) {
		System.out.println("alarminfo invoke : " + alarmStreamCode);
		Alarm alarm = daoAl.getByStreamCode(alarmStreamCode);
		model.addAttribute("alarm", alarm);
		model.addAttribute("neid", alarm.getNeid());
		model.addAttribute("alarmStreamCode", alarmStreamCode);
		return "modules/test/managedDeviceNeAlarmInfo";
	}
	
//	@RequiresPermissions("test:Areadivision:view")
	@RequestMapping(value = "handle")
	public String handle(@RequestParam("streamCode") String streamCode, 
			@RequestParam("type") String type, 
			HttpServletRequest request, HttpServletResponse response, 
			ManagedDevice managedDevice, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("handle invoke : " + streamCode + "\ttype : " + type);
		Alarm alarm = daoAl.getByStreamCode(streamCode);
		if (type.equals("1")) {
			// clear
			alarm.setClear("YES");
			alarm.setClearTime(new Date().toString());
			addMessage(redirectAttributes, "清除告警" + "成功");
		} else {
			// ack
			alarm.setAck("YES");
			alarm.setAckTime(new Date().toString());
			addMessage(redirectAttributes, "确认告警" + "成功");
		}
		daoAl.update(alarm);
		model.addAttribute("alarm", alarm);
		model.addAttribute("neid", alarm.getNeid());
		model.addAttribute("alarmStreamCode", streamCode);
		return "modules/test/managedDeviceNeAlarmInfo";
//		return "redirect:" + adminPath + "/test/managedDevice/nealarmlist?neid="+alarm.getNeid()+"&repage";
//		return "redirect:" + adminPath + "/test/managedDevice/nelist?repage";
	}
}
