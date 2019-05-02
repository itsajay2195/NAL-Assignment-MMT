package com.mmt.util;

import java.util.HashMap;
import java.util.Map;

public class DateOperation {
	public static String month_to_select;
	public static int total;
	public static int date;
	public static int return_date;
public static void Operation(String day1,String month1,String years1) {
	
	
	date=Integer.parseInt(day1);
	System.out.println("date is"+date);
	String mon=month1;
	String mon3=mon.replace("0", "");
	int mon4=Integer.parseInt(mon3);
	System.out.println(mon3);
	String year=years1;
	Map<Integer,Integer> m_d1=new HashMap<Integer,Integer>();
	m_d1.put(1, 31);
	m_d1.put(2, 28);
	m_d1.put(3, 31);
	m_d1.put(4, 30);
	m_d1.put(5, 31);
	m_d1.put(6, 30);
	m_d1.put(7, 31);
	m_d1.put(8, 31);
	m_d1.put(9, 30);
	m_d1.put(10, 31);
	m_d1.put(11, 30);
	m_d1.put(12, 31);
	
	Map<String,String> m_d=new HashMap<String,String>();
	m_d.put("1","January");
	m_d.put("2", "February");
	m_d.put("3", "March");
	m_d.put("4", "April");
	m_d.put("5", "May");
	m_d.put("6", "June");
	m_d.put("7", "July");
	m_d.put("8", "August");
	m_d.put("9", "September");
	m_d.put("10", "October");
	m_d.put("11", "November");
	m_d.put("12", "December");
	
	month_to_select=m_d.get(mon3);
   total=m_d1.get(mon4);
   return_date=date +7;
   
}
	
}
