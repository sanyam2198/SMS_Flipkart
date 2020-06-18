package com.flipkart.dao;

import java.util.List;
import java.util.Map;

public interface ProfessorCoursesDao {
   public List<Integer> viewProfessorCourses(int userId);
   public Map<Integer, Integer> viewStudents(int userId);
   public void selectCourse(int userId,int courseId);
}
