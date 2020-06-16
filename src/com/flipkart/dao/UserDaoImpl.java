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
		 
	 String sql = "insert into users values (?,?,?,?,?)";
	 PreparedStatement stmt = conn.prepareStatement(sql);
	 
	 stmt.setInt(1,user.getUserId());
	 stmt.setString(2,user.getPassword());
	 stmt.setString(3,user.getUserName());
	 stmt.setString(4,user.getRole());
	 stmt.setString(5,user.getGender());
	 
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

	@Override
	public List<User> viewUsers() {
		List <User> userList = new ArrayList <User>();
		
		Connection conn = DBUtil.getConnection();
		
		try {
			 String sql = "select * from users";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 
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