package com.gsccs.cmcc.contact.service;

import java.util.List;

import com.gsccs.cmcc.contact.model.ContactwayT;

public interface ContactwayService {
	
	public void add(ContactwayT contactway);

	public void update(ContactwayT contactway);

	public ContactwayT getContactway(String id);

	public void del(String id);

	public List<ContactwayT> find(ContactwayT contactway, String order, int currPage,
			int pageSize);

	public List<ContactwayT> find(ContactwayT contactway);
	
	public int count(ContactwayT contactway);

}
