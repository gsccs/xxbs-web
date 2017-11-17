package com.gsccs.cmcc.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.data.dao.ContactDMapper;
import com.gsccs.cmcc.data.dao.InfoDMapper;
import com.gsccs.cmcc.data.dao.ReportDMapper;
import com.gsccs.cmcc.data.dao.SpeclineMapper;
import com.gsccs.cmcc.data.model.ContactD;
import com.gsccs.cmcc.data.model.InfoD;
import com.gsccs.cmcc.data.model.ReportD;
import com.gsccs.cmcc.data.model.Specline;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private ContactDMapper contactDMapper;
	
	@Autowired
	private InfoDMapper infoDMapper;
	
	@Autowired
	private ReportDMapper reportDMapper;
	
	@Autowired
	private SpeclineMapper speclineDMapper;

	@Override
	public void addContactD(ContactD contact) {
		contactDMapper.insert(contact);
	}

	@Override
	public void addInfoD(InfoD info) {
		infoDMapper.insert(info);
	}

	@Override
	public void addReportD(ReportD report) {
		reportDMapper.insert(report);
	}

	@Override
	public void addSpeclineD(Specline specline) {
		speclineDMapper.insert(specline);
	}
	
	@Override
	public void updateData() {
		speclineDMapper.callUpdateSpecline();
	}

}
