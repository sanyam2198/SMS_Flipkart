package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;

public class RegisterationDaoImpl implements RegisterationDao {

	private static Logger logger = Logger.getLogger(RegisterationDaoImpl.class);
	@Override
	public void addCourse(int courseId, int userId) {
       Connection conn = DBUtil.getConnection();
		
		try {
			
			String sql = "insert into registeration values(?,?)";
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
				
				String sql = "delete from registeration where courseId=? and userId=?";
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


}
