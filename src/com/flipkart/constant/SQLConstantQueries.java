// All the queries have been placed here and made final so as to access them in different places without writing the whole query.
package com.flipkart.constant;

public class SQLConstantQueries {
	
	public static final String USER_LOGIN = "select userId, password, userName, role from users where userName = ? and password = ?";
	public static final String SELECT_ALL_COURSES = "select * from catalog";
	public static final String ADD_COURSES = "insert into courses(courseId,userId) values(?,?)";
	public static final String DROP_COURSES = "delete from courses where courseId=? and userId=?";
	public static final String  VIEW_GRADES = "select * from courses where userId=?";
	public static final String  DO_PAYMENT = "select sum(coursePayment) as totalPayment from courses join catalog on catalog.courseid = courses.courseId where userId = ? ";
	public static final String  SUBMIT_GRADES = "update courses set grades=? where userId=? and courseId=?";
	public static final String  VIEW_PROF_COURSES = "select * from professorcourses where userId=?";
	public static final String  VIEW_ENROLLED_STUDENTS = "SELECT courses.userId, courses.courseId from courses,professorcourses where courses.courseId=professorcourses.courseId and professorcourses.userId = ?";
	public static final String  REGISTER = "insert into registration values(?,?,?,?)";
	public static final String  CREATE_USERS ="insert into users values (?,?,?,?,?)";
	public static final String  DELETE_USERS = "delete from users where userId=?";
	public static final String  CREATE_COURSES = "insert into catalog values (?,?,?,?)";
	public static final String  DELETE_COURSES = "delete from catalog where courseid=?";
	public static final String  VIEW_USERS = "select * from users";
	public static final String SELECT_COURSE_TO_TEACH = "insert into professorcourses values (?,?)";
}
