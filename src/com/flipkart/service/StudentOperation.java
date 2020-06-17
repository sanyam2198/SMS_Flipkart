package com.flipkart.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	
	// Method used to list all the courses in catalog.
	@Override
	public List<Course> requestCatalog() {
		CatalogDao catalogdao = new CatalogDaoImpl();
		return catalogdao.fetchCatalog();
	}
	
	// Method used to add course by student.
	@Override
	public void addCourse(int courseId,int userId) {
		CoursesDao Coursesdao = new CoursesDaoImpl();
		Coursesdao.addCourse(courseId,userId);
	}
	
	// Method used to drop course by student.
	@Override
	public void dropCourse(int courseId,int userId) {
		CoursesDao Coursesdao = new CoursesDaoImpl();
		Coursesdao.dropCourse(courseId,userId);
	}

	// Method used to view grades by student.
	@Override
	public Map<Integer, String> viewGrades(int userId) {
		CoursesDao Coursesdao = new CoursesDaoImpl();
		return Coursesdao.viewGrades(userId);
	}

	// Method used to calculate payable amount by student.
	@Override
	public int doPayment(int userId) {
		CoursesDao coursesdao = new CoursesDaoImpl();
		int payment = coursesdao.doPayment(userId);
		return payment;
	}
}


