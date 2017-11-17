package com.gsccs.cmcc.info.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.data.dao.SpeclineMapper;
import com.gsccs.cmcc.data.model.Specline;
import com.gsccs.cmcc.data.model.SpeclineExample;
import com.gsccs.cmcc.info.dao.SpecattachsMapper;
import com.gsccs.cmcc.info.model.Specattachs;
import com.gsccs.cmcc.info.model.SpecattachsExample;

@Service
public class SpeclineServiceImpl implements SpeclineService {

	@Autowired
	private SpeclineMapper speclineMapper;

	@Autowired
	private SpecattachsMapper specattMapper;

	@Override
	public void addSpecline(Specline specline) {
		if (null != specline) {
			speclineMapper.insert(specline);
			// this.addSpecAttach(specline);
		}
	}

	@Override
	public void addSpecAttach(Specline specline) {
		if (null != specline && !specline.getAgreeimg().equals("")) {
			String[] fileurl = specline.getAgreeimg().split(";");
			String[] filename = specline.getFilenames().split(";");
			for (int i = 0; i < fileurl.length; i++) {
				Specattachs specatt = new Specattachs();
				specatt.setId(UUID.randomUUID().toString());
				specatt.setSpeclineid(specline.getId().toString());
				specatt.setTitle(filename[i]);
				specatt.setUrl(fileurl[i]);
				specattMapper.insert(specatt);
			}

		}
	}

	public void delSpecAttach(Long id) {
		SpecattachsExample example = new SpecattachsExample();
		SpecattachsExample.Criteria c = example.createCriteria();
		// c.and
		specattMapper.deleteByExample(example);
	}

	@Override
	public List<Specline> find(Specline specline, String order, int currPage,
			int pageSize) {
		SpeclineExample example = new SpeclineExample();
		SpeclineExample.Criteria c = example.createCriteria();
		proSearchParam(specline, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return speclineMapper.selectPageByExample(example);
	}

	private void proSearchParam(Specline specline,
			SpeclineExample.Criteria criteria) {
		if (specline != null) {
			if (StringUtils.isNotEmpty(specline.getIspcode())) {
				criteria.andIspcodeEqualTo(specline.getIspcode());
			}
			if (StringUtils.isNotEmpty(specline.getHasline())) {
				criteria.andHaslineEqualTo(specline.getHasline());
			}
			if (StringUtils.isNotEmpty(specline.getIsptype())) {
				criteria.andIsptypeEqualTo(specline.getIsptype());
			}
			if (StringUtils.isNotEmpty(specline.getLinetype())) {
				criteria.andLinetypeEqualTo(specline.getLinetype());
			}
			
			if(StringUtils.isNotEmpty(specline.getAreacode())){
				criteria.andAreacodeEqualTo(specline.getAreacode());
			}
		}
	}

	@Override
	public int count(Specline specline) {
		SpeclineExample example = new SpeclineExample();
		SpeclineExample.Criteria c = example.createCriteria();
		proSearchParam(specline, c);
		return speclineMapper.countByExample(example);
	}

	@Override
	public Specline getSpecline(Long id) {
		return speclineMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public void updateSpecline(Specline specline) {
		if (null != specline) {
			speclineMapper.updateByPrimaryKey(specline);

			// 删除附件
			this.delSpecAttach(specline.getId());
			// 添加附件
			this.addSpecAttach(specline);
		}
	}

	@Override
	public void delSpecline(Long id) {
		speclineMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean isExist(String ispcode) {
		/*
		 * SpeclineD st = speclineMapper.selectByPrimaryKey(ispcode); if(null !=
		 * st){ return true; }else{ return false; }
		 */
		return false;
	}

	@Override
	public List<Specattachs> find(Long speclineid) {
		SpecattachsExample example = new SpecattachsExample();
		SpecattachsExample.Criteria c = example.createCriteria();
		// c.andIspcodeEqualTo(ispcode);
		return specattMapper.selectByExample(example);
	}
}
