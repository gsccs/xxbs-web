package com.gsccs.cmcc.info.dao;

import com.gsccs.cmcc.info.model.IctprojectT;
import com.gsccs.cmcc.info.model.IctprojectTExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IctprojectTMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int countByExample(IctprojectTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int deleteByExample(IctprojectTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int insert(IctprojectT record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int insertSelective(IctprojectT record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    List<IctprojectT> selectPageByExample(IctprojectTExample example);
    
    
    List<IctprojectT> selectByExample(IctprojectTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    IctprojectT selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int updateByExampleSelective(@Param("record") IctprojectT record, @Param("example") IctprojectTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int updateByExample(@Param("record") IctprojectT record, @Param("example") IctprojectTExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int updateByPrimaryKeySelective(IctprojectT record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xxbs_ictproject
     *
     * @mbggenerated Fri Apr 01 18:45:16 CST 2016
     */
    int updateByPrimaryKey(IctprojectT record);
}