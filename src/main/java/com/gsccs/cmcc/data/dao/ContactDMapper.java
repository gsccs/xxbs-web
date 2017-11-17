package com.gsccs.cmcc.data.dao;

import com.gsccs.cmcc.data.model.ContactD;
import com.gsccs.cmcc.data.model.ContactDExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactDMapper {
    int countByExample(ContactDExample example);

    int deleteByExample(ContactDExample example);

    int insert(ContactD record);

    int insertSelective(ContactD record);

    List<ContactD> selectByExample(ContactDExample example);

    int updateByExampleSelective(@Param("record") ContactD record, @Param("example") ContactDExample example);

    int updateByExample(@Param("record") ContactD record, @Param("example") ContactDExample example);
}