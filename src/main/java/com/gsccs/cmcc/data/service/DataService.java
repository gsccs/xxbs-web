package com.gsccs.cmcc.data.service;

import com.gsccs.cmcc.data.model.ContactD;
import com.gsccs.cmcc.data.model.InfoD;
import com.gsccs.cmcc.data.model.ReportD;
import com.gsccs.cmcc.data.model.Specline;

/**
 * 数据上报接口
 * @author Administrator
 *
 */
public interface DataService {
	
	public void addContactD(ContactD contact);
	
	public void addInfoD(InfoD info);
	
	public void addReportD(ReportD report);
	
	public void addSpeclineD(Specline specline);
	
	public void updateData();
	
}
