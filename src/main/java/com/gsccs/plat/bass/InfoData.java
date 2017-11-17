package com.gsccs.plat.bass;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 信息化摸底数据模型
 * @author Administrator
 *
 */
public class InfoData {
	
	/*==============摸底基础数据=============*/
	
	//集团编码
	@Excel(name="集团编码")
	private String ispcode;
	
	//集团名称
	@Excel(name="集团名称")
	private String corpname;
	
	//客户经理名称
	@Excel(name="客户经理名称")
	private String username;
	
	//地区名称
	@Excel(name="县市")
	private String areaname;
	
	//地区编码
	private String acode;
	
	/*================ICT信息====================*/
	//项目名称
	@Excel(name="项目名称")
	private String ictname;
	
	//项目建设内容
	@Excel(name="项目建设内容")
	private String buildcontent;
	
	//项目投资金额
	@Excel(name="项目投资金额（万元）")
	private String ussm;
	
	/*================IMS比推产品====================*/
	//是否使用座机
	@Excel(name="是否使用座机")
	private String isPlane;
	
	//哪家运营商的座机
	@Excel(name="项目投资金额（万元）")
	private String planetype;
	
	//座机数量
	@Excel(name="项目投资金额（万元）")
	private String plantNum;
	//月资费
	@Excel(name="项目投资金额（万元）")
	private String cost;
	//到期时间
	@Excel(name="项目投资金额（万元）")
	private String endDate;
	
	

}
