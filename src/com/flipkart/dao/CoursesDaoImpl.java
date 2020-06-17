package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.utils.DBUtil;

public class CoursesDaoImpl implements CoursesDao {

	private static Logger logger = Logger.getLogger(CoursesDaoImpl.class);
	
	// A function used to add course by a student.
	@Override
	public void addCourse(int courseId, int userId) {
       Connection conn = DBUtil.getConnection();
		
		try {
			
			// String sql = "insert into courses(courseId,userId) values(?,?)";
			PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSES);
			stmt.setInt(1,courseId);
			stmt.setInt(2,userId);
			
			int s= stmt.executeUpdate();
			logger.info("Course " + courseId + " added for "+ userId);
			  }
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// A function used by a student to drop a course.
	@Override
	public void dropCourse(int courseId, int userId) {
		
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				// String sql = "delete from courses where courseId=? and userId=?";
				PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.DROP_COURSES);
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

	// A function used by a student to view grades in the different subjects he registered.
	@Override
	public Map<Integer, String> viewGrades(int userId) {
		
		 Connection conn = DBUtil.getConnection();

	       Map<Integer, String> hm =  new HashMap< Integer,String>(); 
		 
			try {
				
				// String sql = "select * from courses where userId=?";
				PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.VIEW_GRADES);
				stmt.setInt(1,userId);
                 ResultSet rs = stmt.executeQuery();
                
				
				while(rs.next()) {
					int courseId = rs.getInt("courseId");
					String grade = rs.getString("grades");
//					logger.info("#######################################################");
//					logger.info("Here's your report card \n");
//					logger.info("Student "+ userId + " scored " + grade + " in subject "+ courseId);
//					logger.info("#######################################################");
					hm.put(courseId, grade);
					//logger.info
//					String s = "Student "+ userId + " scored " + grade + " in subject "+ courseId;
//					logger.info(s);
//					gradesList.add("Student "+ userId + " scored " + grade + " in subject "+ courseId);
				 }
			
				
				  }
			catch(Exception e) {
				e.printStackTrace();
			}
			
		return hm;
	}
	
	// A function that computes the total payment that needs to be paid to get registered (GST Included) 
	public int doPayment(int userId) {
		Connection conn = DBUtil.getConnection();
		int payment=0;
		try {
			// String sql = "select sum(coursePayment) as totalPayment from courses join catalog on catalog.courseid = courses.courseId where userId = ? ";
			PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.DO_PAYMENT);
			stmt.setInt(1,userId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				 payment = rs.getInt("totalPayment");
			}
			logger.info(payment);
			
		}
		catch(Exception e) {
			
		}
		return payment;
	}
	
	// A function that submits the grades by a professor to a student in a particular course.
	
    public void submitGrades(int pUserId, int sUserId, int courseId, String grade) {
		
		Scanner sc = new Scanner(System.in);
		
		
		 Connection conn = DBUtil.getConnection();
			
			try {
				
				//String sql =  "update courses set grades=? where userId=? and courseId=?";
				PreparedStatement	stmt = conn.prepareStatement(SQLConstantQueries.SUBMIT_GRADES);
				
		       stmt.setString(1,grade);
		       stmt.setInt(2,sUserId);
		       stmt.setInt(3,courseId);
		       
		       int iw= stmt.executeUpdate();  
//		       logger.info(userId + " has been awarded " + grade + " grade in "+ courseId);
			
		
	}
			catch(Exception e) {
				logger.error("No marks could be updated by this professor");
				e.printStackTrace();
			}
		
		
	}


}
