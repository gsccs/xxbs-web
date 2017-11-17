package com.gsccs.cmcc.sem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.cmcc.info.model.ProductT;
import com.gsccs.cmcc.info.model.PropT;
import com.gsccs.cmcc.info.service.CorpService;
import com.gsccs.cmcc.info.service.ProductService;
import com.gsccs.cmcc.info.service.PropService;
import com.gsccs.cmcc.sem.dao.SemrecomdTMapper;
import com.gsccs.cmcc.sem.dao.SemreportMapper;
import com.gsccs.cmcc.sem.dao.SemresultTMapper;
import com.gsccs.cmcc.sem.model.SemrecomdT;
import com.gsccs.cmcc.sem.model.SemrecomdTExample;
import com.gsccs.cmcc.sem.model.SemreportT;
import com.gsccs.cmcc.sem.model.SemreportTExample;
import com.gsccs.cmcc.sem.model.SemresultT;
import com.gsccs.cmcc.sem.model.SemresultTExample;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.DatagridColumn;
import com.gsccs.plat.bass.DatagridColumn.Align;

@Service
public class SemServiceImpl implements SemService {

	@Autowired
	private SemreportMapper semreportTMapper;
	@Autowired
	private SemrecomdTMapper semrecomdTMapper;
	@Autowired
	private SemresultTMapper semresultTMapper;
	@Autowired
	private ProductService productService;
	@Autowired
	private PropService propService;
	@Autowired
	private CorpService corpService;

	@Override
	public String addSemreport(SemreportT semitem) {
		if (null != semitem) {
			String id = UUID.randomUUID().toString();
			semitem.setId(id);
			semreportTMapper.insert(semitem);
			return id;
		}
		return null;
	}

