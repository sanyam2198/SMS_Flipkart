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
				
				String sql = "SELECT registeration.userId, professorcourses.userId from registeration,professorcourses where registeration.courseId=professorcourses.courseId ";
				PreparedStatement stmt = conn.prepareStatement(sql);

				// and professorcourses.userId=userId
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int pUserId = rs.getInt("professorcourses.userId");
					 int rUserId =  rs.getInt("registeration.userId");
					 logger.info(pUserId + "  " +rUserId);
				 }
		
	}
			catch(Exception e) {
				logger.error("No courses are being taught by this professor");
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void submitGrades(int pUserId) {
		
		Scanner sc = new Scanner(System.in);
		logger.info("Enter the userId of student");
		int userId = sc.nextInt();
		logger.info("Enter the courseId");
		int courseId = sc.nextInt();
		logger.info("Enter the grade");
		String grade = sc.nextLine();
		grade = sc.nextLine();
		
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				String sql =  "update registeration set grades=? where userId=? and courseId=?";
				PreparedStatement	stmt = conn.prepareStatement(sql);
				
		       stmt.setString(1,grade);
		       stmt.setInt(2,userId);
		       stmt.setInt(3,courseId);
		       
		       int iw=stmt.executeUpdate();  
		       logger.info(userId + " has been awarded " + grade + " grade in "+ courseId);
			
		
	}
			catch(Exception e) {
				logger.error("No marks could be updated by this professor");
				e.printStackTrace();
			}
		
		
	}

}
