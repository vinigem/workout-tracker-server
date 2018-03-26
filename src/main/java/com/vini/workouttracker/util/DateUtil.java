package com.vini.workouttracker.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat DAY_NAME_FORMATTTER = new SimpleDateFormat("EEE");

	/**
	 * get time difference in munutes
	 * @param startTime the start date and time
	 * @param endTime the end date and time
	 * @return diff in minutes
	 */
	public static float getMinuteDifference(Date startTime, Date endTime) {
		long diff = endTime.getTime() - startTime.getTime();
		return diff / (60 * 1000) % 60;
	}

	/**
	 * check if a date is todays date
	 * @param dateToCheck the date to check
	 * @return boolean
	 */
	public static boolean isTodaysDate(Date dateToCheck) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date today = cal.getTime();

		cal.setTime(dateToCheck);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date dateSpecified = cal.getTime();
		return today.compareTo(dateSpecified) == 0;
	}

	/**
	 * check if date is of current week(Between Monday and Sunday)
	 * @param dateToCheck the date to check
	 * @return boolean
	 */
	public static boolean isCurrentWeeksDate(Date dateToCheck) {
		Date monday = getMondayOfWeek();
		Date sunday = getSundayOfWeek();
		return monday.compareTo(dateToCheck) * dateToCheck.compareTo(sunday) >= 0;
	}
	
	/**
	 * check if date is of current month
	 * @param dateToCheck the date to check
	 * @return boolean
	 */
	public static boolean isCurrentMonthsDate(Date dateToCheck) {
		Calendar given = Calendar.getInstance();
		Calendar today = Calendar.getInstance();

		given.setTime(dateToCheck);
		
		return given.get(Calendar.YEAR) == today.get(Calendar.YEAR)
				&& given.get(Calendar.MONTH) == today.get(Calendar.MONTH);
	}
	
	/**
	 * check if date is of current year
	 * @param dateToCheck the date to check
	 * @return boolean
	 */
	public static boolean isCurrentYearsDate(Date dateToCheck) {
		Calendar given = Calendar.getInstance();
		Calendar today = Calendar.getInstance();

		given.setTime(dateToCheck);
		
		return given.get(Calendar.YEAR) == today.get(Calendar.YEAR);
	}
	
	/**
	 * get short day name for the date
	 * @param date the date
	 * @return short day name
	 */
	public static String getDayShortName(Date date) {
		return DAY_NAME_FORMATTTER.format(date);
	}
	
	/**
	 * get week name for the date
	 * @param date the date
	 * @return week name
	 */
	public static String getWeekName(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		return "Week " + week;
	}
	
	/**
	 * get month no of date
	 * @param date the date
	 * @return month number
	 */
	public static String getMonthNo(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return String.valueOf(cal.get(Calendar.MONTH) + 1);
	}
	
	/**
	 * get the date of current week monday
	 * @return date
	 */
	private static Date getMondayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	/**
	 * get the date of current week sunday
	 * @return date
	 */
	private static Date getSundayOfWeek() {
		Date monday = getMondayOfWeek();
		Calendar cal = Calendar.getInstance();
		cal.setTime(monday);
		cal.add(Calendar.DATE, 6);
		return cal.getTime();
	}

}