	@Override
	public List<SemreportT> find(SemreportT semitem, String order,
			int currPage, int pageSize) {
		SemreportTExample example = new SemreportTExample();
		SemreportTExample.Criteria c = example.createCriteria();
		proSearchParam(semitem, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return semreportTMapper.selectPageByExample(example);
	}

	@Override
	public int count(SemreportT semitem) {
		SemreportTExample example = new SemreportTExample();
		SemreportTExample.Criteria c = example.createCriteria();
		proSearchParam(semitem, c);
		return semreportTMapper.countByExample(example);
	}

	@Override
	public SemreportT getSemreport(String id) {
		return semreportTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateSemreport(SemreportT semitem) {
		if (null != semitem) {
			semreportTMapper.updateByPrimaryKey(semitem);
		}
	}

	@Override
	public void delSemreport(String id) {
		SemresultTExample example = new SemresultTExample();
		SemresultTExample.Criteria c = example.createCriteria();
		c.andReportidEqualTo(id);
		semresultTMapper.deleteByExample(example);
		semreportTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SemresultT> find(SemresultT semresult, String order,
			int currPage, int pageSize) {
		SemresultTExample example = new SemresultTExample();
		SemresultTExample.Criteria c = example.createCriteria();
		proSearchParam(semresult, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return semresultTMapper.selectPageByExample(example);
	}

	private void proSearchParam(SemreportT semitem,
			SemreportTExample.Criteria criteria) {
		if (semitem != null) {
			if (StringUtils.isNotEmpty(semitem.getCorpid())) {
				criteria.andCorpidEqualTo(semitem.getCorpid());
			}

			if (StringUtils.isNotEmpty(semitem.getAmuserid())) {
				criteria.andAmuseridEqualTo(semitem.getAmuserid());
			}
		}
	}

	private void proSearchParam(SemresultT semresultT,
			SemresultTExample.Criteria criteria) {
		if (semresultT != null) {
			if (StringUtils.isNotEmpty(semresultT.getCorpid())) {
				criteria.andCorpidEqualTo(semresultT.getCorpid());
			}

			if (StringUtils.isNotEmpty(semresultT.getAmuserid())) {
				criteria.andAmuseridEqualTo(semresultT.getAmuserid());
			}

			if (StringUtils.isNotEmpty(semresultT.getReportid())) {
				criteria.andReportidEqualTo(semresultT.getReportid());
			}
		}
	}

	private void proSearchParam(SemrecomdT semrecomd,
			SemrecomdTExample.Criteria criteria) {
		if (semrecomd != null) {
			if (StringUtils.isNotEmpty(semrecomd.getCorpid())) {
				criteria.andCorpidEqualTo(semrecomd.getCorpid());
			}

			if (StringUtils.isNotEmpty(semrecomd.getAmuserid())) {
				criteria.andAmuseridEqualTo(semrecomd.getAmuserid());
			}

			if (StringUtils.isNotEmpty(semrecomd.getReportid())) {
				criteria.andReportidEqualTo(semrecomd.getReportid());
			}
		}
	}

	@Override
	public void addSemresult(SemresultT semresult) {
		if (null != semresult) {
			semresultTMapper.insert(semresult);
		}
	}

	@Override
	public void updateSemresult(SemresultT semresult) {
		semresultTMapper.updateByPrimaryKey(semresult);

	}

	@Override
	public SemresultT getSemresult(String id) {
		return semresultTMapper.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public void delSemresult(String id) {
		semresultTMapper.deleteByPrimaryKey(Integer.valueOf(id));

	}

	@Override
	public int count(SemresultT semresult) {
		SemresultTExample example = new SemresultTExample();
		SemresultTExample.Criteria c = example.createCriteria();
		proSearchParam(semresult, c);
		return semresultTMapper.countByExample(example);
	}

	@Override
	public JSONArray getGridHead() {
		// 生成表头
		JSONArray columns = new JSONArray();
		List<DatagridColumn> row_1_columns = new ArrayList<DatagridColumn>();
		List<DatagridColumn> row_2_columns = new ArrayList<DatagridColumn>();
		// 客户表头
		DatagridColumn corpcol = new DatagridColumn();
		corpcol.setTitle("走访信息");
		corpcol.setField("id");
		corpcol.setColspan(4);
		corpcol.setAlign(Align.CENTER.getType());
		row_1_columns.add(corpcol);

		DatagridColumn areacol = new DatagridColumn();
		areacol.setTitle("地域");
		areacol.setField("areastr");
		row_2_columns.add(areacol);

		DatagridColumn corptitlecol = new DatagridColumn();
		corptitlecol.setTitle("集团客户名称");
		corptitlecol.setField("corptitle");
		row_2_columns.add(corptitlecol);

		DatagridColumn amnamecol = new DatagridColumn();
		amnamecol.setTitle("客户经理");
		amnamecol.setField("amname");
		row_2_columns.add(amnamecol);

		DatagridColumn semdatecol = new DatagridColumn();
		semdatecol.setTitle("走访日期");
		semdatecol.setField("semdate");
		row_2_columns.add(semdatecol);
		
		DatagridColumn corpidcol = new DatagridColumn();
		corpidcol.setTitle("地域");
		corpidcol.setField("corpid");
		corpidcol.setHidden(true);
		//row_2_columns.add(corpidcol);
		
		DatagridColumn idcol = new DatagridColumn();
		idcol.setTitle("主键");
		idcol.setField("id");
		idcol.setHidden(true);
		//row_2_columns.add(idcol);

		// 营销表头
		ProductT productParam = new ProductT();
		productParam.setStatus("1");
		productParam.setIssem("1"); // 参与营销产品
		List<ProductT> productList = productService.find(productParam, "", 1,
				Integer.MAX_VALUE);

		if (null != productList && productList.size() > 0) {
			for (ProductT productT : productList) {
				PropT propParam = new PropT();
				propParam.setProductid(productT.getId());
				List<PropT> propList = propService.find(propParam, "indexnum",
						1, Integer.MAX_VALUE);
				if (null != propList && propList.size() > 0) {
					// 遍历所有属性
					for (PropT propT : propList) {
						DatagridColumn propdc = new DatagridColumn();
						// 获取属性的名字
						//propdc.setField(propT.getPropcode());
						//BUG
						propdc.setField(productT.getId());
						propdc.setTitle(propT.getTitle());
						propdc.setWidth(80);
						row_2_columns.add(propdc);
					}
					DatagridColumn productdc = new DatagridColumn();
					productdc.setTitle(productT.getTitle());
					productdc.setColspan(propList.size());
					row_1_columns.add(productdc);
				}
			}
		}

		columns.add(row_1_columns);
		columns.add(row_2_columns);
		return columns;
	}

	@Override
	public Datagrid findGridData(SemreportT param,int currPage,
			int pageSize) {
		Datagrid datagrid = new Datagrid();
		List<SemreportT> reportList = this.find(param, "addtime desc", currPage, pageSize);
		if (null != reportList && reportList.size() > 0) {
			JSONArray rowarray = new JSONArray();
			for (SemreportT reportT : reportList) {
				JSONObject json = new JSONObject();
				json.put("id", reportT.getId());
				json.put("amname", reportT.getAmname());
				json.put("corptitle", reportT.getCorptitle());
				json.put("corpid", reportT.getCorpid());
				json.put("semdate", reportT.getAdddateStr());
				json.put("areastr", reportT.getAreastr());
				
				SemresultT resultParam = new SemresultT();
				resultParam.setCorpid(reportT.getCorpid());
				resultParam.setReportid(reportT.getId());
				List<SemresultT> resultList = this.find(resultParam, "", 1,
						Integer.MAX_VALUE);
				if (null != resultList && resultList.size() > 0) {
					for (SemresultT resultT : resultList) {
						json.put(resultT.getProductid(), resultT.getSmereult());
					}
				}
				rowarray.add(json);
			}
			datagrid.setRows(rowarray);
			int total = this.count(param);
			datagrid.setTotal(Long.valueOf(total));
		}
		return datagrid;
	}
}
