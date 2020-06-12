package com.flipkart.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;

public class StudentOpt implements StudentInterface{
private static Logger logger = Logger.getLogger(UserClient.class);

@Override
public String requestCatalog() {
CatalogDao catalogdao = new CatalogDaoImpl();
List<Course> catalog = catalogdao.fetchCatalog();

catalog.forEach(course -> System.out.println(course.getCoursename()));
return "";
}

@Override
public void addCourse(int courseId, int userId) {
	// TODO Auto-generated method stub
	
}

@Override
public void dropCourse() {
	// TODO Auto-generated method stub
	
}

}
