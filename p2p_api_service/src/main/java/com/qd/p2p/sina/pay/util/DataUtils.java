package com.qd.p2p.sina.pay.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

	public static short def(Short val, short def) {
		return val == null ? def : (short) val;
	}

	public static short def(Short val) {
		return def(val, (short) 0);
	}

	public static int def(Integer val, int def) {
		return val == null ? def : val;
	}

	public static int def(Integer val) {
		return def(val, 0);
	}

	public static long def(Long val, long def) {
		return val == null ? def : val;
	}

	public static long def(Long val) {
		return def(val, 0L);
	}

	public static float def(Float val, float def) {
		return val == null ? def : val;
	}

	public static float def(Float val) {
		return def(val, 0F);
	}

	public static double def(Double val, double def) {
		return val == null ? def : val;
	}

	public static double def(Double val) {
		return def(val, 0D);
	}

	public static Date def(Date val, Date def) {
		return val == null ? def : val;
	}

	public static Date def(Date val) {
		return def(val, new Date());
	}

	public static Calendar def(Calendar val, Calendar def) {
		return val == null ? def : val;
	}

	public static Calendar def(Calendar val) {
		return def(val, Calendar.getInstance());
	}

	public static String def(String val, String def) {
		return val == null ? def : val;
	}

	public static String def(String val) {
		return def(val, "");
	}

	public static int toInt(Object val, int def) {
		if (val == null) {
			return def;
		}
		try {
			return Integer.valueOf(val.toString());
		} catch (NumberFormatException e) {
			return def;
		}
	}
	
	public static int toInt(Object val){
		return toInt(val, 0);
	}
	
	public static int toIntMin(Object val){
		return toInt(val, Integer.MIN_VALUE);
	}

	public static long toLong(Object val, long def) {
		if (val == null) {
			return def;
		}
		try {
			return Long.valueOf(val.toString());
		} catch (NumberFormatException e) {
			return def;
		}
	}
	
	public static long toLong(Object val){
		return toLong(val, 0L);
	}

	public static double toDouble(Object val, double def) {
		if (val == null) {
			return def;
		}
		try {
			return Double.valueOf(val.toString());
		} catch (NumberFormatException e) {
			return def;
		}
	}
	
	public static double toDouble(Object val){
		return toDouble(val, 0D);
	}
	
	public static float toFloat(Object val, float def) {
		if (val == null) {
			return def;
		}
		try {
			return Float.valueOf(val.toString());
		} catch (NumberFormatException e) {
			return def;
		}
	}
	
	public static float toFloat(Object val){
		return toFloat(val, 0F);
	}
	
	public static String toString(Object val, String def) {
		if (val == null) {
			return def;
		}
		return String.valueOf(val.toString());
	}
	
	public static String toString(Object val){
		return toString(val, "");
	}
	
	public static boolean toBoolean(Object val, boolean def) {
		if (val == null) {
			return def;
		}
		try {
			return Boolean.valueOf(val.toString());
		} catch (Exception e) {
			return def;
		}
	}
	
	public static boolean toBoolean(Object val){
		return toBoolean(val, false);
	}

	public static Date toDate(Object val) {
		if (val == null) {
			return null;
		}
		if (val instanceof Date) {
			return (Date) val;
		}
		return null;
	}

	public static Date toDate(String val, String pattern) {
		val = def(val);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(val);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Calendar toCalendar(Object val) {
		if (val == null) {
			return null;
		}
		if (val instanceof Calendar) {
			return (Calendar) val;
		}
		return null;
	}

	public static Calendar toCalendar(String val, String pattern) {
		val = def(val);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date date = sdf.parse(val);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (ParseException e) {
			return null;
		}
	}

	public static String format(Double val, String pattern) {
		val = def(val);
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(val);
	}

	public static String format(Double val, int precision) {
		StringBuffer pattern = new StringBuffer(precision + 2);
		pattern.append("0.");
		for (int i = 0; i < precision; i++) {
			pattern.append("0");
		}
		return format(val, pattern.toString());
	}

	public static String format(Float val, String pattern) {
		val = def(val);
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(val);
	}

	public static String format(Float val, int precision) {
		StringBuffer pattern = new StringBuffer(precision + 2);
		pattern.append("0.");
		for (int i = 0; i < precision; i++) {
			pattern.append("0");
		}
		return format(val, pattern.toString());
	}

	public static String format(Date val, String pattern) {
		if (val == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(val);
	}

	public static String format(Calendar val, String pattern) {
		if (val == null) {
			return "";
		}
		return format(val.getTime(), pattern);
	}

}
