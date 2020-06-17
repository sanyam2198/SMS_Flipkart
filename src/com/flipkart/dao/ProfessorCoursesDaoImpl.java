package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;

public class ProfessorCoursesDaoImpl implements ProfessorCoursesDao {

	private static Logger logger = Logger.getLogger(ProfessorCoursesDaoImpl.class);
	
	@Override
	public void viewProfessorCourses(int userId) {

		 Connection conn = DBUtil.getConnection();
			
			try {
				
				String sql = "select * from professorcourses where userId=?";
			
				// where userId=?
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1,userId);
				ResultSet rs = stmt.executeQuery();
				
				logger.info("Professor "+ userId + " teaches following courses");
				
				while(rs.next()) {
					  int courseId = rs.getInt("courseId");
					  logger.info(courseId);
				 }
		
	}
			catch(Exception e) {
				logger.error("No courses are being taught by this professor");
				e.printStackTrace();
			}
	}

	@Override
	public void viewStudents(int userId) {
		
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				String sql = "SELECT courses.userId, professorcourses.userId from courses,professorcourses where courses.courseId=professorcourses.courseId ";
				PreparedStatement stmt = conn.prepareStatement(sql);

				// and professorcourses.userId=userId
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int pUserId = rs.getInt("professorcourses.userId");
					 int rUserId =  rs.getInt("courses.userId");
					 logger.info(pUserId + "  " +rUserId);
				 }
		
	}
			catch(Exception e) {
				logger.error("No courses are being taught by this professor");
				e.printStackTrace();
			}
		
		
	}

}
