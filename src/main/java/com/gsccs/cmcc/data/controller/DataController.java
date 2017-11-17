package com.gsccs.cmcc.data.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.result.ExcelImportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.gsccs.cmcc.data.model.ContactD;
import com.gsccs.cmcc.data.model.InfoD;
import com.gsccs.cmcc.data.model.ReportD;
import com.gsccs.cmcc.data.model.Specline;
import com.gsccs.cmcc.data.service.DataService;
import com.gsccs.cmcc.info.model.IctprojectT;
import com.gsccs.plat.auth.model.DictGroupT;
import com.gsccs.plat.auth.model.DictItemT;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.service.DictService;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Constants;
import com.gsccs.plat.bass.JsonMsg;

@Controller
@RequestMapping("/data")
public class DataController {

	@Autowired
	private DictService dictService;
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 项目信息表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(String id, ModelMap map) {
		return "data/data-form";
	}
	
	
	/**
	 * 集团通讯录数据上传
	 * @param contact
	 * @param redirectAttributes
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	@ResponseBody
	public String contact(ContactD contact,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		JsonMsg msg = new JsonMsg();
		Map map = new HashMap();
		request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        DictGroupT dt = dictService.getGroupByCode(Constants.FILE_PATH);
        String path = dt.getVal();
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024) ;
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String name = item.getName() ;
                    String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
                    String oldName = name.replaceAll("." + fileSuffix,"");
                    
                    Subject subject = SecurityUtils.getSubject();
    				String username = (String)subject.getPrincipal();
    				User user = userService.findByAccount(username);
                    
    				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
    				String datapath = formater.format(new Date());
    				
                    //String fileName = "contactd_"+ UUID.randomUUID().toString();
    				String fileName = "contactd_"+user.getAccount()+"_" + datapath;
                    
                    
                    String newName = fileName + "." + fileSuffix;
                    OutputStream out = new FileOutputStream(new File(path,newName));
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    while( (length = in.read(buf) ) != -1){
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                    
                    //**数据上传后读取文件，录入数据**//*
                    
                    //this.saveContactDate(path+"\\"+newName);
                    this.saveContactDate(path+File.separator+newName);
                    //**将上传处理后的数据返回**//*
                    map.put("fileSuffix",fileSuffix);
                    map.put("fileName",name);
                    map.put("filePath",newName);
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println("出错了：" + e.getMessage());
            msg.setSuccess(false);
    		msg.setMsg("数据导入失败!");
        }
		msg.setData(map);
		//return msg;
		return "ok";
	}
	
	
	public void saveContactDate(String datapath){
		
		System.out.println("path="+datapath);
		
		  ImportParams params = new ImportParams();
          params.setTitleRows(0);
          params.setHeadRows(1);
          params.setNeedSave(true);
          
          Subject subject = SecurityUtils.getSubject();
			String username = (String)subject.getPrincipal();
			User user = userService.findByAccount(username);
          
      	ExcelImportResult<ContactD> result = 
      			 ExcelImportUtil.importExcelVerify(new File(datapath), ContactD.class, params);
      	
          if(null != result && result.getList().size() > 0){
          	for (int i = 0; i < result.getList().size(); i++) {
          		
          		ContactD ctg = result.getList().get(i);
          		ctg.setStatus(user.getAccount());
          		System.out.println(result.getList().get(i).getIsptype());
          		dataService.addContactD(ctg);
			}
          }
	}
	
	
	
	/**
	 * 信息化摸底数据上传
	 * @param contact
	 * @param redirectAttributes
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequiresPermissions("specline:view")
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@ResponseBody
	public String info(InfoD info,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		JsonMsg msg = new JsonMsg();
		
		
		Map map = new HashMap();
		request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        DictGroupT dt = dictService.getGroupByCode(Constants.FILE_PATH);
        String path = dt.getVal();
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024) ;
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String name = item.getName() ;
                    String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
                    String oldName = name.replaceAll("." + fileSuffix,"");
                    
                    Subject subject = SecurityUtils.getSubject();
    				String username = (String)subject.getPrincipal();
    				User user = userService.findByAccount(username);
                    
    				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
    				String datapath = formater.format(new Date());
    				
    				String fileName = "info_"+user.getAccount() + "_" + datapath;
    				
    				//String fileName = "info_"+ UUID.randomUUID().toString();
                    
                    
                    String newName = fileName + "." + fileSuffix;
                    OutputStream out = new FileOutputStream(new File(path,newName));
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    while( (length = in.read(buf) ) != -1){
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                    
                    //**数据上传后读取文件，录入数据**//*
                    
                    
                    this.saveInfoDate(path+File.separator+newName);
                    
                    //**将上传处理后的数据返回**//*
                    map.put("fileSuffix",fileSuffix);
                    map.put("fileName",name);
                    map.put("filePath",newName);
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println("出错了：" + e.getMessage());
        }
	
		msg.setSuccess(true);
		msg.setMsg("上传成功!");
		msg.setData("");
		//return msg;
		return "ok";
	}
	
	
	public void saveInfoDate(String datapath){
		
		  ImportParams params = new ImportParams();
          params.setTitleRows(0);
          params.setHeadRows(1);
          params.setNeedSave(true);
          
      	ExcelImportResult<InfoD> result = 
      			 ExcelImportUtil.importExcelVerify(new File(datapath), InfoD.class, params);
      	
          if(null != result && result.getList().size() > 0){
          	for (int i = 0; i < result.getList().size(); i++) {
          		
          		InfoD infod = result.getList().get(i);
          		
          		dataService.addInfoD(infod);
			}
          }
	}
	
	
	/**
	 * 日常信息数据上传
	 * @param contact
	 * @param redirectAttributes
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequiresPermissions("specline:view")
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	@ResponseBody
	public String report(ReportD report,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		JsonMsg msg = new JsonMsg();
		
		
		Map map = new HashMap();
		request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        DictGroupT dt = dictService.getGroupByCode(Constants.FILE_PATH);
        String path = dt.getVal();
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024) ;
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String name = item.getName() ;
                    String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
                    String oldName = name.replaceAll("." + fileSuffix,"");
                    
                    
                    Subject subject = SecurityUtils.getSubject();
    				String username = (String)subject.getPrincipal();
    				User user = userService.findByAccount(username);
                    
    				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
    				String datapath = formater.format(new Date());
    				
    				String fileName = "report_"+user.getAccount() + "_" + datapath;
                    
                   // String fileName = "report_"+ UUID.randomUUID().toString();
                    
                    
                    String newName = fileName + "." + fileSuffix;
                    OutputStream out = new FileOutputStream(new File(path,newName));
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    while( (length = in.read(buf) ) != -1){
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                    
                    //**数据上传后读取文件，录入数据**//*
                    
                    
                    this.saveReportDate(path+File.separator+newName);
                    
                    //**将上传处理后的数据返回**//*
                    map.put("fileSuffix",fileSuffix);
                    map.put("fileName",name);
                    map.put("filePath",newName);
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println("出错了：" + e.getMessage());
        }
	
		msg.setSuccess(true);
		msg.setMsg("上传成功!");
		msg.setData("");
		return "ok";
		//return msg;
	}
	
	
	public void saveReportDate(String datapath){
		
		  ImportParams params = new ImportParams();
          params.setTitleRows(0);
          params.setHeadRows(1);
          params.setNeedSave(true);
          
      	ExcelImportResult<ReportD> result = 
      			 ExcelImportUtil.importExcelVerify(new File(datapath), ReportD.class, params);
      	
          if(null != result && result.getList().size() > 0){
          	for (int i = 0; i < result.getList().size(); i++) {
          		
          		ReportD report = result.getList().get(i);
          		
          		dataService.addReportD(report);
			}
          }
	}
	
	
	
	/**
	 * 专线底数据上传
	 * @param contact
	 * @param redirectAttributes
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequiresPermissions("specline:view")
	@RequestMapping(value = "/specline", method = RequestMethod.POST)
	@ResponseBody
	public String specline(Specline specline,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		JsonMsg msg = new JsonMsg();
		
		
		Map map = new HashMap();
		request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        DictGroupT dt = dictService.getGroupByCode(Constants.FILE_PATH);
        String path = dt.getVal();
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024) ;
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String name = item.getName() ;
                    String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
                    String oldName = name.replaceAll("." + fileSuffix,"");
                    

                    Subject subject = SecurityUtils.getSubject();
    				String username = (String)subject.getPrincipal();
    				User user = userService.findByAccount(username);
                    
    				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
    				String datapath = formater.format(new Date());
    				
    				String fileName = "specline_"+user.getAccount() + "_" + datapath;
                    
                    //String fileName = "specline_"+ UUID.randomUUID().toString();
                    String newName = fileName + "." + fileSuffix;
                    OutputStream out = new FileOutputStream(new File(path,newName));
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    while( (length = in.read(buf) ) != -1){
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                    
                    //**数据上传后读取文件，录入数据**//*
                    
                    
                    this.saveSpeclineDate(path+File.separator+newName);
                    
                    //**将上传处理后的数据返回**//*
                    map.put("fileSuffix",fileSuffix);
                    map.put("fileName",name);
                    map.put("filePath",newName);
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println("出错了：" + e.getMessage());
        }
	
		msg.setSuccess(true);
		msg.setMsg("上传成功!");
		msg.setData("");
		return "ok";
	}
	
	
	public void saveSpeclineDate(String datapath){
		
		  ImportParams params = new ImportParams();
          params.setTitleRows(0);
          params.setHeadRows(1);
          params.setNeedSave(true);
          
      	ExcelImportResult<Specline> result = 
      			 ExcelImportUtil.importExcelVerify(new File(datapath), Specline.class, params);
      	
          if(null != result && result.getList().size() > 0){
        	  long importtime = new Date().getTime();
	          	for (int i = 0; i < result.getList().size(); i++) {
	          		Specline specline = result.getList().get(i);
	          		if(null == specline){
	          			continue;
	          		}
	          		if (StringUtils.isEmpty(specline.getIspcode())){
	          			continue;
	          		}
	          		specline.setImporttime(importtime);
	          		dataService.addSpeclineD(specline);
				}
	          	dataService.updateData();	
          }
	}
	
	@RequiresPermissions("specline:view")
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@ResponseBody
	public String data(Specline specline,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		
		
		JsonMsg msg = new JsonMsg();
		
		
		Map map = new HashMap();
		request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        DictGroupT dt = dictService.getGroupByCode(Constants.FILE_PATH);
        String path = dt.getVal();
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024) ;
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String name = item.getName() ;
                    String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
                    String oldName = name.replaceAll("." + fileSuffix,"");
                    

                    Subject subject = SecurityUtils.getSubject();
    				String username = (String)subject.getPrincipal();
    				User user = userService.findByAccount(username);
                    
    				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
    				String datapath = formater.format(new Date());
    				
    				String fileName = "specline_"+user.getAccount() + "_" + datapath;
                    
                    //String fileName = "specline_"+ UUID.randomUUID().toString();
                    String newName = fileName + "." + fileSuffix;
                    OutputStream out = new FileOutputStream(new File(path,newName));
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    while( (length = in.read(buf) ) != -1){
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                    
                    //**数据上传后读取文件，录入数据**//*
                    
                    
                    this.saveSpeclineDate(path+File.separator+newName);
                    
                    //**将上传处理后的数据返回**//*
                    map.put("fileSuffix",fileSuffix);
                    map.put("fileName",name);
                    map.put("filePath",newName);
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println("出错了：" + e.getMessage());
        }
	
		msg.setSuccess(true);
		msg.setMsg("上传成功!");
		msg.setData("");
		return "ok";
	}
	
	

	@RequestMapping(value="uploadFile", method=RequestMethod.POST)
	@ResponseBody
	public void uploadFile( HttpServletRequest request, HttpServletResponse response   ) throws IOException {

		System.out.println("1111111111111111111");
		
		response.setCharacterEncoding( "UTF-8" );
		Integer chunk = null;  //分割块数 
		Integer chunks = null; // 总分割数 
		String tempFileName = null; // 临时文件名 
		String newFileName = null;  //最后合并后的新文件名 
		BufferedOutputStream	outputStream	= null;
		

		  DictGroupT dt = dictService.getGroupByCode(Constants.FILE_PATH);
	        String uploadPath = dt.getVal();
		 System.out.println(FileUtils.getTempDirectoryPath()); 
		//uploadPath = request.getServletContext().getRealPath( bundle.getString( "uploadPath" ) );
		File up = new File( uploadPath );
		if ( !up.exists() )
		{
			up.mkdir();
		}
		
		if ( ServletFileUpload.isMultipartContent( request ) )
		{
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold( 1024 );
				// factory.setRepository(new File(repositoryPath));// 设置临时目录 
				ServletFileUpload upload = new ServletFileUpload( factory );
				upload.setHeaderEncoding( "UTF-8" );
				 upload.setSizeMax(5 * 1024 * 1024);// 设置附件最大大小，超过这个大小上传会不成功 
				List<FileItem> items = upload.parseRequest( request );
				for ( FileItem item : items )
				{
					if ( item.isFormField() ) // 是文本域 
					{
						if ( item.getFieldName().equals( "name" ) )
						{
							tempFileName = item.getString();
							 System.out.println("临时文件名：" + tempFileName); 
						} else if ( item.getFieldName().equals( "chunk" ) )
						{
							chunk = Integer.parseInt( item.getString() );
							 System.out.println("当前文件块：" + (chunk + 1)); 
						} else if ( item.getFieldName().equals( "chunks" ) )
						{
							chunks = Integer.parseInt( item.getString() );
							 System.out.println("文件总分块：" + chunks); 
						}
					} else { // 如果是文件类型 
						if ( tempFileName != null )
						{
							String chunkName = tempFileName;
							if ( chunk != null )
							{
								chunkName = chunk + "_" + tempFileName;
							}
							File savedFile = new File( uploadPath, chunkName );
							item.write( savedFile );
						}
					}
				}
				
				  Subject subject = SecurityUtils.getSubject();
  				String username = (String)subject.getPrincipal();
  				User user = userService.findByAccount(username);
  				
  				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
				String datapath = formater.format(new Date());
				
				String fileName = "specline_"+user.getAccount() + "_" + datapath;
				//UUID.randomUUID().toString().replace( "-", "" )
				newFileName = "specline_"+user.getAccount() + "_" + datapath
					      .concat( "." )
					      .concat( FilenameUtils.getExtension( tempFileName ) );
				if ( chunk != null && chunk + 1 == chunks )
				{
					outputStream = new BufferedOutputStream(
						new FileOutputStream( new File( uploadPath, newFileName ) ) );
					// 遍历文件合并 
					for ( int i = 0; i < chunks; i++ )
					{
						File tempFile = new File( uploadPath, i + "_" + tempFileName );
						byte[] bytes = FileUtils.readFileToByteArray( tempFile );
						outputStream.write( bytes );
						outputStream.flush();
						tempFile.delete();
					}
					outputStream.flush();
				}
				Map<String, Object> m = new HashMap<String, Object>();
				m.put( "status", true );
				m.put( "fileUrl", uploadPath + "/"
				       + newFileName );
				response.getWriter().write( JSON.toJSONString( m ) );
			} catch ( FileUploadException e ) {
				e.printStackTrace();
				Map<String, Object> m = new HashMap<String, Object>();
				m.put( "status", false );
				response.getWriter().write( JSON.toJSONString( m ) );
			} catch ( Exception e ) {
				e.printStackTrace();
				Map<String, Object> m = new HashMap<String, Object>();
				m.put( "status", false );
				response.getWriter().write( JSON.toJSONString( m ) );
			} finally {
				try {
					if ( outputStream != null )
						outputStream.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
