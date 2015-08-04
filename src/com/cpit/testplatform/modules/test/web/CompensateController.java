/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.test.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cpit.testplatform.modules.test.dao.AreaDeviceDao;
import com.cpit.testplatform.modules.test.dao.AreaMaintainerDao;
import com.cpit.testplatform.modules.test.dao.MaintainerDao;
import com.cpit.testplatform.modules.test.dao.ManagedDeviceDao;
import com.cpit.testplatform.modules.test.entity.AreaDevice;
import com.cpit.testplatform.modules.test.entity.AreaMaintainer;
import com.cpit.testplatform.modules.test.entity.Areadivision;
import com.cpit.testplatform.modules.test.entity.Compensate;
import com.cpit.testplatform.modules.test.entity.CompensateMissing;
import com.cpit.testplatform.modules.test.entity.Maintainer;
import com.cpit.testplatform.modules.test.entity.ManagedDevice;
import com.cpit.testplatform.modules.test.service.AreadivisionService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * @author zhb
 */
@Controller
@RequestMapping(value = "${adminPath}/test/compensate")
public class CompensateController extends BaseController {

	@Autowired
	private AreadivisionService service;
	@Autowired
	private MaintainerDao daoMaint;
	@Autowired
	private AreaMaintainerDao daoAm;
	@Autowired
	private AreaDeviceDao daoAd;
	@Autowired
	private ManagedDeviceDao daoMd;
	
	@ModelAttribute
	public Areadivision get(@RequestParam(required=false) String id) {
		System.out.println("AreadivisionController get invoke id: " + id);
		if (StringUtils.isNotBlank(id)){
			Areadivision m = service.get(id);
			if (m == null) {
				new Areadivision();
			}
			return m;
		}else{
			return new Areadivision();
		}
	}


//	@RequiresPermissions("test:Areadivision:view")
	@RequestMapping(value = {"list", ""})
	public String list(Compensate compensate, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("list invoke");
		List<AreaDevice> deviceList = new ArrayList<AreaDevice>();
		List<ManagedDevice> allDv = daoMd.findList(new ManagedDevice());
		model.addAttribute("compensate", compensate);
		if (allDv != null && allDv.size() > 0) {
			int id = 5000;
			for (ManagedDevice m : allDv) {
				deviceList.add(new AreaDevice(String.valueOf(id++), "1", m.getNeName(), m.getNeid()));
			}
		}
		System.out.println("form invoke, deviceList is: " + deviceList);
		model.addAttribute("deviceList", deviceList);
		
		
		List<CompensateMissing> allMs = new ArrayList<CompensateMissing>();
		allMs.add(new CompensateMissing("", "2015-02-01 12:00:00", "2015-02-01 13:00:00", ""));
		allMs.add(new CompensateMissing("", "2015-04-01 18:00:00", "2015-04-01 19:00:00", ""));
		allMs.add(new CompensateMissing("", "2015-04-15 00:00:00", "2015-04-15 13:00:00", ""));
		allMs.add(new CompensateMissing("", "2015-07-01 12:00:00", "2015-07-01 13:00:00", ""));
		model.addAttribute("intervalList", allMs);
		return "modules/test/compensateList";
	}

//	@RequiresPermissions("test:Areadivision:view")
	@RequestMapping(value = {"form"})
	public String form(Compensate compensate, Model model) {
		System.out.println("form invoke");
		model.addAttribute("compensate", compensate);
		
		List<AreaDevice> deviceList = new ArrayList<AreaDevice>();
		List<ManagedDevice> allDv = daoMd.findList(new ManagedDevice());
		if (allDv != null && allDv.size() > 0) {
			int id = 5000;
			for (ManagedDevice m : allDv) {
				deviceList.add(new AreaDevice(String.valueOf(id++), "1", m.getNeName(), m.getNeid()));
			}
		}
		System.out.println("form invoke, deviceList is: " + deviceList);
		model.addAttribute("deviceList", deviceList);
		return "modules/test/compensateForm";
	}

//	@RequiresPermissions("test:Areadivision:edit")
	@RequestMapping(value = "compensate")
	public String compensate(Compensate compensate, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("compensate invoke: " + compensate);
		addMessage(redirectAttributes, "补采成功");
		return "redirect:" + adminPath + "/test/compensate/form";
	}
	
	@RequestMapping(value = "compensateBylist")
	public String compensateBylist(Compensate compensate, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("compensateBylist invoke: " + compensate);
		addMessage(redirectAttributes, "补采成功");
		return "redirect:" + adminPath + "/test/compensate/list";
	}
	
//	@RequiresPermissions("test:Areadivision:edit")
	@RequestMapping(value = "delete")
	public String delete(Areadivision Areadivision, RedirectAttributes redirectAttributes) {
		service.delete(Areadivision);
		daoAd.deleteByAreaCode(Areadivision.getCode());
		daoAm.deleteByAreaCode(Areadivision.getCode());
		addMessage(redirectAttributes, "删除代维人员");
		return "redirect:" + adminPath + "/test/areadivision/list?repage";
	}

	/**
	 * 验证终端名是否有效
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
//	@RequiresPermissions("test:Areadivision:edit")
	@RequestMapping(value = "checkName")
	public String checkTerminalName(String oldName, String name) {
//		if (name !=null && name.equals(oldName)) {
//			return "true";
//		} else if (name !=null && service.getTerminalByName(name) == null) {
			return "true";
//		}
//		return "false";
	}

}
