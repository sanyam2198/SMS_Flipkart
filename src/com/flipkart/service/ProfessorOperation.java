package com.flipkart.service;

import java.util.List;
import java.util.Map;
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
	
	// Method to view the professor courses.
	@Override
	public List<Integer> viewProfessorCourses(int userId) {
		ProfessorCoursesDao professorCoursesDao = new ProfessorCoursesDaoImpl();
		return professorCoursesDao.viewProfessorCourses(userId);
	}

	// Method to submit final grades of the students.
	@Override
	public void submitGrades(int pUserId, int sUserId, int courseId, String grade) {
		
		CoursesDao coursesDao = new CoursesDaoImpl();
		coursesDao.submitGrades(pUserId,sUserId,courseId,grade);
		logger.info("Marks successfuly submitted");
		
	}

	// Function for Viewing all the courses that are available.
	@Override
	public List<Course> viewCourses() {
		CatalogDao catalogdao = new CatalogDaoImpl();
		return catalogdao.fetchCatalog();	
	}

	// View all the enrolled students taught by the professor.
	@Override
	public  Map<Integer, Integer> viewStudents(int userId) {
		
		ProfessorCoursesDao professorCoursesDao = new ProfessorCoursesDaoImpl();
		return professorCoursesDao.viewStudents(userId);
	}
	
	// Selection of a course by professor.
	public void selectCourse(int userId, int courseId) {
		ProfessorCoursesDao professorCoursesDao = new ProfessorCoursesDaoImpl();
		 professorCoursesDao.selectCourse(userId,courseId);
	}

}
