package com.flipkart.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.CoursesDao;
import com.flipkart.dao.CoursesDaoImpl;
import com.flipkart.dao.CoursesDao;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;

public class StudentOperation implements StudentInterface{
	private static Logger logger = Logger.getLogger(StudentOperation.class);
	
	@Override
	public String requestCatalog() {

		CatalogDao catalogdao = new CatalogDaoImpl();
		List<Course> catalog = catalogdao.fetchCatalog();
		logger.info("####################################################################");
        logger.info("All the courses are listed here : \n");
		catalog.forEach(course -> logger.info(course.getCoursename()+"   "+ course.getCourseid() + "   " + course.getCourseDescription()));
		logger.info("####################################################################");
		return "";
	}
	
	@Override
	public void addCourse() {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the course Id");
		int courseId = sc.nextInt();
		logger.info("Enter the user Id");
		int userId = sc.nextInt();
		CoursesDao Coursesdao = new CoursesDaoImpl();
		Coursesdao.addCourse(courseId,userId);
	}
	
	@Override
	public void dropCourse() {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the course Id");
		int courseId = sc.nextInt();
		logger.info("Enter the user Id");
		int userId = sc.nextInt();
		CoursesDao Coursesdao = new CoursesDaoImpl();
		Coursesdao.dropCourse(courseId,userId);
		
	}

	@Override
	public void viewGrades(int userId) {
		CoursesDao Coursesdao = new CoursesDaoImpl();
		Coursesdao.viewGrades(userId);
	}

	@Override
	public void doPayment() {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the user Id");
		int userId = sc.nextInt();
		CatalogDao catalogdao = new CatalogDaoImpl();
		catalogdao.doPayment(userId);
		
	}
}


//CatalogDao catalogdao = new CatalogDaoImpl();
//List<Course> catalog = catalogdao.fetchCatalog();
//String s = "";
//Iterator<Course> i  = catalog.iterator();
//Course course;
//
//while(i.hasNext())
//{
//	course = i.next();
////	logger.debug(course.getCourseid());
//	s = s + course.getCourseid() + "," + course.getCoursename() + "," + course.getCourseDescription();
//}
//
//return s;

