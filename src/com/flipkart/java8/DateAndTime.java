package com.flipkart.java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

import org.apache.log4j.Logger;

import com.flipkart.client.UserClient;

public class DateAndTime {

	private static Logger logger = Logger.getLogger(DateAndTime.class);
	    public void displayCurrentDateAndTime() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		
		logger.info(" " + localDate.getDayOfWeek() + "    " + localDate.getDayOfMonth() + " - " + localDate.getMonth()+" - " + localDate.getYear() + "   " + localTime + " .");
//		logger.info(localDate.getDayOfMonth() + "/" + localDate.getMonth()+"/" + localDate.getYear()+"." );
//		logger.info("Today is " + localDate.getDayOfWeek());
//		logger.info("Calendar Day " + localDate.getDayOfYear());
		
	}

}


//logger.info( localDate.getMonth()+"/");
//logger.info(localDate.getYear()+".");

//System.out.print(localDate.getDayOfMonth()+"/");
//System.out.print( localDate.getMonth()+"/");
//System.out.println(localDate.getYear()+".");
//System.out.println("Today is " + localDate.getDayOfWeek());
//
//System.out.println("Calendar Day " + localDate.getDayOfYear());
//System.out.println("Current Time : " + localTime);


//System.out.println("Date : " + localDate.getDayOfMonth());
//System.out.println("Month : " + localDate.getMonth());
//System.out.println("Year : " + localDate.getYear());
//System.out.println("Day : " + localDate.getDayOfWeek());
//
//System.out.println("Calendar Day " + localDate.getDayOfYear());
//System.out.println("Current Time : " + localTime);
//System.out.println("localTime.getSecond(): " + localTime.getSecond());
//System.out.println("localTime.getMinute(): " + localTime.getMinute());
//System.out.println("localTime.getHour(): " + localTime.getHour());