package com.flipkart.constant;

public class SQLConstantQueries {
	
	public static final String USER_LOGIN = "select userId, password, userName, role from users where userName = ? and password = ?";
	public static final String SELECT_ALL_COURSES = "select * from coursecatalog";
	
}
