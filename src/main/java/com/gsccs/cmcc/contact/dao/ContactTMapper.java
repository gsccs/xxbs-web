package com.gsccs.cmcc.contact.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.cmcc.contact.model.ContactT;
import com.gsccs.cmcc.contact.model.ContactTExample;

public interface ContactTMapper {

	int countByExample(ContactTExample example);

	int deleteByExample(ContactTExample example);

	int deleteByPrimaryKey(String ispcode);

	int insert(ContactT record);

	List<ContactT> selectPageByExample(ContactTExample example);

	List<ContactT> selectByExample(ContactTExample example);
	
	ContactT selectByPrimaryKey(String ispcode);

	int updateByExample(@Param("record") ContactT record,
			@Param("example") ContactTExample example);

	int updateByPrimaryKey(ContactT record);
}