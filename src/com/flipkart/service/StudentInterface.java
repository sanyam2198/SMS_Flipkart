// Interface class for the operation that can be done by the student.
package com.flipkart.service;

import java.util.List;
import java.util.Map;

import com.flipkart.bean.Course;

public interface StudentInterface {
	public List<Course> requestCatalog();
	public void addCourse(int courseId,int userId);
	public void dropCourse(int courseId,int userId);
	public int doPayment(int userId);
	public Map<Integer, String> viewGrades(int userId);
}
