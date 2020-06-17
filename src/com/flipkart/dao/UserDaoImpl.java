package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLConstantQueries;

import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	// Method to verify if the credentials entered are valid or invalid.
	@Override
	public String checkIdentity(User user) {

		String role = null;
		Connection conn = DBUtil.getConnection();
		try
		{
			PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.USER_LOGIN);
			
			stmt.setString(1,user.getUserName());
			stmt.setString(2, user.getPassword());
		
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				user.setRole(rs.getString("role"));
				user.setUserId(rs.getInt("userId"));
				role = rs.getString("role");
			}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	
		return role;
	}

	@Override
	public void registerUser(User user) {
		
	}

	// Method to create a new user (Admin,Professor,Student)
	@Override
	public void addUser(User user) {
	 Connection conn = DBUtil.getConnection();
	 try {
		 
	 //String sql = "insert into users values (?,?,?,?,?)";
	 PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.CREATE_USERS);
	 
	 stmt.setInt(1,user.getUserId());
	 stmt.setString(2,user.getPassword());
	 stmt.setString(3,user.getUserName());
	 stmt.setString(4,user.getRole());
	 stmt.setString(5,user.getGender());
	 int s = stmt.executeUpdate();
	 
//	 if(user.getRole().equals("student"))
//	 {
//	  // sql = "insert into students values (?,?,?,?,?)";
//	  stmt = conn.prepareStatement(sql);
//	 
//	 stmt.setInt(1,user.getUserId());
//	 stmt.setString(2,user.getPassword());
//	 stmt.setString(3,user.getUserName());
//	 stmt.setString(4,user.getRole());
//	 stmt.setString(5,user.getGender());
//	 }
//	 
//	 
//	 if(user.getRole().equals("admin"))
//	 {
//	  sql = "insert into admin values (?,?,?,?,?)";
//	  stmt = conn.prepareStatement(sql);
//	 
//	 stmt.setInt(1,user.getUserId());
//	 stmt.setString(2,user.getPassword());
//	 stmt.setString(3,user.getUserName());
//	 stmt.setString(4,user.getRole());
//	 stmt.setString(5,user.getGender());
//	 }
//	 
//	 
//	 if(user.getRole().equals("professor"))
//	 {
//	  sql = "insert into professor values (?,?,?,?,?)";
//	  stmt = conn.prepareStatement(sql);
//	 
//	 stmt.setInt(1,user.getUserId());
//	 stmt.setString(2,user.getPassword());
//	 stmt.setString(3,user.getUserName());
//	 stmt.setString(4,user.getRole());
//	 stmt.setString(5,user.getGender());
//	 }
	 
	 logger.info(user.getUserName()+ " added");
	 
	 }
	 catch(Exception e) {
		 
	 }
	
}

	// Method to delete an existing user (Admin,Professor,Student)
	@Override
	public void deleteUser(int userId) {
		 Connection conn = DBUtil.getConnection();
		 try {
			 
		// String sql = "delete from users where userId=?";
		 PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.DELETE_USERS);
		 
		 stmt.setInt(1,userId);
		 
		 int s = stmt.executeUpdate();
		 logger.info(userId+ " deleted");
		 }
         catch(Exception e) {
			 
		 }
		
	}

	// Method to update user details (Admin,Professor,Student)
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

	// Method to create a new Course in the system.
	@Override
	public void addCourse(Course course) {
		Connection conn = DBUtil.getConnection();
		 try {
			 
		 //String sql = "insert into catalog values (?,?,?,?)";
		 PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSES);
		 
		 stmt.setString(1,course.getCoursename());
		 stmt.setInt(2,course.getCourseid());
		 stmt.setString(3,course.getCourseDescription());
		 stmt.setInt(4,course.getCoursePayment());
		 
		 int s = stmt.executeUpdate();
		 logger.info(course.getCoursename()+ " added");
		 
		 }
		 catch(Exception e) {
			 
		 }
		
	}

	// Method to delete an existing Course from the system.
	@Override
	public void deleteCourse(int courseId) {
		 Connection conn = DBUtil.getConnection();
		 try {
			 
		 //String sql = "delete from catalog where courseid=?";
		 PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.DELETE_COURSES);
		 
		 stmt.setInt(1,courseId);
		 
		 int s = stmt.executeUpdate();
		 logger.info(courseId + " deleted");
		 }
         catch(Exception e) {
			 
		 }
		
	}

	// Method to edit Course details in the system.
	@Override
	public void editCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	// Method to create all the users along with their details.
	@Override
	public List<User> viewUsers() {
		List <User> userList = new ArrayList <User>();
		
		Connection conn = DBUtil.getConnection();
		
		try {
			 //String sql = "select * from users";
			 PreparedStatement stmt = conn.prepareStatement(SQLConstantQueries.VIEW_USERS);
			 
			 ResultSet rs = stmt.executeQuery();
			 
			 while(rs.next()) {
				 User user = new User();
				 user.setUserId(rs.getInt("userId"));
				 user.setPassword(rs.getString("password"));
				 user.setUserName(rs.getString("userName"));
				 user.setRole(rs.getString("role"));
				 user.setGender(rs.getString("gender"));
				 userList.add(user);		
			 }
		}
		catch(Exception e) {
			
		}
		return userList;
		
	}

}





//public void addUser(User user) {
//	 Connection conn = DBUtil.getConnection();
//	 try {
//		 
//	 String sql = "insert into users values (?,?,?,?)";
//	 PreparedStatement stmt = conn.prepareStatement(sql);
//	 Scanner sc = new Scanner(System.in);
//	 
//	 stmt.setInt(1,user.getUserId());
//	 stmt.setString(2,user.getPassword());
//	 stmt.setString(3,user.getUserName());
//	 stmt.setString(4,user.getRole());
//	
//	 int userId = user.getUserId();
//	
//	 logger.info(user.getRole());
//	 
//	 if((user.getRole()).equals("admin"))
//	 {
//		 AdminDao admindao = new AdminDaoImpl();
//		 admindao.addUser(userId);
//	 }
//	 
//	 if((user.getRole()).equals("professor"))
//	 {
//		  sql = "insert into professor values(?,?,?) where userId=?";
//		  stmt = conn.prepareStatement(sql);
//		  logger.info("Enter your name");
//		  String name = sc.nextLine();
//		  
//		  stmt.setString(1,name);
//		  
//		  logger.info("Enter your gender");
//		  String gender = sc.nextLine();
//		  stmt.setString(2,gender);
//		  
//		  stmt.setInt(3,userId);
//		 // s = stmt.executeUpdate();
//	 }
//	 
//	 if((user.getRole()).equals("student"))
//	 {
//		  sql = "insert into student values(?,?,?) where userId=?";
//		  stmt = conn.prepareStatement(sql);
//		  logger.info("Enter your name");
//		  String name = sc.nextLine();
//		  
//		  stmt.setString(1,name);
//		  
//		  logger.info("Enter your gender");
//		  String gender = sc.nextLine();
//		  stmt.setString(2,gender);
//		  
//		  stmt.setInt(3,userId);
//		  //s = stmt.executeUpdate();
//	 }
//	 //stmt.setString(5,user.getGender());
//	 
//	 
//	 logger.info(user.getUserName()+ " added");
//	 int s = stmt.executeUpdate();
//	 }
//	 catch(Exception e) {
//		 
//	 }
//	
//}