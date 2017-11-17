package com.gsccs.cmcc.sem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.cmcc.sem.model.SemrecomdT;
import com.gsccs.cmcc.sem.model.SemrecomdTExample;

public interface SemrecomdTMapper {

	int countByExample(SemrecomdTExample example);

	int deleteByExample(SemrecomdTExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SemrecomdT record);

	List<SemrecomdT> selectByExample(SemrecomdTExample example);
	
	List<SemrecomdT> selectPageByExample(SemrecomdTExample example);

	SemrecomdT selectByPrimaryKey(Integer id);

	int updateByExample(@Param("record") SemrecomdT record,
			@Param("example") SemrecomdTExample example);

	int updateByPrimaryKey(SemrecomdT record);
}