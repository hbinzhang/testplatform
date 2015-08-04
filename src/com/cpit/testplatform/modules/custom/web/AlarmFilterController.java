/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.cpit.testplatform.modules.custom.web;

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

import com.cpit.testplatform.modules.custom.entity.RelationRule;
import com.cpit.testplatform.modules.custom.entity.SeverityRule;
import com.cpit.testplatform.modules.custom.entity.SourceRule;
import com.cpit.testplatform.modules.custom.service.FilterService;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 告警过滤规则Controller
 * 
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/custom/filter")
public class AlarmFilterController extends BaseController {

	@Autowired
	private FilterService systemService;

//	@ModelAttribute
//	public RelationRule get(@RequestParam(required=false) String name) {
//		if (StringUtils.isNotBlank(name)){
//			return systemService.getRelationRuleByName(name);
//		}else{
//			return new RelationRule();
//		}
//	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = "sourceform")
	public String sourceform(SourceRule rule, Model model) {
		model.addAttribute("rule", rule);
		return "modules/custom/sourceRuleForm";
	}
	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = { "sourcelist" })
	public String sourcelist(SourceRule rule, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<SourceRule> page = systemService.findSource(
				new Page<SourceRule>(request, response), rule);
		model.addAttribute("page", page);
		return "modules/custom/sourceRuleList";
	}

	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "sourcesave")
	public String sourcesave(SourceRule rule, HttpServletRequest request,
			Model model, RedirectAttributes redirectAttributes) {
		// 保存用户信息
		systemService.saveSource(rule);
		addMessage(redirectAttributes, "保存告警源'" + rule.getName() + "'成功");
		return "redirect:" + adminPath + "/custom/filter/sourcelist?repage";
	}

	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "sourcedelete")
	public String sourcedelete(SourceRule rule,
			RedirectAttributes redirectAttributes) {
		systemService.deleteSource(rule);
		addMessage(redirectAttributes, "删除告警源成功");
		return "redirect:" + adminPath + "/custom/filter/sourcelist?repage";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = { "severitylist" })
	public String severitylist(Model model) {
		SeverityRule rule = systemService.findSeverity();
		if (rule == null){
			rule = new SeverityRule();
		}
		model.addAttribute("rule", rule);
		return "modules/custom/severityRuleList";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = "severitysave")
	public String severitysave(SeverityRule rule,
			RedirectAttributes redirectAttributes) {
		systemService.saveSeverity(rule);
		addMessage(redirectAttributes, "保存告警级别规则成功");
		return "redirect:" + adminPath + "/custom/filter/severitylist";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = { "relationlist" })
	public String relationlist(RelationRule rule, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<RelationRule> page = systemService.findRelation(
				new Page<RelationRule>(request, response), rule);
		model.addAttribute("page", page);
		return "modules/custom/relationRuleList";
	}

	// @RequiresPermissions("test:terminal:view")
	@RequestMapping(value = "relationform")
	public String relationform(RelationRule rule, Model model) {
		model.addAttribute("rule", rule);
		return "modules/custom/relationRuleForm";
	}

	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "relationsave")
	public String relationsave(RelationRule rule, HttpServletRequest request,
			Model model, RedirectAttributes redirectAttributes) {
		// 保存用户信息
		systemService.saveRelation(rule);
		addMessage(redirectAttributes, "保存规则'" + rule.getName() + "'成功");
		return "redirect:" + adminPath + "/custom/filter/relationlist?repage";
	}

	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "relationdelete")
	public String relationdelete(RelationRule rule,
			RedirectAttributes redirectAttributes) {
		systemService.deleteRelation(rule);
		addMessage(redirectAttributes, "删除规则成功");
		return "redirect:" + adminPath + "/custom/filter/relationlist?repage";
	}

	/**
	 * 验证告警源规则名是否有效
	 * 
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "checkSourceName")
	public String checkSourceRuleName(String oldName, String name) {
		if (name != null && name.equals(oldName)) {
			return "true";
		} else if (name != null
				&& systemService.getSourceRuleByName(name) == null) {
			return "true";
		}
		return "false";
	}

	/**
	 * 验证告警关联规则名是否有效
	 * 
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
	// @RequiresPermissions("test:terminal:edit")
	@RequestMapping(value = "checkRelationName")
	public String checkRelationRuleName(String oldName, String name) {
		if (name != null && name.equals(oldName)) {
			return "true";
		} else if (name != null
				&& systemService.getRelationRuleByName(name) == null) {
			return "true";
		}
		return "false";
	}

}
