package com.gsccs.cmcc.sem.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.sem.dao.SemrecomdTMapper;
import com.gsccs.cmcc.sem.model.SemrecomdT;
import com.gsccs.cmcc.sem.model.SemrecomdTExample;
import com.gsccs.cmcc.sem.model.SemrecomdTExample.Criteria;

@Service
public class RecomdServiceImpl implements RecomdService{
	
	@Autowired
	private SemrecomdTMapper semrecomdTMapper;

	@Override
	public Integer add(SemrecomdT recomd) {
		if (null != recomd) {
			semrecomdTMapper.insert(recomd);
			return recomd.getId();
		}
		return null;
	}

	@Override
	public void update(SemrecomdT recomd) {
		semrecomdTMapper.updateByPrimaryKey(recomd);
	}

	@Override
	public SemrecomdT getSemrecomdT(String id) {
		return semrecomdTMapper.selectByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public void del(String id) {
		semrecomdTMapper.deleteByPrimaryKey(Integer.valueOf(id));
	}

	@Override
	public List<SemrecomdT> find(SemrecomdT semreport, String order,
			int currPage, int pageSize) {
		SemrecomdTExample example = new SemrecomdTExample();
		SemrecomdTExample.Criteria c = example.createCriteria();
		proSearchParam(semreport, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return semrecomdTMapper.selectPageByExample(example);
	}

	private void proSearchParam(SemrecomdT semreport, Criteria criteria) {
		if (semreport != null) {
			if (StringUtils.isNotEmpty(semreport.getCorpid()) &&!semreport.getCorpid().equals("null") ) {
				criteria.andCorpidEqualTo(semreport.getCorpid());
			}

			if (StringUtils.isNotEmpty(semreport.getAmuserid())) {
				criteria.andAmuseridEqualTo(semreport.getAmuserid());
			}

			if (StringUtils.isNotEmpty(semreport.getReportid()) ) {
				criteria.andReportidEqualTo(semreport.getReportid());
			}
		}
	}

	@Override
	public int count(SemrecomdT recomd) {
		SemrecomdTExample example = new SemrecomdTExample();
		SemrecomdTExample.Criteria c = example.createCriteria();
		proSearchParam(recomd, c);
		return semrecomdTMapper.countByExample(example);
	}

}
