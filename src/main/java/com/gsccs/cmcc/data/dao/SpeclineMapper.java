package com.gsccs.cmcc.data.dao;

import java.util.List;

import com.gsccs.cmcc.data.model.Specline;
import com.gsccs.cmcc.data.model.SpeclineExample;

public interface SpeclineMapper {

	List<Specline> selectPageByExample(SpeclineExample example);

	int countByExample(SpeclineExample example);

	int deleteByExample(SpeclineExample example);

	int insert(Specline record);

	Specline selectByPrimaryKey(Long id);

	int deleteByPrimaryKey(Long id);

	int updateByPrimaryKey(Specline record);

	void callUpdateSpecline();
}