package com.gsccs.cmcc.sem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.cmcc.sem.model.SemreportT;
import com.gsccs.cmcc.sem.model.SemreportTExample;

public interface SemreportMapper {

	int countByExample(SemreportTExample example);

	int deleteByExample(SemreportTExample example);

	int deleteByPrimaryKey(String id);

	int insert(SemreportT record);

	List<SemreportT> selectPageByExample(SemreportTExample example);

	SemreportT selectByPrimaryKey(String id);

	int updateByExample(@Param("record") SemreportT record,
			@Param("example") SemreportTExample example);

	int updateByPrimaryKey(SemreportT record);
}