package com.gsccs.plat.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.cmcc.contact.model.ContactT;
import com.gsccs.plat.auth.service.DictService;

public class ImportExcel {
	
	@Autowired
	private static DictService dictService;
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		String dstr="2008-4-24";  
		try {
			java.util.Date date=sdf.parse(dstr);
			
			System.out.println("data="+date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		   
		/*DictGroupT ispdgt = new DictGroupT();
		ispdgt.setCode(QueryConstants.ISP_TYPE);
		ispdgt.setTitle("");
		System.out.println("ddddddddddd");
		List<DictGroupT> ispList = 	dictService.findGroupList(ispdgt);*/
	}
	
	
	public static void main1(String[] args) {
		// "d:/tt.xls"
		String pathname = "C:\\soft\\filepath\\tt.xlsx";
		File file = new File(pathname);
		ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        params.setNeedSave(true);
        try {
            /*List<ContactT> list =  
            		ExcelImportUtil.importExcel(file, ContactT.class, params);
                System.out.println("list=="+list.size());*/
            		//ExcelImportUtil.importExcelByIs(file.getInputStream(),BlackListEntity.class,params);
              
        	ExcelImportResult<ContactT> result = ExcelImportUtil.importExcelVerify(new File(
                        "C:\\soft\\filepath\\tt.xlsx"), ContactT.class, params);
                if(null != result && result.getList().size() > 0){
                	for (int i = 0; i < result.getList().size(); i++) {
               		 System.out.println("ispcode=="+result.getList().get(i).getIspcode()+"="
                	+result.getList().get(i).getName() +"=="+result.getList().get(i).getTitle());
					}
                }
                System.out.println("====="+result.getClass().getCanonicalName());
                System.out.println("====="+result.getList().size());
            // allRecords.addAll(listBlackList);
        } catch (Exception e) {
           // logger.error(ExceptionUtil.getExceptionMessage(e));
        }finally{
            /*try {
                file.getInputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
	}
}
