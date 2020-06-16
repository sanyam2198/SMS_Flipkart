package com.flipkart.dao;

public interface CoursesDao {

	public void addCourse(int courseId, int userId);
	public void dropCourse(int courseId, int userId);
	public void viewGrades(int userId);
}
