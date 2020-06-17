// Interface class for Professor operations.

package com.flipkart.service;

import java.util.List;
import java.util.Map;

import com.flipkart.bean.Course;

public interface ProfessorInterface {
	
	public List<Integer> viewProfessorCourses(int userId);
	public void submitGrades(int pUserId, int sUserId, int courseId, String grade);
	public List<Course> viewCourses();
	public Map<Integer, Integer> viewStudents(int userId);
}
