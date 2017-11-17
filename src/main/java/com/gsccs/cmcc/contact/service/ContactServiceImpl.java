package com.gsccs.cmcc.contact.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.contact.dao.ContactTMapper;
import com.gsccs.cmcc.contact.dao.ContactwayTMapper;
import com.gsccs.cmcc.contact.model.ContactT;
import com.gsccs.cmcc.contact.model.ContactTExample;
import com.gsccs.cmcc.contact.model.ContactwayTExample;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactTMapper contactTMapper;
	@Autowired
	private ContactwayTMapper contactwayTMapper;

	@Override
	public void addContact(ContactT contact) {
		if (null != contact) {
			if (StringUtils.isEmpty(contact.getId())){
				contact.setId(UUID.randomUUID().toString());
			}
			contactTMapper.insert(contact);
		}
	}

	@Override
	public List<ContactT> find(ContactT contact, String order, int currPage, int pageSize) {
		ContactTExample example = new ContactTExample();
		ContactTExample.Criteria c = example.createCriteria();
		proSearchParam(contact, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return contactTMapper.selectPageByExample(example);
	}


	private void proSearchParam(ContactT contact, ContactTExample.Criteria criteria) {
		if (contact != null) {
			if (contact.getId() != null) {
				criteria.andIdEqualTo(contact.getId());
			}

			if (StringUtils.isNotEmpty(contact.getTitle())) {
				criteria.andTitleLike("%" + contact.getTitle() + "%");
			}
		}
	}

	@Override
	public int count(ContactT contact) {
		ContactTExample example = new ContactTExample();
		ContactTExample.Criteria c = example.createCriteria();
		proSearchParam(contact, c);
		return contactTMapper.countByExample(example);
	}

	@Override
	public ContactT getContact(String id) {
		return contactTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateContact(ContactT contact) {
		if (null != contact) {
			contactTMapper.updateByPrimaryKey(contact);
		}
	}

	@Override
	public void delContact(String id) {
		ContactwayTExample example = new ContactwayTExample();
		ContactwayTExample.Criteria c = example.createCriteria();
		c.andCidEqualTo(id);
		//删除通讯方式
		contactwayTMapper.deleteByExample(example);
		//删除通讯录
		contactTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean isExist(String id) {
		ContactT ct = contactTMapper.selectByPrimaryKey(id);
		if(null != ct){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<ContactT> find(ContactT contact) {
		ContactTExample example = new ContactTExample();
		ContactTExample.Criteria c = example.createCriteria();
		proSearchParam(contact, c);
		return contactTMapper.selectByExample(example);
	}
}
