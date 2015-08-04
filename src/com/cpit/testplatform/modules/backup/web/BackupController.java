/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.backup.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cpit.testplatform.modules.backup.entity.BackupHistory;
import com.cpit.testplatform.modules.backup.entity.BackupPlan;
import com.cpit.testplatform.modules.backup.service.BackupService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 数据备份Controller
 * 
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/backup")
public class BackupController extends BaseController {

	@Autowired
	private BackupService systemService;

	@ModelAttribute("plan")
	public BackupPlan getPlan(@RequestParam(required = false) Integer id) {
		return new BackupPlan();
	}

	@ModelAttribute("his")
	public BackupHistory getHistory(@RequestParam(required = false) Integer id) {
		if (id != null){
			return systemService.getBackupHistory(id);
		}else{
			return new BackupHistory();
		}
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = "planform")
	public String planform(BackupPlan plan, Model model) {
		model.addAttribute("plan", plan);
		return "modules/backup/planForm";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = { "planlist" })
	public String planlist(Model model) {
		List<BackupPlan> page = systemService.findPlan();
		model.addAttribute("page", page);
		return "modules/backup/planList";
	}

	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "plansave")
	public String plansave(BackupPlan plan, HttpServletRequest request,
			Model model, RedirectAttributes redirectAttributes) {
		// 保存用户信息
		systemService.savePlan(plan);
		addMessage(redirectAttributes, "保存自动备份策略成功");
		return "redirect:" + adminPath + "/backup/planlist?repage";
	}

	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "sourcedelete")
	public String plandelete(BackupPlan plan,
			RedirectAttributes redirectAttributes) {
		systemService.deletePan(plan);
		addMessage(redirectAttributes, "删除自动备份策略成功");
		return "redirect:" + adminPath + "/backup/planlist?repage";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = { "historylist" })
	public String historylist(BackupHistory history,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<BackupHistory> page = systemService.findHistory(
				new Page<BackupHistory>(request, response), history);
		model.addAttribute("page", page);
		return "modules/backup/historyList";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = "historydelete")
	public String historydelete(BackupHistory history,
			RedirectAttributes redirectAttributes) {
		systemService.deleteHistory(history);
		addMessage(redirectAttributes, "删除告警级别规则成功");
		return "redirect:" + adminPath + "/backup/historylist";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = { "historyform" })
	public String historyform(BackupHistory history, Model model) {
		BackupHistory detail = systemService.getBackupHistory(history.getId());
		model.addAttribute("his", detail);
		return "modules/backup/historyForm";
	}

}
