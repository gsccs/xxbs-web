package com.gsccs.cmcc.sem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.ProductT;
import com.gsccs.cmcc.info.model.PropT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.ProductService;
import com.gsccs.cmcc.info.service.PropService;
import com.gsccs.cmcc.sem.model.SemreportT;
import com.gsccs.cmcc.sem.model.SemresultT;
import com.gsccs.cmcc.sem.service.SemService;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Constants;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.DatagridColumn;
import com.gsccs.plat.bass.DatagridColumn.Align;
import com.gsccs.plat.bass.JsonMsg;

/**
 * 日常上报管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private SemService semService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PropService propService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String list(String id, ModelMap map) {
		List<User> userList = userService.findByRoleCode(Constants.ROLE_YY_AM);
		map.addAttribute("userList", userList);
		return "report/semreport-list";
	}

	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String showCreateForm(String id, ModelMap map) {
		// 获得营销的产品
		ProductT productParam = new ProductT();
		productParam.setStatus("1");
		productParam.setIssem("1"); // 参与营销产品
		List<ProductT> productList = productService.find(productParam, "", 1,
				Integer.MAX_VALUE);

		map.put("pList", productList);
		map.put("psize", productList.size());

		if (StringUtils.isNotEmpty(id)) {
			SemreportT report = semService.getSemreport(id);
			map.put("report", report);
			return "report/semreport-edit";
		} else {
			return "report/semreport-add";
		}

	}

	@RequestMapping(value = "/item/dghead")
	@ResponseBody
	public JSONArray list(ModelMap map, HttpServletRequest request) {
		return semService.getGridHead();
	}

	@RequestMapping(value = "/item/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " addtime desc  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, 
			SemreportT param,
			HttpServletRequest request) {
		return semService.findGridData(param,page,rows);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(@RequestBody SemreportT semreport, Model model) {

		JsonMsg json = new JsonMsg();
		if (null == semreport) {
			json.setSuccess(false);
			json.setMsg("数据更新失败,上报内容不存在或有误！");
			return json;
		}
		try {
			Subject subject = SecurityUtils.getSubject();
			String username = (String) subject.getPrincipal();
			User user = userService.findByAccount(username);

			semreport.setAmuserid(user.getId().toString());

			semreport.setAddtime(new Date());

			String dateStr = semreport.getAdddateStr();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
			Date d = sdf.parse(dateStr);
			semreport.setAdddate(d);
			
			String rid = semService.addSemreport(semreport);
			this.savaresult(semreport);
			json.setSuccess(true);
			json.setMsg("数据更新成功！");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("数据更新失败,未知错误！");
		}
		return json;
	}

	public void savaresult(SemreportT report) {
		List<SemresultT> results = report.getResults();
		for (SemresultT st : results) {
			st.setAmuserid(report.getAmuserid());
			st.setCorpid(report.getCorpid());
			st.setReportid(report.getId());
			semService.addSemresult(st);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(SemreportT semreport, Model model) {
		JsonMsg json = new JsonMsg();
		if (null == semreport) {
			json.setSuccess(false);
			json.setMsg("数据更新失败,上报内容不存在或有误！");
			return json;
		}
		try {
			semService.updateSemreport(semreport);
			json.setSuccess(true);
			json.setMsg("数据更新成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("数据更新失败,未知错误！");
		}
		return json;
	}

	/**
	 * 
	 * @param ids
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(
			@RequestParam(value = "id", required = false) String id,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(id)) {
			semService.delSemreport(id);
			json.setSuccess(true);
			json.setMsg("删除成功！");
			return json;
		}
		json.setSuccess(false);
		json.setMsg("删除失败！");
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
