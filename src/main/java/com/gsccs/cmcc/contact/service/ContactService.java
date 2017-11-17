package com.gsccs.cmcc.contact.service;

import java.util.List;

import com.gsccs.cmcc.contact.model.ContactT;

public interface ContactService {

	public void addContact(ContactT contact);

	public void updateContact(ContactT contact);

	public ContactT getContact(String id);

	public void delContact(String id);

	public List<ContactT> find(ContactT contact, String order, int currPage,
			int pageSize);

	public List<ContactT> find(ContactT contact);
	
	public int count(ContactT contact);
	
	public boolean isExist(String ispcode);
}
