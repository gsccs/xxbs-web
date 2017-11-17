package com.gsccs.cmcc.contact.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.contact.dao.ContactwayTMapper;
import com.gsccs.cmcc.contact.model.ContactwayT;
import com.gsccs.cmcc.contact.model.ContactwayTExample;

@Service
public class ContactwayServiceImpl implements ContactwayService{
	
	@Autowired
	private ContactwayTMapper cwayTMapper;

	@Override
	public void add(ContactwayT contactway) {
		if (null != contactway) {
			if (StringUtils.isEmpty(contactway.getId())){
				contactway.setId(UUID.randomUUID().toString());
			}
			cwayTMapper.insert(contactway);
		}
		
	}

	@Override
	public void update(ContactwayT contactway) {
		cwayTMapper.updateByPrimaryKey(contactway);
		
	}

	@Override
	public ContactwayT getContactway(String id) {
		return cwayTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void del(String id) {
		cwayTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ContactwayT> find(ContactwayT contactway, String order,
			int currPage, int pageSize) {
		ContactwayTExample example = new ContactwayTExample();
		ContactwayTExample.Criteria c = example.createCriteria();
		proSearchParam(contactway, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return cwayTMapper.selectPageByExample(example);
	}

	@Override
	public List<ContactwayT> find(ContactwayT contactway) {
		ContactwayTExample example = new ContactwayTExample();
		ContactwayTExample.Criteria c = example.createCriteria();
		proSearchParam(contactway, c);
		return cwayTMapper.selectByExample(example);
	}

	@Override
	public int count(ContactwayT contactway) {
		ContactwayTExample example = new ContactwayTExample();
		ContactwayTExample.Criteria c = example.createCriteria();
		proSearchParam(contactway, c);
		return cwayTMapper.countByExample(example);
	}

	

	private void proSearchParam(ContactwayT contactway, ContactwayTExample.Criteria criteria) {
		if (contactway != null) {
			if (contactway.getId() != null ) {
				criteria.andIdEqualTo(contactway.getId());
			}
			if (contactway.getIspcode() !=null) {
				criteria.andIspcodeEqualTo( contactway.getIspcode() );
			}
			if (contactway.getPhone() !=null) {
				criteria.andPhoneEqualTo( contactway.getPhone() );
			}
			if (contactway.getCid() !=null && !contactway.getCid().equals("null")) {
				criteria.andCidEqualTo( contactway.getCid() );
			}
		}
	}
}
