package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {

	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	@Override
	public void addUser(int userId) {

		 Connection conn = DBUtil.getConnection();
		 
		 try {
			 String sql = "insert into admin values(?,?,?) where userId=?";
			  PreparedStatement stmt = conn.prepareStatement(sql);
			  Scanner sc = new Scanner(System.in);
			  
			  logger.info("Enter your name");
			  String name = sc.nextLine();
			  
			  stmt.setString(1,name);
			  
			  logger.info("Enter your gender");
			  String gender = sc.nextLine();
			  stmt.setString(2,gender);
			  
			  stmt.setInt(3,userId);
			  int z = stmt.executeUpdate();
		 }
		 catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

}
