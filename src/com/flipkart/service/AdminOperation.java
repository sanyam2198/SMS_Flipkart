package com.flipkart.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

public class AdminOperation implements AdminInterface {

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addUser() {
		User user = new User();
		logger.info("Enter the userId");
		int userId = sc.nextInt();
		user.setUserId(userId);
		
		logger.info("Enter the password");
		String password = sc.nextLine();
		password = sc.nextLine();
		
		user.setPassword(password);
		
		logger.info("Enter the userName");
		String userName = sc.nextLine();
		user.setUserName(userName);
		
		logger.info("Enter the role");
		String role = sc.nextLine();
		user.setRole(role);
		
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(userId);
	}

	@Override
	public void editUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse() {
		Course course= new Course();
		logger.info("Enter the coursename");
		String coursename = sc.nextLine();
		course.setCoursename(coursename);
		
		logger.info("Enter the courseid");
		int courseID = sc.nextInt();
		course.setCourseid(courseID);
		
		logger.info("Enter the Course Description");
		String courseDesc = sc.nextLine();
		 courseDesc = sc.nextLine();
		course.setCourseDescription(courseDesc);
		
		UserDao userDao = new UserDaoImpl();
		userDao.addCourse(course);
		
	}

	@Override
	public void deleteCourse(int courseId) {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteCourse(courseId);
	}

	@Override
	public void editCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

}
