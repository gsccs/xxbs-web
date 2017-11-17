package com.gsccs.cmcc.sem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.cmcc.sem.model.SemresultT;
import com.gsccs.cmcc.sem.service.SemService;
import com.gsccs.plat.bass.Datagrid;

/**
 * 日常上报结果控制类
 * @author x.j niu
 *
 */

@Controller
@RequestMapping("/result")
public class ResultController {
	
	@Autowired
	private SemService semService;
	
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(ModelMap map,
			@RequestParam(defaultValue = " id  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,  SemresultT result,
			String corpid,
			HttpServletRequest request) {
		if(null != corpid && !corpid.equals("null")){
			result.setCorpid(corpid);
		}
		List<SemresultT> resultList = semService.find(result, order, page,
				rows);
		int count = semService.count(result);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(resultList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

}
