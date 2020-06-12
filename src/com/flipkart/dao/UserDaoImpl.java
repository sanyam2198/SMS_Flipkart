package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;
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

}
