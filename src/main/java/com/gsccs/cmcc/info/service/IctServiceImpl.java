package com.gsccs.cmcc.info.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.info.dao.IctprojectTMapper;
import com.gsccs.cmcc.info.dao.ProjectprogressTMapper;
import com.gsccs.cmcc.info.model.IctprojectT;
import com.gsccs.cmcc.info.model.IctprojectTExample;
import com.gsccs.cmcc.info.model.ProjectprogressTExample;

@Service
public class IctServiceImpl implements IctService {

	@Autowired
	private IctprojectTMapper ictprojectTMapper;
	@Autowired
	private ProjectprogressTMapper ictprogTMapper;

	@Override
	public void addIctproject(IctprojectT ictproject) {
		if (null != ictproject) {
			ictproject.setId(UUID.randomUUID().toString());
			ictprojectTMapper.insert(ictproject);
		}
	}

	@Override
	public List<IctprojectT> find(IctprojectT ictproject, String order,
			int currPage, int pageSize) {
		IctprojectTExample example = new IctprojectTExample();
		IctprojectTExample.Criteria c = example.createCriteria();
		proSearchParam(ictproject, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return ictprojectTMapper.selectPageByExample(example);
	}

	private void proSearchParam(IctprojectT ictproject,
			IctprojectTExample.Criteria criteria) {
		if (ictproject != null) {
			if (ictproject.getId() != null) {
				criteria.andIdEqualTo(ictproject.getId());
			}

			if (StringUtils.isNotEmpty(ictproject.getName())) {
				criteria.andNameLike("%" + ictproject.getName() + "%");
			}

			if (StringUtils.isNotEmpty(ictproject.getStatus())) {
				criteria.andStatusEqualTo(ictproject.getStatus());
			}
		}
	}

	@Override
	public int count(IctprojectT ictproject) {
		IctprojectTExample example = new IctprojectTExample();
		IctprojectTExample.Criteria c = example.createCriteria();
		proSearchParam(ictproject, c);
		return ictprojectTMapper.countByExample(example);
	}

	@Override
	public IctprojectT getIctproject(String id) {
		return ictprojectTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateIctproject(IctprojectT ictproject) {
		if (null != ictproject) {
			ictprojectTMapper.updateByPrimaryKey(ictproject);
		}
	}

	@Override
	public void delIctproject(String id) {
		ProjectprogressTExample example = new ProjectprogressTExample();
		ProjectprogressTExample.Criteria c = example.createCriteria();
		c.andProjectidEqualTo(id);
		// 删除进度
		ictprogTMapper.deleteByExample(example);
		// 删除项目
		ictprojectTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<IctprojectT> find(IctprojectT ictproject) {
		IctprojectTExample example = new IctprojectTExample();
		IctprojectTExample.Criteria c = example.createCriteria();
		proSearchParam(ictproject, c);
		return ictprojectTMapper.selectByExample(example);
	}
}
