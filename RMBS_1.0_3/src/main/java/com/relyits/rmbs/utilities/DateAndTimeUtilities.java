package com.relyits.rmbs.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ibm.icu.util.Calendar;
import com.relyits.rmbs.model.product.ProductInventoryModel;

public class DateAndTimeUtilities {

	

	
	public static java.util.Date parseStringDateToDate(String stringTypeDate){
		java.util.Date date = new java.util.Date();
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(stringTypeDate);
		//	date = new SimpleDateFormat("yyyy-MM-dd").parse(stringTypeDate);
			System.out.println("Date----"+date);
			return date;
		} catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		return date;
		
	}
	
	public static java.util.Date parseStringDateToDateFormat(String stringTypeDate){
		java.util.Date date = new java.util.Date();
		try {
		//	date = new SimpleDateFormat("dd-MM-yyyy").parse(stringTypeDate);
			date = new SimpleDateFormat("yyyy-MM-dd").parse(stringTypeDate);
			System.out.println("Date----"+date);
			return date;
		} catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		return date;
		
	}
	@SuppressWarnings("deprecation")
	public static java.sql.Date parseStringDateToSqlDateFormat(String stringTypeDate) throws ParseException{
		java.util.Date utilDate=parseStringDateToDateFormat(stringTypeDate);
		System.out.println("Time>>>>>>>>>>>>>>>>>>>>>>>>  "+utilDate.getTime());
		System.out.println("Date>>>>>>>>>>>>>>>>>>>>>>>>  "+utilDate.getDate());
        java.sql.Date sql = new java.sql.Date(utilDate.getTime());
        System.out.println("Date>>>>>>>>>>>>>>>>>>>>>>>>  "+sql);
        return sql;
	}
	
	@SuppressWarnings("deprecation")
	public static java.sql.Date parseStringDateToSqlDate(String stringTypeDate) throws ParseException{
		java.util.Date utilDate=parseStringDateToDate(stringTypeDate);
		System.out.println("Time>>>>>>>>>>>>>>>>>>>>>>>>  "+utilDate.getTime());
		System.out.println("Date>>>>>>>>>>>>>>>>>>>>>>>>  "+utilDate.getDate());
        java.sql.Date sql = new java.sql.Date(utilDate.getTime());
        System.out.println("Date>>>>>>>>>>>>>>>>>>>>>>>>  "+sql);
        return sql;
	}
	
	 public static String getCurrentDateTime(){
	        String  datetime = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
	      String time = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
	      System.out.println("date  "+datetime+"          time  "+time);
	      datetime=datetime+","+time;
	   return datetime;
	 }
	 public static java.sql.Date getCurrentDateTimeInSqlFormat() throws ParseException{
		 return parseStringDateToSqlDate(getCurrentDateTime());
	 }
	 
	 public static String getCurrentDate(){
	        String  datetime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	   return datetime;
	 }
	 public static String getSubtractedDate(java.util.Calendar cal,int month){
	        return "" + cal.get(Calendar.YEAR) +"-" +
	                (cal.get(Calendar.MONTH)-month) + "-" + cal.get(Calendar.DATE);
	    }

	 public static long getDaysDifference(java.sql.Date expDate) throws ParseException{
			long dateDiff = 0;
			
			java.util.Date expiryDate = null;
		//	SimpleDateFormat format = new SimpleDateFormat("Day MM/dd/yyyy HH:mm;ss");	
					
			Date currentDate = getCurrentDateTimeInSqlFormat();		
	        expiryDate = new java.util.Date(expDate.getTime());
	        System.out.println("Converted value of java.util.Date : " + expiryDate);			
			
	        Date d1 = null;
			Date d2 = null;
			try{
			    d1 = expiryDate;
				d2 = currentDate;
				System.out.println("CurrentDate**********:"+d2);
				dateDiff = d1.getTime() - d2.getTime() ;			
			
		   } catch (Exception e) {

			e.printStackTrace();
		}	
			
			return dateDiff/(24*60*60*1000);
	 } 
	 
	 
	 public String controlNull(String varin){
		     if(varin==null){
		         varin="";
		     }
		     return varin;
	 }

}
