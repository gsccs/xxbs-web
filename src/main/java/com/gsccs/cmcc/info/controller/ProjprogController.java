package com.gsccs.cmcc.info.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.cmcc.info.model.IctprojectT;
import com.gsccs.cmcc.info.model.ProjectprogressT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.IctProgService;
import com.gsccs.cmcc.info.service.IctService;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.JsonMsg;

/**
 * ICT项目进度管理
 * 
 * @author x.d zhang
 * 
 */

@Controller
@RequestMapping("/projprog")
public class ProjprogController {

	@Autowired
	private IctService ictService;
	@Autowired
	private DictService dictService;

	@Autowired
	private CorpService corpService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IctProgService ictprogService;
	
	/**
	 * IDC项目进度清单
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap map, HttpServletRequest request) {
		IctprojectT ict = new IctprojectT();
		List<IctprojectT> ictList = ictService.find(ict);
		map.addAttribute("ictList", ictList);
		return "projprog/projprog-list";
	}

	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " addtime  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ProjectprogressT projprog,
			String pid,
			HttpServletRequest request) {
		if(null != pid && !pid.equals("null")){
			projprog.setProjectid(pid);
		}
		
		List<ProjectprogressT> progList = ictprogService.find(projprog, order, page,
				rows);
		int count = ictprogService.count(projprog);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(progList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 项目信息进展表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(String id, String pid ,ModelMap map) {
		
		ProjectprogressT projprog = null;
		map.put("projectid", pid);
		if (StringUtils.isNotEmpty(id)) {
			projprog = ictprogService.getIctprogress(id);
			map.put("projprog", projprog);
			return "projprog/projprog-edit";
		}else{
			return "projprog/projprog-add";
		}
		
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(ProjectprogressT ictprogress,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null == ictprogress) {
			json.setSuccess(false);
			json.setMsg("项目信息进度添加失败！");
		} else {
			ictprogService.addIctprogress(ictprogress);
			json.setSuccess(true);
			json.setMsg("项目信息进度新增成功!");
		}
		return json;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(ProjectprogressT ictprogress,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null == ictprogress) {
			json.setSuccess(false);
			json.setMsg("ICT项目信息进度信息不完整或输入有误！");
		} else {
			ictprogService.updateIctprogress(ictprogress);
			json.setSuccess(true);
			json.setMsg("项目进度信息更新成功!");
		}
		return json;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(String id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(id)) {
			ictprogService.delIctprogress(id);
		}
		json.setSuccess(true);
		json.setMsg("项目进度信息删除成功！");
		return json;
	}
	
	/**
	 * 日期型数据转换，将页面上的表示日期限的字符串，转换为Date型
	 * **/
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));

	}


}
