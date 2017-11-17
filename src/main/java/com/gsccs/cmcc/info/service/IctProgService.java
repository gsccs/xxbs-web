package com.gsccs.cmcc.info.service;

import java.util.List;

import com.gsccs.cmcc.info.model.ProjectprogressT;

public interface IctProgService {

	public void addIctprogress(ProjectprogressT ictprog);

	public void updateIctprogress(ProjectprogressT ictprog);

	public ProjectprogressT getIctprogress(String id);

	public void delIctprogress(String id);

	public List<ProjectprogressT> find(ProjectprogressT ictprog, String order,
			int currPage, int pageSize);
	
	public List<ProjectprogressT> find(ProjectprogressT ictprog);

	public int count(ProjectprogressT ictprog);
}
