package com.gsccs.cmcc.info.dao;

import com.gsccs.cmcc.info.model.UsercorpT;
import com.gsccs.cmcc.info.model.UsercorpTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsercorpTMapper {
    int countByExample(UsercorpTExample example);

    int deleteByExample(UsercorpTExample example);

    int deleteByPrimaryKey(String id);

    int insert(UsercorpT record);

    int insertSelective(UsercorpT record);

    List<UsercorpT> selectByExample(UsercorpTExample example);
    
    List<UsercorpT> selectPageByExample(UsercorpTExample example);

    UsercorpT selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UsercorpT record, @Param("example") UsercorpTExample example);

    int updateByExample(@Param("record") UsercorpT record, @Param("example") UsercorpTExample example);

    int updateByPrimaryKeySelective(UsercorpT record);

    int updateByPrimaryKey(UsercorpT record);
}