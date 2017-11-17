package com.gsccs.cmcc.sem.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.cmcc.sem.model.SemreportT;
import com.gsccs.cmcc.sem.model.SemresultT;
import com.gsccs.plat.bass.Datagrid;

/**
 * 日常营销业务接口
 * 
 * @author x.d zhang
 * 
 */
public interface SemService {

	public String addSemreport(SemreportT semitem);

	public void updateSemreport(SemreportT semitem);

	public SemreportT getSemreport(String id);

	public void delSemreport(String id);
	
	//日常上报
	public List<SemreportT> find(SemreportT semreport, String order, int currPage,
			int pageSize);
	
	public int count(SemreportT semitem);
	
	public void addSemresult(SemresultT semresult);

	public void updateSemresult(SemresultT semresult);

	public SemresultT getSemresult(String id);

	public void delSemresult(String id);
	
	//营销结果
	public List<SemresultT> find(SemresultT semresult, String order, int currPage,
			int pageSize);

	public int count(SemresultT semresult);
	
	public JSONArray getGridHead();
	public Datagrid findGridData(SemreportT param,int currPage,
			int pageSize) ;
}
