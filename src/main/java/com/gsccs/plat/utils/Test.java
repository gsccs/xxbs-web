package com.gsccs.plat.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
public static void main(String[] args) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		String dstr="2008-4-24";  
		try {
			java.util.Date date=sdf.parse(dstr);
			Date d = new Date();
			System.out.println("d="+d);
			System.out.println("data="+date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
}
}
