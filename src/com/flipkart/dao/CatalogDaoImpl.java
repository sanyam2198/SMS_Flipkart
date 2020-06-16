package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.utils.DBUtil;
import java.sql.ResultSet;

public class CatalogDaoImpl implements CatalogDao{
	private static Logger logger = Logger.getLogger(CatalogDaoImpl.class);
	Connection conn = null;
	PreparedStatement stmt = null;
	
	public List<Course> fetchCatalog()
	{
		conn = DBUtil.getConnection();
		Course course;
		List<Course> course_list = new ArrayList<Course>();
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.SELECT_ALL_COURSES);
			ResultSet rs = stmt.executeQuery();
			
			
			while(rs.next())
			{
				course = new Course();
				course.setCourseid(rs.getInt("courseid"));
				course.setCoursename(rs.getString("coursename"));
				course.setCourseDescription(rs.getString("courseDescription"));
				course_list.add(course);
			}
			
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return course_list;
	}

	@Override
	public void doPayment(int userId) {
		conn = DBUtil.getConnection();
		
		try {
			String sql = "select sum(coursePayment) as totalPayment from courses join catalog on catalog.courseid = courses.courseId where userId = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,userId);
			ResultSet rs = stmt.executeQuery();
			
			int payment=0;
			while(rs.next())
			{
				 payment = rs.getInt("totalPayment");
			}
			logger.info(payment);
			
		}
		catch(Exception e) {
			
		}
		
	}

}
