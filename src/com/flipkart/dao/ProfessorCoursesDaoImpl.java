package com.flipkart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.utils.DBUtil;

public class ProfessorCoursesDaoImpl implements ProfessorCoursesDao {

	private static Logger logger = Logger.getLogger(ProfessorCoursesDaoImpl.class);
	
	// A function that enables a professor to view the courses he is currently teaching.
	@Override
	public List<Integer> viewProfessorCourses(int userId) {

		 Connection conn = DBUtil.getConnection();
		 List <Integer>  profCourses = new ArrayList<Integer>();
			
			try {
				
				// String sql = "select * from professorcourses where userId=?";
			
				// where userId=?
				PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.VIEW_PROF_COURSES);
				stmt.setInt(1,userId);
				ResultSet rs = stmt.executeQuery();
				
				
				
				while(rs.next()) {
					  int courseId = rs.getInt("courseId");
					 profCourses.add(courseId);
				 }
		
	}
			catch(Exception e) {
				logger.error("No courses are being taught by this professor");
				e.printStackTrace();
			}
			return  profCourses;
	}

	// A function that enables a professor to view the enrolled students he/she is currently teaching.
	@Override
	public Map<Integer, Integer> viewStudents(int userId) {
		
		 Map<Integer, Integer> hm =  new HashMap< Integer,Integer>(); 
		 
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				// String sql = "SELECT courses.userId, courses.courseId from courses,professorcourses where courses.courseId=professorcourses.courseId and professorcourses.userId = ?";
				PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.VIEW_ENROLLED_STUDENTS);

				// and professorcourses.userId=userId
				stmt.setInt(1,userId);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					int pUserId = rs.getInt("courses.courseId");
					 int rUserId =  rs.getInt("courses.userId");
					 hm.put(pUserId, rUserId);
				 }
		
	}
			catch(Exception e) {
				logger.error("No courses are being taught by this professor");
				e.printStackTrace();
			}
		
		return hm;
	}

}
