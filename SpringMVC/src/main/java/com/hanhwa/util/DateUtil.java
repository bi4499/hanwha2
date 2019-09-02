package com.hanhwa.util;

import java.text.SimpleDateFormat;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

import java.sql.Date;

public class DateUtil {
	
	public static Date transDate(String sdate) {
		Date sql_date = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date d;
			d = sd.parse(sdate);
			sql_date = new Date(d.getTime());
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql_date;
	}
}
