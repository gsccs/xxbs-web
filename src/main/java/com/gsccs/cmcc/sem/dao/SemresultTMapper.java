package com.gsccs.cmcc.sem.dao;

import com.gsccs.cmcc.sem.model.SemresultT;
import com.gsccs.cmcc.sem.model.SemresultTExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SemresultTMapper {
    
    int countByExample(SemresultTExample example);
    int deleteByExample(SemresultTExample example);
    int deleteByPrimaryKey(Integer id);
    int insert(SemresultT record);
    List<SemresultT> selectPageByExample(SemresultTExample example);
    SemresultT selectByPrimaryKey(Integer id);

    int updateByExample(@Param("record") SemresultT record, @Param("example") SemresultTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_sem_result
     *
     * @mbggenerated Sun Apr 03 18:50:10 CST 2016
     */
    int updateByPrimaryKeySelective(SemresultT record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_sem_result
     *
     * @mbggenerated Sun Apr 03 18:50:10 CST 2016
     */
    int updateByPrimaryKey(SemresultT record);
}