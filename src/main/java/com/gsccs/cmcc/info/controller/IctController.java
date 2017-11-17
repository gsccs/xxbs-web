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

import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.IctprojectT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.IctProgService;
import com.gsccs.cmcc.info.service.IctService;
import com.gsccs.plat.auth.model.DictItemT;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Constants;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.JsonMsg;
import com.gsccs.plat.bass.QueryConstants;

/**
 * ICT项目管理
 * 
 * @author x.d zhang
 * 
 */

@Controller
@RequestMapping("/ictproj")
public class IctController {

	@Autowired
	private IctService ictService;
	@Autowired
	private IctProgService ictprogService;
	@Autowired
	private DictService dictService;

	@Autowired
	private CorpService corpService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * IDC项目清单
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap map, HttpServletRequest request) {
		List<DictItemT> isptypes = dictService.getDictItems("ISP_TYPE");
		map.addAttribute("isptypes", isptypes);
		return "ictproj/ictproj-list";
	}

	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " ordernum  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, IctprojectT projInfo,
			HttpServletRequest request) {
		List<IctprojectT> projList = ictService.find(projInfo, order, page,
				rows);
		int count = ictService.count(projInfo);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(projList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 项目信息表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(String id, ModelMap map) {
		IctprojectT ictprojectT = null;
		List<DictItemT> isptypes = dictService.getDictItems("ISP_TYPE");
		map.put("isptypes", isptypes);
		
		//获取企业信息
		CorpT ct = new CorpT();
		List<CorpT> ctList = corpService.find(ct);
		map.addAttribute("ctList", ctList);
		
		//ict项目状态
		List<DictItemT> statusList = dictService.getDictItems(QueryConstants.ICT_STASTUS);
		map.put("statusList", statusList);
		
		//获得客户经理
		List<User> userList = userService.findByRoleCode(Constants.ROLE_YY_AM);
		map.addAttribute("userList", userList);
		
		if (StringUtils.isNotEmpty(id)) {
			ictprojectT = ictService.getIctproject(id);
			map.put("ictproj", ictprojectT);
			return "ictproj/ictproj-edit";
		}else{
			return "ictproj/ictproj-add";
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(IctprojectT ictproject,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null == ictproject) {
			json.setSuccess(false);
			json.setMsg("ICT项目信息新增失败,信息不完整或输入有误！");
		} else {
			ictService.addIctproject(ictproject);
			json.setSuccess(true);
			json.setMsg("项目信息新增成功!");
		}
		return json;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(IctprojectT ictproject,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null == ictproject) {
			json.setSuccess(false);
			json.setMsg("ICT项目信息更新失败,信息不完整或输入有误！");
		} else {
			ictService.updateIctproject(ictproject);
			json.setSuccess(true);
			json.setMsg("项目信息更新成功!");
		}
		return json;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(String id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(id)) {
			ictService.delIctproject(id);
		}
		json.setSuccess(true);
		json.setMsg("项目信息删除成功！");
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
