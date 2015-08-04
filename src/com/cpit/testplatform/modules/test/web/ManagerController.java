/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.test.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cpit.testplatform.modules.test.entity.Manager;
import com.cpit.testplatform.modules.test.service.ManagerService;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;

/**
 * @author zhb
 */
@Controller
@RequestMapping(value = "${adminPath}/test/manager")
public class ManagerController extends BaseController {

	@Autowired
	private ManagerService service;
	@Autowired
	private SystemService systemService;
	
	@ModelAttribute
	public Manager get(@RequestParam(required=false) String id) {
		System.out.println("managerrController get invoke id: " + id);
		if (StringUtils.isNotBlank(id)){
			Manager m = service.get(id);
			if (m == null) {
				new Manager();
			}
			return m;
		}else{
			return new Manager();
		}
	}


//	@RequiresPermissions("test:maintainer:view")
	@RequestMapping(value = {"list", ""})
	public String list(Manager manager, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("list invoke");
		Page<Manager> page = service.find(new Page<Manager>(request, response), manager);
        model.addAttribute("page", page);
		return "modules/test/managerList";
	}

//	@RequiresPermissions("test:maintainer:view")
	@RequestMapping(value = "form")
	public String form(Manager manager, Model model) {
		System.out.println("form invoke");
		model.addAttribute("manager", manager);
		return "modules/test/managerForm";
	}

	@RequestMapping(value = "modPass/{managerLoginName}")
	public String modPass(Manager manager, Model model, @PathVariable String managerLoginName) {
		System.out.println("modPass invoke: " + managerLoginName);
		manager.setLoginName(managerLoginName);
		model.addAttribute("manager", manager);
		return "modules/test/managerModPass";
	}
	
	@RequestMapping(value = "changePassWord")
	public String changePassWord(Manager manager, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("changePassWord invoke: " + manager);
		model.addAttribute("manager", manager);
		User u = systemService.getUserByLoginName(manager.getLoginName());
		if (u != null) {
			System.out.println("changePassWord user " + u.getId());
			systemService.updatePasswordById(u.getId(), manager.getLoginName(), manager.getPassword());
		}
		addMessage(redirectAttributes, "修改密码" + "成功");
		return "redirect:" + adminPath + "/test/manager/list?repage";
	}
	
//	@RequiresPermissions("test:maintainer:edit")
	@RequestMapping(value = "save")
	public String save(Manager manager, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("save invoke: " + manager);
		service.save(manager);
		addMessage(redirectAttributes, "保存管理员人员'" + manager.getName() + "'成功");
		User user = new User();
		user.setLoginName(manager.getLoginName());
		user.setPassword(SystemService.entryptPassword(manager.getPassword()));
		List<String> roleIdList = new ArrayList<String>();
		roleIdList.add("1");
		user.setRoleIdList(roleIdList);
		user.setRole(systemService.getRole("1"));
		user.setCompany(new Office("1"));
		user.setOffice(new Office("1"));
		user.setName(manager.getLoginName());
		user.setCreateBy(new User("999"));
		user.setCreateDate(new Date());
		user.setUpdateBy(new User("999"));
		user.setUpdateDate(new Date());
		user.setDelFlag("0");
		systemService.saveUser(user);
		System.out.println("save user ok");
		return "redirect:" + adminPath + "/test/manager/list?repage";
	}
	
//	@RequiresPermissions("test:maintainer:edit")
	@RequestMapping(value = "delete")
	public String delete(Manager manager, RedirectAttributes redirectAttributes) {
		service.delete(manager);
		addMessage(redirectAttributes, "删除管理员员");
		User u = systemService.getUserByLoginName(manager.getLoginName());
		if (u != null) {
			System.out.println("del sts user " + u.getId());
			systemService.deleteUser(u);
		}
		return "redirect:" + adminPath + "/test/manager/list?repage";
	}

	/**
	 * 验证终端名是否有效
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
//	@RequiresPermissions("test:maintainer:edit")
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
