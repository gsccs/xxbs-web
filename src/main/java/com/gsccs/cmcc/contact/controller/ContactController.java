package com.gsccs.cmcc.contact.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.cmcc.contact.model.ContactT;
import com.gsccs.cmcc.contact.service.ContactService;
import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.SpeclineService;
import com.gsccs.plat.auth.model.AreaT;
import com.gsccs.plat.auth.model.DictItemT;
import com.gsccs.plat.auth.service.AreaService;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.JsonMsg;
import com.gsccs.plat.bass.QueryConstants;

/**
 * 通讯录
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private CorpService corpService;
	
	@Autowired
	private SpeclineService speclineService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private AreaService areaService;

	/**
	 * 通讯录列表
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap map, HttpServletRequest request) {
		
		return "contacts/contact-list";
	}

	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " id  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ContactT contact,
			HttpServletRequest request) {
		List<ContactT> contactList = contactService.find(contact, order, page, rows);
		int count = contactService.count(contact);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(contactList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 通讯录信息表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(String id,Model model) {
		if(id != null && !id.equals("")){
			ContactT ct = contactService.getContact(id);
			if(null != ct && ct.getAreacode() !=null && !ct.getAreacode().equals("")){
				AreaT at = areaService.findById(ct.getAreacode());
				if(null != at && !at.getName().equals("")){
					ct.setAreaname(at.getName());
				}
			}
			model.addAttribute("contacts",ct );
			return "contacts/contact-edit";
		}else{
			return "contacts/contact-add";
		}
		
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(ContactT contact,HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		if (null != contact) {
			contactService.addContact(contact);
			json.setSuccess(true);
			json.setMsg("通讯录新增成功!");
		}else{
			json.setSuccess(false);
			json.setMsg("通讯录新增失败!");
		}
		return json;
	}

	/**
	 * 通讯录修改
	 * @param contact
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(ContactT contact,
			HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		if (null != contact) {
			contactService.updateContact(contact);
		}
		json.setSuccess(true);
		json.setMsg("更新通讯录成功！");
		return json;
	}

	/**
	 * 通讯录删除
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(String id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(id)) {
			contactService.delContact(id);
		}
		json.setSuccess(true);
		json.setMsg("通讯录删除成功！");
		return json;
	}

	
	
	/**
	 * 更新企业数据
	 * 
	 * @param param
	 * @param page
	 * @param rows
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/savePoints", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg savePoints(String corpid, Double lng, Double lat,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (StringUtils.isNotEmpty(corpid) && null != lng && null != lat) {
			CorpT corp = corpService.getCorp(corpid);
			corpService.updateCorp(corp);
			json.setSuccess(true);
			json.setMsg("企业地理数据更新成功！");
		} else {
			json.setSuccess(false);
			json.setMsg("保存失败，企业地理数据有误！");
		}
		return json;
	}
}
