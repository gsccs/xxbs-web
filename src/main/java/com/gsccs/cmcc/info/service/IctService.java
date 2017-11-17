package com.gsccs.cmcc.info.service;

import java.util.List;

import com.gsccs.cmcc.info.model.IctprojectT;

public interface IctService {

	public void addIctproject(IctprojectT ictproject);

	public void updateIctproject(IctprojectT ictproject);

	public IctprojectT getIctproject(String id);

	public void delIctproject(String id);

	public List<IctprojectT> find(IctprojectT ictproject, String order,
			int currPage, int pageSize);
	
	public List<IctprojectT> find(IctprojectT ictproject);

	public int count(IctprojectT ictproject);
}
