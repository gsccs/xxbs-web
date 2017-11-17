package com.gsccs.cmcc.info.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.SpeclineService;
import com.gsccs.cmcc.info.service.UsercorpService;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Constants;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.JsonMsg;

/**
 * 企业信息
 * 
 * @author x.d zhang
 * 
 */

@Controller
@RequestMapping("/corp")
public class CorpController {

	@Autowired
	private CorpService corpService;
	@Autowired
	private SpeclineService speclineService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UsercorpService ucorpService;

	/**
	 * 客户信息列表
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap map, HttpServletRequest request) {
		List<User> userList = userService.findByRoleCode(Constants.ROLE_YY_AM);
		map.addAttribute("userList", userList);
		return "corp/corp-list";
	}

	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " ispcode  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, CorpT corp,
			HttpServletRequest request) {
		List<CorpT> corpList = null;
		
		Subject subject = SecurityUtils.getSubject();
		String username = (String)subject.getPrincipal();
		User user = userService.findByAccount(username);
		int count = 0;
		if(subject.hasRole(Constants.ROLE_ADMIN) || subject.hasRole(Constants.ROLE_YY_QA)){
			corpList = corpService.find(corp, order, page, rows);
			count = corpService.count(corp);
		}else if(subject.hasRole(Constants.ROLE_YY_QA_P)){
			System.out.println("市级业务主管");
			//市级业务主管
			corp.setAcode(user.getAreaid());
			corpList = corpService.find(corp, order, page, rows);
			count = corpService.count(corp);
		}else if(subject.hasRole(Constants.ROLE_YY_QA_A)){
			System.out.println("县级业务主管");
			//县级业务主管
			corp.setAcode(user.getAreaid());
			corpList = corpService.find(corp, order, page, rows);
			count = corpService.count(corp);
		}else if(subject.hasRole(Constants.ROLE_YY_AM)){
			corp.setAmuserid(user.getId());
			corpList = corpService.find(corp, order, page, rows);
			count = corpService.count(corp);
		}else{
			corp.setAmuserid(user.getId());
			corpList = corpService.find(corp, order, page, rows);
			count = corpService.count(corp);
		}
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(corpList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 企业信息表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(String id, ModelMap map) {
		List<User> userList = userService.findByRoleCode(Constants.ROLE_YY_AM);
		map.addAttribute("userList", userList);
		if (StringUtils.isNotEmpty(id)) {
			CorpT corp = corpService.getCorp(id);
			map.put("corp", corp);
			return "corp/corp-edit";
		}else{
			return "corp/corp-add";
		}
		
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(CorpT corp,HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		if (null != corp) {
			//如果没有userid.则set当前登录用户
			if(null == corp.getAmuserid()){
				Subject subject = SecurityUtils.getSubject();
				String username = (String)subject.getPrincipal();
				User user = userService.findByAccount(username);
				corp.setAmuserid(user.getId());
			}
			Subject subject = SecurityUtils.getSubject();
			String username = (String)subject.getPrincipal();
			User user = userService.findByAccount(username);
			
			if(null != corp.getIspcode() && !corp.getIspcode().equals("")){
				CorpT c = corpService.getCorp(corp.getIspcode());
				//判断集团编码是否重复
				if(c !=null){
					json.setSuccess(false);
					json.setMsg("集团编码重复,重新填写集团编码!");
				}else{     
					if(corp.getAmuserid()==null){
						corp.setAmuserid(user.getId());
					}
					corpService.addCorp(corp);
					json.setSuccess(true);
					json.setMsg("企业信息新增成功!");
				}
			}else{
				corpService.addCorp(corp);
				json.setSuccess(true);
				json.setMsg("企业信息新增成功!");
			}
			
		}else{
			json.setSuccess(false);
			json.setMsg("企业信息新增失败!");
		}
		
		return json;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(CorpT corp,
			HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		if (null != corp) {
			corpService.updateCorp(corp);
		}
		json.setSuccess(true);
		json.setMsg("更新企业信息成功！");
		return json;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(String id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(id)) {
			corpService.delCorp(id);
			json.setSuccess(true);
			json.setMsg("企业信息删除成功！");
		}else{
			json.setSuccess(false);
			json.setMsg("企业信息删除失败！");
		}
		
		return json;
	}

	
}
