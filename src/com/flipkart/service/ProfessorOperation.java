package com.flipkart.service;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.CoursesDao;
import com.flipkart.dao.CoursesDaoImpl;
import com.flipkart.dao.ProfessorCoursesDao;
import com.flipkart.dao.ProfessorCoursesDaoImpl;

public class ProfessorOperation implements ProfessorInterface {

	private static Logger logger = Logger.getLogger(ProfessorOperation.class);
	@Override
	public void viewProfessorCourses(int userId) {
		ProfessorCoursesDao professorCoursesDao = new ProfessorCoursesDaoImpl();
		professorCoursesDao.viewProfessorCourses(userId);
	}

	@Override
	public void submitGrades(int pUserId) {
		
		CoursesDao coursesDao = new CoursesDaoImpl();
		coursesDao.submitGrades(pUserId);
		logger.info("Marks successfuly submitted");
		
	}

	@Override
	public void viewCourses() {
		CatalogDao catalogdao = new CatalogDaoImpl();
		List<Course> catalog = catalogdao.fetchCatalog();
		logger.info("####################################################################");
        logger.info("All the courses are listed here : \n");
		catalog.forEach(course -> logger.info(course.getCoursename()+"   "+ course.getCourseid() + "   " + course.getCourseDescription()));
		logger.info("####################################################################");
		
	}

	@Override
	public void viewStudents(int userId) {
		
		ProfessorCoursesDao professorCoursesDao = new ProfessorCoursesDaoImpl();
		professorCoursesDao.viewStudents(userId);
	}

}
