package com.gsccs.cmcc.info.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
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

import com.gsccs.cmcc.data.model.Specline;
import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.Specattachs;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.SpeclineService;
import com.gsccs.plat.auth.model.DictGroupT;
import com.gsccs.plat.auth.model.DictItemT;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.auth.service.RoleService;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Constants;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.JsonMsg;
import com.gsccs.plat.bass.QueryConstants;

/**
 * 专线控制类
 * 
 * @author x.d zhang
 * 
 */

@Controller
@RequestMapping("/specline")
public class SpeclineController {

	@Autowired
	private SpeclineService speclineService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private DictService dictService;
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap map, HttpServletRequest request) {
		//获得运营商和专线类型
		List<DictItemT> ispList = dictService.getDictItems(QueryConstants.ISP_TYPE);
		map.addAttribute("ispList", ispList);
		List<DictItemT> lineList = dictService.getDictItems(QueryConstants.SPECLINE_TYPE);
		map.addAttribute("lineList", lineList);
		return "specline/specline-list";
	}

	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(Long id, ModelMap map) {
		Specline speclineT = null;
		CorpT ct = new CorpT();
		
		List<CorpT> ctList = corpService.find(ct);
		map.addAttribute("ctList", ctList);
		//获得运营商和专线类型,缴费方式
		List<DictItemT> ispList = dictService.getDictItems(QueryConstants.ISP_TYPE);
		if(null != ispList && ispList.size() > 0){
			map.addAttribute("ispList", ispList);
		}
		
		List<DictItemT> lineList = dictService.getDictItems(QueryConstants.SPECLINE_TYPE);
		if(null != lineList && lineList.size() > 0){
			map.addAttribute("lineList", lineList);
		}
		
		
		List<DictItemT> payList = dictService.getDictItems(QueryConstants.PAY_TYPE);
		if(null != payList && payList.size() > 0){
			map.addAttribute("payList", payList);
		}
		List<User> userList = userService.findByRoleCode(Constants.ROLE_YY_AM);
		map.addAttribute("userList", userList);
		if (null != id) {
			speclineT = speclineService.getSpecline(id);
			List<Specattachs> specattc = speclineService.find(id);
			String filenames ="";
			if(null !=specattc && specattc.size() > 0){
				for (Specattachs sp : specattc) {
					filenames += sp.getTitle() + ";";
				}
			}
			speclineT.setFilenames(filenames);
			map.addAttribute("specline", speclineT);
			CorpT corpt = corpService.getCorp(speclineT.getIspcode());
			map.addAttribute("corpt", corpt);
			
			return "specline/specline-edit";
		}else{
			return "specline/specline-add";
		}
	}
	
	

	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(Specline param ,ModelMap map,
			@RequestParam(defaultValue = " id  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, 
			HttpServletRequest request) {
		List<Specline> list = speclineService.find(param, order, page, rows);
		int count = speclineService.count(param);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(Specline specline,RedirectAttributes redirectAttributes
			) {
			JsonMsg json = new JsonMsg();
			if (null != specline) {
			/*boolean  isExist = speclineService.isExist(specline.getIspcode());
			//ispcode存在
			if(isExist){
				json.setSuccess(false);
				json.setMsg("客户专线信息已经存在,不能重复添加,请重新选择企业!");
			}else{*/
				speclineService.addSpecline(specline);
				//添加扫描协议
				speclineService.addSpecAttach(specline);
				json.setSuccess(true);
				json.setMsg("专线信息保存成功！");
			//}
			
		}else{
			json.setSuccess(false);
			json.setMsg("专线信息保存失败！");
		}
		return json;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(Specline specline,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null != specline) {
			speclineService.updateSpecline(specline);
			json.setSuccess(true);
			json.setMsg("专线信息更新成功！");
		}else{
			json.setSuccess(false);
			json.setMsg("专线信息更新失败！");
		}
		
		return json;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(Long id, RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null != id) {
			speclineService.delSpecline(id);
		}
		json.setSuccess(true);
		json.setMsg("专线信息删除成功！");
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
