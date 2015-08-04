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

import com.cpit.testplatform.modules.test.dao.MaintainerDao;
import com.cpit.testplatform.modules.test.entity.Maintainer;
import com.cpit.testplatform.modules.test.entity.Manager;
import com.cpit.testplatform.modules.test.service.MaintainerService;
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
@RequestMapping(value = "${adminPath}/test/maintainer")
public class MaintainerController extends BaseController {

	@Autowired
	private MaintainerService service;
	@Autowired
	private SystemService systemService;
	@Autowired
	private MaintainerDao dao;
	@ModelAttribute
	public Maintainer get(@RequestParam(required=false) String id) {
		System.out.println("MaintainerController get invoke id: " + id);
		if (StringUtils.isNotBlank(id)){
			Maintainer m = service.get(id);
			if (m == null) {
				new Maintainer();
			}
			return m;
		}else{
			return new Maintainer();
		}
	}


//	@RequiresPermissions("test:maintainer:view")
	@RequestMapping(value = {"list", ""})
	public String list(Maintainer maintainer, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("list invoke");
		Page<Maintainer> page = service.find(new Page<Maintainer>(request, response), maintainer);
        model.addAttribute("page", page);
		return "modules/test/maintainerList";
	}

//	@RequiresPermissions("test:maintainer:view")
	@RequestMapping(value = "form")
	public String form(Maintainer maintainer, Model model) {
		System.out.println("form invoke");
		model.addAttribute("maintainer", maintainer);
		return "modules/test/maintainerForm";
	}
	
	@RequestMapping(value = "modPass/{loginName}")
	public String modPass(Manager maintainer, Model model, @PathVariable String loginName) {
		System.out.println("modPass invoke: " + loginName);
		maintainer.setLoginName(loginName);
		model.addAttribute("maintainer", maintainer);
		return "modules/test/maintainerModPass";
	}

	@RequestMapping(value = "changePassWord")
	public String changePassWord(Manager maintainer, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("changePassWord invoke: " + maintainer);
		model.addAttribute("maintainer", maintainer);
		User u = systemService.getUserByLoginName(maintainer.getLoginName());
		if (u != null) {
			System.out.println("changePassWord user " + u.getId());
			systemService.updatePasswordById(u.getId(), maintainer.getLoginName(), maintainer.getPassword());
		}
		addMessage(redirectAttributes, "修改密码" + "成功");
		return "redirect:" + adminPath + "/test/manager/list?repage";
	}
//	@RequiresPermissions("test:maintainer:edit")
	@RequestMapping(value = "save")
	public String save(Maintainer maintainer, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("save invoke: " + maintainer);
		service.save(maintainer);
		User user = new User();
		user.setLoginName(maintainer.getLoginName());
		user.setPassword(SystemService.entryptPassword(maintainer.getPassword()));
		List<String> roleIdList = new ArrayList<String>();
		roleIdList.add("2");
		user.setRoleIdList(roleIdList);
		user.setRole(systemService.getRole("2"));
		user.setCompany(new Office("1"));
		user.setOffice(new Office("1"));
		user.setName(maintainer.getLoginName());
		user.setCreateBy(new User("999"));
		user.setCreateDate(new Date());
		user.setUpdateBy(new User("999"));
		user.setUpdateDate(new Date());
		user.setDelFlag("0");
		systemService.saveUser(user);
		addMessage(redirectAttributes, "保存代维人员'" + maintainer.getName() + "'成功");
		
//		for (int i = 10; i < 100; i++) {
//			String a = String.valueOf(i);
//			Maintainer v = new Maintainer(a,a,a,a,a,a);
//			dao.addOne(v);
//			System.out.println("save extra user:" + a);
//		}
		return "redirect:" + adminPath + "/test/maintainer/list?repage";
	}
	
//	@RequiresPermissions("test:maintainer:edit")
	@RequestMapping(value = "delete")
	public String delete(Maintainer maintainer, RedirectAttributes redirectAttributes) {
		service.delete(maintainer);
		User u = systemService.getUserByLoginName(maintainer.getLoginName());
		if (u != null) {
			System.out.println("del sts user " + u.getId());
			systemService.deleteUser(u);
		}
		addMessage(redirectAttributes, "删除代维人员");
		return "redirect:" + adminPath + "/test/maintainer/list?repage";
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
