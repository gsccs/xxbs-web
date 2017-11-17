package com.gsccs.cmcc.info.dao;

import com.gsccs.cmcc.info.model.Specattachs;
import com.gsccs.cmcc.info.model.SpecattachsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecattachsMapper {
    int countByExample(SpecattachsExample example);

    int deleteByExample(SpecattachsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Specattachs record);

    int insertSelective(Specattachs record);

    List<Specattachs> selectByExample(SpecattachsExample example);

    Specattachs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Specattachs record, @Param("example") SpecattachsExample example);

    int updateByExample(@Param("record") Specattachs record, @Param("example") SpecattachsExample example);

    int updateByPrimaryKeySelective(Specattachs record);

    int updateByPrimaryKey(Specattachs record);
}