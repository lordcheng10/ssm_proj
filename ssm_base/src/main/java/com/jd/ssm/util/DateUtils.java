package com.jd.ssm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {	
   private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   public static String getDateString(Date date){
	   return dateFormat.format(date);
   }
  public static Date strToDate(String date) throws ParseException{
	  return dateFormat.parse(date);
  }
}