package com.flipkart.dao;

import java.util.List;
import java.util.Map;

public interface CoursesDao {

	public void addCourse(int courseId, int userId);
	public void dropCourse(int courseId, int userId);
	public Map<Integer, String> viewGrades(int userId);
	public int doPayment(int userId);
	public void submitGrades(int pUserId, int sUserId, int courseId, String grade);
}
