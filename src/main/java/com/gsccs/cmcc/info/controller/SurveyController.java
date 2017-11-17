package com.gsccs.cmcc.info.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.ProductT;
import com.gsccs.cmcc.info.model.PropT;
import com.gsccs.cmcc.info.model.PropvalT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.ProductService;
import com.gsccs.cmcc.info.service.PropService;
import com.gsccs.cmcc.info.service.SurveyService;
import com.gsccs.plat.auth.model.DictItemT;
import com.gsccs.plat.auth.service.AreaService;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.DatagridColumn;
import com.gsccs.plat.bass.PropgridRow;
import com.gsccs.plat.bass.TreeGrid;

/**
 * 信息化摸底管理
 * 
 * @author x.d zhang
 * 
 */

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private ProductService productService;
	@Autowired
	private PropService propService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private DictService dictService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(method = RequestMethod.GET)
	public String surveyList(HttpServletRequest request) {
		return "survey/survey-datagrid";
	}

	/**
	 * 摸底汇总表表头
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/treegridhead", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray treegridhead(HttpServletRequest request) {
		return surveyService.getTreeGridHeader();
	}
	
	/**
	 * 摸底汇总表表头
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/datagridhead", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray datagridhead(HttpServletRequest request) {
		return surveyService.getDataGridHeader();
	}
	
	
	/**
	 * 摸底汇总表
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/treegrid", method = RequestMethod.POST)
	@ResponseBody
	public TreeGrid surveyList(CorpT param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			HttpServletRequest request) {
		
		return surveyService.findCorpTree(param,page,rows);
	}

	
	/**
	 * 摸底汇总表
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid datagrid(CorpT param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "30") int rows,
			HttpServletRequest request) {
		return surveyService.findCorpDgList(param, page, rows);
	}

	/**
	 * 摸底情况按产品统计分析
	 * 
	 * @param productid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/statistByProduct", method = RequestMethod.GET)
	public String statisByProduct(String productid, Model model) {
		if (StringUtils.isEmpty(productid)) {
			List<ProductT> productList = productService.find(null, "", 1,
					Integer.MAX_VALUE);
			model.addAttribute("productList", productList);
		}
		return "survey/survey-list";
	}

	@RequestMapping(value = "/statistByProduct", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid statisByProduct(PropT propParam, HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		try {
			List<DatagridColumn> propcollist = new ArrayList<DatagridColumn>();
			JSONArray columns = new JSONArray();
			List<PropT> propList = propService.find(propParam, "indexnum", 1,
					Integer.MAX_VALUE);
			if (null != propList && propList.size() > 0) {
				// 遍历所有属性
				for (PropT propT : propList) {
					DatagridColumn propdc = new DatagridColumn();
					// 获取属性的名字
					propdc.setField(propT.getPropcode());
					propdc.setTitle(propT.getTitle());
					// propdc.setWidth(80);
					propcollist.add(propdc);
				}
			}
			columns.add(propcollist);
			datagrid.setColumns(columns);

			List<CorpT> corplist = corpService.find(null, "", 1,
					Integer.MAX_VALUE);
			if (null != corplist && corplist.size() > 0) {
				JSONArray rowarray = new JSONArray();
				for (CorpT corpT : corplist) {
					List<PropvalT> propvalList = propService.findCorpProp(corpT.getIspcode(),propParam.getProductid());
					// System.out.println("propvalList:" + propvalList.size());
					if (null != propvalList && propvalList.size() > 0) {
						JSONObject json = new JSONObject();
						for (PropvalT propval : propvalList) {
							json.put(propval.getPropcode(),
									propval.getPropval());
						}
						rowarray.add(json);
					}
				}
				datagrid.setRows(rowarray);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(JSON.toJSONString(datagrid));
		return datagrid;
	}

	/**
	 * 增加摸底数据
	 * 
	 * @param corpid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String addData(String corpid, Model model) {
		if (StringUtils.isEmpty(corpid)) {
			CorpT corpT = corpService.getCorp(corpid);
		}
		return "survey/survey-form";
	}

	
	@RequestMapping(value = "/getPropval", method = RequestMethod.GET)
	@ResponseBody
	public Datagrid getPropval(String corpid, String productid) {
		Datagrid datagrid = new Datagrid();
		List<PropgridRow> rows = new ArrayList<>();
		// 业务数据表头
		List<PropvalT> propvalList = propService.findCorpProp(corpid,productid);
		if (null != propvalList && propvalList.size() > 0) {
			// 遍历所有属性t
			for (PropvalT propT : propvalList) {
				PropgridRow propdc = new PropgridRow();
				// 获取属性的名字
				propdc.setName(propT.getProptitle());
				propdc.setValue(propT.getPropval());
				propdc.setGroup(productid);
				propdc.setCorpid(propT.getCorpid());
				propdc.setProductid(propT.getProductid());
				propdc.setPropid(propT.getPropid());
				if (propT.getShowtype().equals("combobox")) {
					JSONObject editor = new JSONObject();
					
					List<DictItemT> dictItemTs = dictService.getDictItems(propT.getDictcode());
					if (null != dictItemTs && dictItemTs.size() > 0) {
						JSONArray optiondata = new JSONArray();
						for (DictItemT dictItemT : dictItemTs) {
							JSONObject dict = new JSONObject();
							dict.put("value", dictItemT.getId());
							dict.put("text", dictItemT.getTitle());
							optiondata.add(dict);
						}
						JSONObject options = new JSONObject();
						options.put("data", optiondata);
						editor.put("type", "combobox");
						editor.put("options", options);
					}
					propdc.setEditor(editor);
				} else {
					propdc.setEditor(propT.getShowtype());
				}
				rows.add(propdc);
			}
		}
		datagrid.setTotal(Long.valueOf(rows.size()));
		datagrid.setRows(rows);
		return datagrid;
	}

	
	@RequestMapping(value = "/getCorpData", method = RequestMethod.GET)
	@ResponseBody
	public Datagrid getPropval(String corpid, String producid,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<PropgridRow> rows = new ArrayList<>();
		// 业务数据表头
		ProductT productParam = new ProductT();
		productParam.setIsmodi("1");
		productParam.setStatus("1");
		List<ProductT> productList = productService.find(productParam, "", 1,
				Integer.MAX_VALUE);
		if (null != productList && productList.size() > 0) {
			for (ProductT productT : productList) {
				PropT propParam = new PropT();
				propParam.setProductid(productT.getId());
				List<PropT> propList = propService.find(propParam, "indexnum",
						1, Integer.MAX_VALUE);
				if (null != propList && propList.size() > 0) {
					// 遍历所有属性t
					for (PropT propT : propList) {
						PropgridRow propdc = new PropgridRow();
						// 获取属性的名字
						propdc.setName(propT.getTitle());
						propdc.setValue("");
						propdc.setGroup(productT.getTitle());

						if (propT.getShowtype().equals("select")) {
							JSONObject editor = new JSONObject();
							List<DictItemT> dictItemTs = dictService
									.getDictItems("ISP_TYPE");
							if (null != dictItemTs && dictItemTs.size() > 0) {
								JSONArray optiondata = new JSONArray();
								for (DictItemT dictItemT : dictItemTs) {
									JSONObject dict = new JSONObject();
									dict.put("value", dictItemT.getId());
									dict.put("text", dictItemT.getTitle());
									optiondata.add(dict);
								}
								JSONObject options = new JSONObject();
								options.put("data", optiondata);
								editor.put("type", "combobox");
								editor.put("options", options);
							}
							propdc.setEditor(editor);
						} else {
							propdc.setEditor(propT.getShowtype());
						}
						rows.add(propdc);
					}
				}
			}
		}
		datagrid.setRows(rows);
		return datagrid;
	}

	public static void main(String[] args) {
		Datagrid datagrid = new Datagrid();

		List<DatagridColumn> productlist = new ArrayList<DatagridColumn>();
		List<DatagridColumn> propList = new ArrayList<DatagridColumn>();
		JSONArray columns = new JSONArray();
		for (int j = 1; j <= 7; j++) {
			DatagridColumn pcol = new DatagridColumn();
			pcol.setTitle("产品" + j);
			for (int i = 1; i < 5; i++) {
				DatagridColumn propcol = new DatagridColumn();
				propcol.setTitle("属性" + i);
				propcol.setField("feild" + i);
				propList.add(propcol);
			}
			pcol.setRowspan(propList.size());
			productlist.add(pcol);

		}
		columns.add(productlist);
		columns.add(propList);
		datagrid.setColumns(columns);
		System.out.println(JSON.toJSONString(datagrid));

	}

}
