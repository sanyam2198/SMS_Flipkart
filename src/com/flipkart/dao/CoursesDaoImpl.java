package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;

public class CoursesDaoImpl implements CoursesDao {

	private static Logger logger = Logger.getLogger(CoursesDaoImpl.class);
	@Override
	public void addCourse(int courseId, int userId) {
       Connection conn = DBUtil.getConnection();
		
		try {
			
			String sql = "insert into courses(courseId,userId) values(?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseId);
			stmt.setInt(2,userId);
			
			int s= stmt.executeUpdate();
			logger.info("Course " + courseId + " added for "+ userId);
			  }
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void dropCourse(int courseId, int userId) {
		
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				String sql = "delete from courses where courseId=? and userId=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1,courseId);
				stmt.setInt(2,userId);
				
				int s= stmt.executeUpdate();
				logger.info("Course " + courseId + " dropped for "+ userId);
				  }
			catch(Exception e) {
				e.printStackTrace();
			}
//			catch(SQLException e) {
//				e.printStackTrace();
//			}
		
	}

	@Override
	public void viewGrades(int userId) {
		
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				String sql = "select * from courses where userId=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1,userId);
                 ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					int courseId = rs.getInt("courseId");
					String grade = rs.getString("grades");
					logger.info("#######################################################");
					logger.info("Here's your report card \n");
					logger.info("Student "+ userId + " scored " + grade + " in subject "+ courseId);
					logger.info("#######################################################");
				 }
			
				
				
				  }
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}


}
