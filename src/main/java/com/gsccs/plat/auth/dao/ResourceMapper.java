package com.gsccs.plat.auth.dao;

import com.gsccs.plat.auth.model.Resource;
import com.gsccs.plat.auth.model.ResourceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int countByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int deleteByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    Resource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbggenerated Mon Mar 16 15:49:46 CST 2015
     */
    int updateByPrimaryKey(Resource record);
}