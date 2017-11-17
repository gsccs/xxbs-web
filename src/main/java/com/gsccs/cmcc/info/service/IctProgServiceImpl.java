package com.gsccs.cmcc.info.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.info.dao.ProjectprogressTMapper;
import com.gsccs.cmcc.info.model.IctprojectT;
import com.gsccs.cmcc.info.model.IctprojectTExample;
import com.gsccs.cmcc.info.model.ProjectprogressT;
import com.gsccs.cmcc.info.model.ProjectprogressTExample;

@Service
public class IctProgServiceImpl implements IctProgService {

	@Autowired
	private ProjectprogressTMapper ictprogTMapper;
	

	private void proSearchParam(ProjectprogressT ictprog,
			ProjectprogressTExample.Criteria criteria) {
		if (ictprog != null) {
			if (ictprog.getId() != null) {
				criteria.andIdEqualTo(ictprog.getId());
			}
			if(ictprog.getProjectid() !=null){
				criteria.andProjectidEqualTo(ictprog.getProjectid());
			}
		}
	}

	

	@Override
	public void addIctprogress(ProjectprogressT ictprog) {
		if (null != ictprog) {
			ictprog.setId(UUID.randomUUID().toString());
			ictprogTMapper.insert(ictprog);
		}
		
	}

	@Override
	public void updateIctprogress(ProjectprogressT ictprog) {
		ictprogTMapper.updateByPrimaryKey(ictprog);
		
	}

	@Override
	public void delIctprogress(String id) {
		ictprogTMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<ProjectprogressT> find(ProjectprogressT ictprog, String order,
			int currPage, int pageSize) {
		ProjectprogressTExample example = new ProjectprogressTExample();
		ProjectprogressTExample.Criteria c = example.createCriteria();
		proSearchParam(ictprog, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return ictprogTMapper.selectPageByExample(example);
	}

	@Override
	public List<ProjectprogressT> find(ProjectprogressT ictprog) {
		ProjectprogressTExample example = new ProjectprogressTExample();
		ProjectprogressTExample.Criteria c = example.createCriteria();
		proSearchParam(ictprog, c);
		return ictprogTMapper.selectByExample(example);
	}

	@Override
	public int count(ProjectprogressT ictprog) {
		ProjectprogressTExample example = new ProjectprogressTExample();
		ProjectprogressTExample.Criteria c = example.createCriteria();
		proSearchParam(ictprog, c);
		return ictprogTMapper.countByExample(example);
	}



	@Override
	public ProjectprogressT getIctprogress(String id) {
		return ictprogTMapper.selectByPrimaryKey(id);
	}
}
