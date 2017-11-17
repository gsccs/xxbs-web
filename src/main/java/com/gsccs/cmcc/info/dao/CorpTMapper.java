package com.gsccs.cmcc.info.dao;

import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.CorpTExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CorpTMapper {

	int countByExample(CorpTExample example);
	
	int countByRoleExample(CorpTExample example);

	int deleteByExample(CorpTExample example);

	int deleteByPrimaryKey(String ispcode);

	int insert(CorpT record);

	List<CorpT> selectByExampleWithBLOBs(CorpTExample example);

	List<CorpT> selectPageByExample(CorpTExample example);
	
	List<CorpT> selectPageByRoleExample1(CorpTExample example);
	
	
	List<CorpT> selectPageByRoleExample(@Param("userids")String userids,   @Param("example")CorpTExample example);
	
	List<CorpT> selectByExample(CorpTExample example);

	CorpT selectByPrimaryKey(String ispcode);

	int updateByExample(@Param("record") CorpT record,
			@Param("example") CorpTExample example);

	int updateByPrimaryKeySelective(CorpT record);

	int updateByPrimaryKey(CorpT record);
}