package com.gsccs.cmcc.info.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.info.dao.CorpTMapper;
import com.gsccs.cmcc.info.dao.UsercorpTMapper;
import com.gsccs.cmcc.info.model.UsercorpT;
import com.gsccs.cmcc.info.model.UsercorpTExample;

@Service
public class UsercorpServiceImpl implements UsercorpService {

	@Autowired
	private CorpTMapper corpTMapper;
	
	private UsercorpTMapper ucorpTmapper;

	@Override
	public void addUsercorp(UsercorpT ucorp) {
		if (null != ucorp) {
			if (StringUtils.isEmpty(ucorp.getIspcode())){
				ucorp.setIspcode(UUID.randomUUID().toString());
			}
			ucorpTmapper.insert(ucorp);
		}
	}

	@Override
	public List<UsercorpT> find(UsercorpT ucorp, String order, int currPage, int pageSize) {
		UsercorpTExample example = new UsercorpTExample();
		UsercorpTExample.Criteria c = example.createCriteria();
		proSearchParam(ucorp, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return ucorpTmapper.selectPageByExample(example);
	}


	private void proSearchParam(UsercorpT ucorp, UsercorpTExample.Criteria criteria) {
		if (ucorp != null) {
			if (StringUtils.isNotEmpty(ucorp.getId())) {
				criteria.andIdEqualTo(ucorp.getId());
			}
			if (ucorp.getIspcode() != null) {
				criteria.andIspcodeEqualTo(ucorp.getIspcode());
			}
			if (ucorp.getUserid() != null) {
				criteria.andUseridEqualTo(ucorp.getUserid());
			}
			
		}
	}

	@Override
	public int count(UsercorpT ucorp) {
		UsercorpTExample example = new UsercorpTExample();
		UsercorpTExample.Criteria c = example.createCriteria();
		proSearchParam(ucorp, c);
		return ucorpTmapper.countByExample(example);
	}

	@Override
	public UsercorpT getUsercorp(String id) {
		return ucorpTmapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUsercorp(UsercorpT ucorp) {
		if (null != ucorp) {
			ucorpTmapper.updateByPrimaryKey(ucorp);
		}
	}

	@Override
	public void delUsercorp(String id) {
		ucorpTmapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<UsercorpT> find(UsercorpT ucorp) {
		UsercorpTExample example = new UsercorpTExample();
		UsercorpTExample.Criteria c = example.createCriteria();
		proSearchParam(ucorp, c);
		return ucorpTmapper.selectByExample(example);
	}

	
}
