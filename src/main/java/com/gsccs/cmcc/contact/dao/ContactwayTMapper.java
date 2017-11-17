package com.gsccs.cmcc.contact.dao;

import com.gsccs.cmcc.contact.model.ContactwayT;
import com.gsccs.cmcc.contact.model.ContactwayTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactwayTMapper {
    int countByExample(ContactwayTExample example);

    int deleteByExample(ContactwayTExample example);

    int deleteByPrimaryKey(String id);

    int insert(ContactwayT record);

    int insertSelective(ContactwayT record);

    List<ContactwayT> selectByExample(ContactwayTExample example);
    
    List<ContactwayT> selectPageByExample(ContactwayTExample example);

    ContactwayT selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ContactwayT record, @Param("example") ContactwayTExample example);

    int updateByExample(@Param("record") ContactwayT record, @Param("example") ContactwayTExample example);

    int updateByPrimaryKeySelective(ContactwayT record);

    int updateByPrimaryKey(ContactwayT record);
}