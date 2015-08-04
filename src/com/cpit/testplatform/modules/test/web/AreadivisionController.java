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
@RequestMapping(value = "${adminPath}/test/areadivision")
public class AreadivisionController extends BaseController {

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
	public String list(Areadivision Areadivision, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("list invoke");
		Page<Areadivision> page = service.find(new Page<Areadivision>(request, response), Areadivision);
        model.addAttribute("page", page);
		return "modules/test/areadivisionList";
	}

//	@RequiresPermissions("test:Areadivision:view")
	@RequestMapping(value = "form")
	public String form(Areadivision Areadivision, Model model) {
		System.out.println("form invoke");
		model.addAttribute("Areadivision", Areadivision);
		List<AreaMaintainer> maintainsList = new ArrayList<AreaMaintainer>();
		List<Maintainer> allMain = daoMaint.findList(new Maintainer());
		if (allMain != null && allMain.size() > 0) {
			int id = 1000;
			for (Maintainer m : allMain) {
				maintainsList.add(new AreaMaintainer(String.valueOf(id++), "1", m.getName()));
			}
		}
		System.out.println("form invoke, maintainsList is: " + maintainsList);
		model.addAttribute("maintainsList", maintainsList);
		
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
		return "modules/test/areadivisionForm";
	}

//	@RequiresPermissions("test:Areadivision:edit")
	@RequestMapping(value = "save")
	public String save(Areadivision Areadivision, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("save invoke: " + Areadivision);
		daoAd.deleteByAreaCode(Areadivision.getCode());
		daoAm.deleteByAreaCode(Areadivision.getCode());
		System.out.println("save invoke Areadivision is: " + Areadivision);
		service.save(Areadivision);
		String am = Areadivision.getMaintainers();
		String ad = Areadivision.getDevices();
		if (am != null && am.length() > 0) {
			String[] ams = am.split(",");
			for (String a : ams) {
				AreaMaintainer mant = new AreaMaintainer();
				mant.setAreaCode(Areadivision.getCode());
				mant.setMaintainerName(a);
				mant.preInsert();
				daoAm.insert(mant);
			}
		}
		if (ad != null && ad.length() > 0) {
			String[] ads = ad.split(",");
			for (String a : ads) {
				AreaDevice dd = new AreaDevice();
				dd.setAreaCode(Areadivision.getCode());
				dd.setDeviceId("get from device table");
				dd.setDeviceName(a);
				dd.preInsert();
				daoAd.insert(dd);
			}
		}
		addMessage(redirectAttributes, "保存区域划分'" + Areadivision.getName() + "'成功");
		return "redirect:" + adminPath + "/test/areadivision/list?repage";
	}
	
//	@RequiresPermissions("test:Areadivision:edit")
	@RequestMapping(value = "delete")
	public String delete(Areadivision Areadivision, RedirectAttributes redirectAttributes) {
		service.delete(Areadivision);
		daoAd.deleteByAreaCode(Areadivision.getCode());
		daoAm.deleteByAreaCode(Areadivision.getCode());
		addMessage(redirectAttributes, "删除区域划分");
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
