package com.gsccs.cmcc.info.service;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.PropvalT;
import com.gsccs.plat.bass.Datagrid;
import com.gsccs.plat.bass.TreeGrid;

public interface SurveyService {

	public JSONArray getTreeGridHeader();
	public JSONArray getDataGridHeader();

	public TreeGrid findCorpTree(CorpT param, Integer page, Integer rows);
	public Datagrid findCorpDgList(CorpT param, Integer page, Integer rows);

}
