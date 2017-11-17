package com.gsccs.cmcc.info.dao;

import com.gsccs.cmcc.info.model.ProjectprogressT;
import com.gsccs.cmcc.info.model.ProjectprogressTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectprogressTMapper {
    int countByExample(ProjectprogressTExample example);

    int deleteByExample(ProjectprogressTExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectprogressT record);

    int insertSelective(ProjectprogressT record);

    List<ProjectprogressT> selectByExample(ProjectprogressTExample example);

    List<ProjectprogressT> selectPageByExample(ProjectprogressTExample example);
    
    ProjectprogressT selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectprogressT record, @Param("example") ProjectprogressTExample example);

    int updateByExample(@Param("record") ProjectprogressT record, @Param("example") ProjectprogressTExample example);

    int updateByPrimaryKeySelective(ProjectprogressT record);

    int updateByPrimaryKey(ProjectprogressT record);
}