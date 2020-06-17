package com.flipkart.service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	// Adding the Users.
	
	@Override
	public void addUser(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
	}

	// Deleting the Users.
	@Override
	public void deleteUser(int userId) {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(userId);
	}

	// Editing the Users.
	@Override
	public void editUser(int userId) {
		User user = new User();
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(userId);
		
		user.setUserId(userId);
		logger.info("Enter the password");
		String password = sc.nextLine();
		user.setPassword(password);
		
		logger.info("Enter the userName");
		String userName = sc.nextLine();
		user.setUserName(userName);
		
		logger.info("Enter the role");
		String role = sc.nextLine();
		user.setRole(role);
		
		logger.info("Enter the gender");
		String gender = sc.nextLine();
		user.setGender(gender);
		
	    userDao = new UserDaoImpl();
		userDao.addUser(user);
		
	}

	// Adding the Courses.
	@Override
	public void addCourse(Course course) {
		UserDao userDao = new UserDaoImpl();
		userDao.addCourse(course);
	}
	
	// Deleting the Courses.

	@Override
	public void deleteCourse(int courseId) {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteCourse(courseId);
	}
	
	// Editing the Courses.
	
	@Override
	public void editCourse(int courseId) {

		Course course = new Course();
		UserDao userDao = new UserDaoImpl();
		userDao.deleteCourse(courseId);
		
		logger.info("Enter the coursename");
		String coursename = sc.nextLine();
		course.setCoursename(coursename);
		
//		logger.info("Enter the courseid");
//		int courseID = sc.nextInt();
		course.setCourseid(courseId);
		
		logger.info("Enter the Course Description");
		String courseDesc = sc.nextLine();
		 //courseDesc = sc.nextLine();
		course.setCourseDescription(courseDesc);
		
		userDao = new UserDaoImpl();
		userDao.addCourse(course);
		
	}

	// Viewing all the users.
	
	@Override
	public List <User> viewAllStudents() {
		UserDao userDao = new UserDaoImpl();
		return userDao.viewUsers();
		//System.out.println(userList.size());
	}

}
