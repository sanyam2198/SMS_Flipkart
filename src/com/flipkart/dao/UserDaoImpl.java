package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public String checkIdentity(User user) {

      Connection conn = DBUtil.getConnection();
		
		try {
			
			String sql = "SELECT userId, password, userName, role FROM users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int flag=0;
			
			while(rs.next()) {
				  int userId = rs.getInt("userId");
				  String password = rs.getString("password");
				  String userName = rs.getString("userName");
				  String role = rs.getString("role");
				  
//				  logger.info(user.getUserName());
//				  logger.info(user.getPassword());
			     
			    if(userName.equals(user.getUserName()))
			    {
			    	flag=1;
			    	if(password.equals(user.getPassword())) {
			    		  logger.info("Welcome : "+ userName);
			    		  logger.info(userId + "  "+ password + "  "+ userName + "  "+ role);
//						  logger.info(password);
//						  logger.info(userName);
//						  logger.info(role);
						return role;
					}
					else
						return "Incorrect password or username";
			    }
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Incorrect password or username";
	}

	@Override
	public void registerUser(User user) {
		
	}

	@Override
	public void addUser(User user) {
		 Connection conn = DBUtil.getConnection();
		 try {
			 
		 String sql = "insert into users values (?,?,?,?)";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 stmt.setInt(1,user.getUserId());
		 stmt.setString(2,user.getPassword());
		 stmt.setString(3,user.getUserName());
		 stmt.setString(4,user.getRole());
		 
		 int s = stmt.executeUpdate();
		 logger.info(user.getUserName()+ " added");
		 
		 }
		 catch(Exception e) {
			 
		 }
		
	}

	@Override
	public void deleteUser(int userId) {
		 Connection conn = DBUtil.getConnection();
		 try {
			 
		 String sql = "delete from users where userId=?";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 stmt.setInt(1,userId);
		 
		 int s = stmt.executeUpdate();
		 logger.info(userId+ " deleted");
		 }
         catch(Exception e) {
			 
		 }
		
	}

	@Override
	public void editUser(int userId) {
//		 Connection conn = DBUtil.getConnection();
//		 try {
//			 
//		 String sql = "update users set password=?, userName=?, role=? where userId=?";
//		 PreparedStatement stmt = conn.prepareStatement(sql);
//		 
//		 Scanner sc = new Scanner(System.in);
//		 logger.info("Enter the new password");
//		 
//		
//		 stmt.setString(2,user.getPassword());
//		 stmt.setString(3,user.getUserName());
//		 stmt.setString(4,user.getRole());
//		 stmt.setInt(4,userId);
//		 
//		 
//		 int s = stmt.executeUpdate();
//		 logger.info(user.getUserName()+ " edited");
//		 
//		 }
//		 catch(Exception e) {
//			 
//		 }
		
	}

	@Override
	public void addCourse(Course course) {
		Connection conn = DBUtil.getConnection();
		 try {
			 
		 String sql = "insert into course values (?,?,?)";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 stmt.setString(1,course.getCoursename());
		 stmt.setInt(2,course.getCourseid());
		 stmt.setString(3,course.getCourseDescription());
		 
		 int s = stmt.executeUpdate();
		 logger.info(course.getCoursename()+ " added");
		 
		 }
		 catch(Exception e) {
			 
		 }
		
	}

	@Override
	public void deleteCourse(int courseId) {
		 Connection conn = DBUtil.getConnection();
		 try {
			 
		 String sql = "delete from course where courseId=?";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 stmt.setInt(1,courseId);
		 
		 int s = stmt.executeUpdate();
		 logger.info(courseId + " deleted");
		 }
         catch(Exception e) {
			 
		 }
		
	}

	@Override
	public void editCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

}
