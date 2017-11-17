package com.gsccs.cmcc.sem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.cmcc.info.model.ProductT;
import com.gsccs.cmcc.info.service.ProductService;
import com.gsccs.cmcc.sem.model.Recomds;
import com.gsccs.cmcc.sem.model.SemrecomdT;
import com.gsccs.cmcc.sem.model.SemreportT;
import com.gsccs.cmcc.sem.service.RecomdService;
import com.gsccs.cmcc.sem.service.SemService;
import com.gsccs.plat.auth.model.DictItemT;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.JsonMsg;
import com.gsccs.plat.bass.QueryConstants;

/**
 * 日常上报推荐产品控制类
 * @author x.j niu
 *
 */
@Controller
@RequestMapping("/recomd")
public class RecomdController {
	
	@Autowired
	private RecomdService recomdService;
	
	@Autowired
	private SemService semService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " id  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,  SemrecomdT recomd,
			String reportid,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		SemreportT semreportT = semService.getSemreport(reportid);
		if (null==semreportT){
			return datagrid;
		}
		recomd.setCorpid(semreportT.getCorpid());
		List<SemrecomdT> resultList = recomdService.find(recomd, order, page,
				rows);
		int count = recomdService.count(recomd);
		datagrid.setRows(resultList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String showCreateForm(String id,String reportid,  ModelMap map) {
		
		//通过日常信息报送id（reportid）获取一条报送信息
		//reportid = "13bdc493-51cc-441c-85cb-42c19896db6c";
		
		SemreportT report = semService.getSemreport(reportid);
		
		map.put("report", report);
		
		//获得推荐产品的产品
		ProductT productParam = new ProductT();
		productParam.setStatus("1");
		productParam.setIsmodi("1");  //推荐的产品
		List<ProductT> productList = productService.find(productParam, "", 1,
				Integer.MAX_VALUE);
		
		map.put("pList", productList);
		map.put("psize", productList.size());
		
		//获得推荐结果值(从数据字典中查询)
		List<DictItemT> itemList = dictService.getDictItems(QueryConstants.SEM_RESULT);
		map.put("itemList", itemList);
		
		
		if (StringUtils.isNotEmpty(id)) {
			SemrecomdT recomd = recomdService.getSemrecomdT(id);
			/*ProductT pt = productService.getProduct(recomd.getProductid());
			
			map.put("pt", pt);*/
			map.put("recomd", recomd);
			return "recomd/semrecomd-edit";
		}else{
			return "recomd/semrecomd-add";
		}
	}
	
	/**
	 * 添加日常上报推荐信息
	 * @param recomd
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg create(@RequestBody Recomds recomds, Model model) {
		JsonMsg json = new JsonMsg();
		if (null != recomds && recomds.getResults().size() > 0) {
			List<SemrecomdT> sts = recomds.getResults();
			//添加时间，客户经理
			Subject subject = SecurityUtils.getSubject();
			String username = (String)subject.getPrincipal();
			User user = userService.findByAccount(username);
			recomds.setAmuserid(user.getId().toString());
			
			Date date=new Date();
			recomds.setAddtime(date);
			
			
			for (SemrecomdT st : sts) {
				st.setAddtime(recomds.getAddtime());
				st.setAmuserid(recomds.getAmuserid());
				st.setCorpid(recomds.getCorpid());
				st.setReportid(recomds.getReportid());
				recomdService.add(st);
			}
			
			//recomdService.add(recomd);
			json.setSuccess(true);
			json.setMsg("新增日常上报推荐信息成功");
		}else{
			json.setSuccess(false);
			json.setMsg("新增日常上报推荐信息失败");
		}
		
		return json;

	}

	/**
	 * 修改日常上报推荐信息
	 * @param recomd
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(SemrecomdT recomd,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		if (null != recomd) {
			
			Date date=new Date();
			recomd.setAddtime(date);
			
			recomdService.update(recomd);
			json.setSuccess(true);
			json.setMsg("更新日常上报推荐信息成功！");
		}else{
			json.setSuccess(false);
			json.setMsg("更新日常上报推荐信息失败！");
		}
		
		return json;
	}

	/**
	 * 删除走访推荐信息
	 * @param ids
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg delete(
			@RequestParam(value = "ids", required = false) String ids,
			RedirectAttributes redirectAttributes) {
		JsonMsg json = new JsonMsg();
		
		System.out.println("ids="+ids);
		if (StringUtils.isNotEmpty(ids)) {
			recomdService.del(ids);
			json.setSuccess(true);
			json.setMsg("删除走访推荐信息成功！");
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败:走访推荐信息不存在。");
		}
		return json;
	}
	
}
