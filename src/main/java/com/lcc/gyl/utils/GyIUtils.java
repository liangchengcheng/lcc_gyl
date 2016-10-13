package com.lcc.gyl.utils;

import java.util.Calendar;

public class GyIUtils {

	/**
	 * 获取年月日的string
	 * 
	 * @return
	 */
	public static String getDateToString() {
		// 使用日历类
		Calendar calendar = Calendar.getInstance();
		// 得到年
		int year = calendar.get(Calendar.YEAR);
		// 得到月 从0开始的话则加1
		int month = calendar.get(Calendar.MONDAY) + 1;
		// 得到天
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return "" + year + month + day;
	}

	public static String getDHH(String type) {
		Calendar cal = Calendar.getInstance();// 使用日历类
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1; // 得到月，因为从0开始的，所以要加1
		int day = cal.get(Calendar.DAY_OF_MONTH);// 得到天
		return type + year + month + day;
	}
}
