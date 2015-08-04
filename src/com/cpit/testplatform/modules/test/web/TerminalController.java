/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cpit.testplatform.modules.test.entity.Terminal;
import com.cpit.testplatform.modules.test.service.TerminalService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 终端Controller
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/test/terminal")
public class TerminalController extends BaseController {

	@Autowired
	private TerminalService systemService;
	
	@ModelAttribute
	public Terminal get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return systemService.getTerminal(id);
		}else{
			return new Terminal();
		}
	}


//	@RequiresPermissions("test:terminal:view")
	@RequestMapping(value = {"list", ""})
	public String list(Terminal terminal, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Terminal> page = systemService.findTerminal(new Page<Terminal>(request, response), terminal);
        model.addAttribute("page", page);
		return "modules/test/terminalList";
	}

//	@RequiresPermissions("test:terminal:view")
	@RequestMapping(value = "form")
	public String form(Terminal terminal, Model model) {
//		if (user.getCompany()==null || user.getCompany().getId()==null){
//			user.setCompany(UserUtils.getUser().getCompany());
//		}
//		if (user.getOffice()==null || user.getOffice().getId()==null){
//			user.setOffice(UserUtils.getUser().getOffice());
//		}
		model.addAttribute("terminal", terminal);
//		model.addAttribute("allRoles", systemService.findAllRole());
		return "modules/test/terminalForm";
	}

//	@RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "save")
	public String save(Terminal terminal, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
//		if(Global.isDemoMode()){
//			addMessage(redirectAttributes, "演示模式，不允许操作！");
//			return "redirect:" + adminPath + "/sys/user/list?repage";
//		}
//		// 修正引用赋值问题，不知道为何，Company和Office引用的一个实例地址，修改了一个，另外一个跟着修改。
//		user.setCompany(new Office(request.getParameter("company.id")));
//		user.setOffice(new Office(request.getParameter("office.id")));
//		// 如果新密码为空，则不更换密码
//		if (StringUtils.isNotBlank(user.getNewPassword())) {
//			user.setPassword(SystemService.entryptPassword(user.getNewPassword()));
//		}
//		if (!beanValidator(model, user)){
//			return form(user, model);
//		}
//		if (!"true".equals(checkLoginName(user.getOldLoginName(), user.getLoginName()))){
//			addMessage(model, "保存用户'" + user.getLoginName() + "'失败，登录名已存在");
//			return form(user, model);
//		}
//		// 角色数据有效性验证，过滤不在授权内的角色
//		List<Role> roleList = Lists.newArrayList();
//		List<String> roleIdList = user.getRoleIdList();
//		for (Role r : systemService.findAllRole()){
//			if (roleIdList.contains(r.getId())){
//				roleList.add(r);
//			}
//		}
//		user.setRoleList(roleList);
		// 保存用户信息
		systemService.saveTerminal(terminal);
		addMessage(redirectAttributes, "保存终端'" + terminal.getName() + "'成功");
		return "redirect:" + adminPath + "/test/terminal/list?repage";
	}
	
//	@RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "delete")
	public String delete(Terminal terminal, RedirectAttributes redirectAttributes) {
//		if(Global.isDemoMode()){
//			addMessage(redirectAttributes, "演示模式，不允许操作！");
//			return "redirect:" + adminPath + "/sys/user/list?repage";
//		}
//		if (UserUtils.getUser().getId().equals(user.getId())){
//			addMessage(redirectAttributes, "删除用户失败, 不允许删除当前用户");
//		}else if (User.isAdmin(user.getId())){
//			addMessage(redirectAttributes, "删除用户失败, 不允许删除超级管理员用户");
//		}else{
			systemService.deleteTerminal(terminal);
			addMessage(redirectAttributes, "删除终端成功");
//		}
		return "redirect:" + adminPath + "/test/terminal/list?repage";
	}
	
//	/**
//	 * 导出用户数据
//	 * @param terminal
//	 * @param request
//	 * @param response
//	 * @param redirectAttributes
//	 * @return
//	 */
////	@RequiresPermissions("test:terminal:view")
//    @RequestMapping(value = "export", method=RequestMethod.POST)
//    public String exportFile(Terminal terminal, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		try {
//            String fileName = "终端数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
//            Page<Terminal> page = systemService.findTerminal(new Page<Terminal>(request, response, -1), terminal);
//    		new ExportExcel("终端数据", Terminal.class).setDataList(page.getList()).write(response, fileName).dispose();
//    		return null;
//		} catch (Exception e) {
//			addMessage(redirectAttributes, "导出终端失败！失败信息："+e.getMessage());
//		}
//		return "redirect:" + adminPath + "/test/terminal/list?repage";
//    }

	/**
	 * 验证终端名是否有效
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
//	@RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "checkName")
	public String checkTerminalName(String oldName, String name) {
		if (name !=null && name.equals(oldName)) {
			return "true";
		} else if (name !=null && systemService.getTerminalByName(name) == null) {
			return "true";
		}
		return "false";
	}


//	/**
//	 * 用户信息显示及保存
//	 * @param terminal
//	 * @param model
//	 * @return
//	 */
////	@RequiresPermissions("test")
//	@RequestMapping(value = "info")
//	public String info(Terminal terminal, HttpServletResponse response, Model model) {
////		User currentUser = UserUtils.getUser();
//		if (StringUtils.isNotBlank(terminal.getName())){
////			if(Global.isDemoMode()){
////				model.addAttribute("message", "演示模式，不允许操作！");
////				return "modules/sys/userInfo";
////			}
////			currentUser.setEmail(user.getEmail());
////			currentUser.setPhone(user.getPhone());
////			currentUser.setMobile(user.getMobile());
////			currentUser.setRemarks(user.getRemarks());
////			currentUser.setPhoto(user.getPhoto());
//			systemService.saveTerminal(terminal);
//			model.addAttribute("message", "保存用户信息成功");
//		}
//		model.addAttribute("terminal", terminal);
//		model.addAttribute("Global", new Global());
//		return "modules/test/terminalInfo";
//	}

	
   
}
