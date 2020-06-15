package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface UserDao {
	
	public String checkIdentity(User user);
	public void registerUser(User user);
	public void addUser(User user);
	public void deleteUser(int userId);
	public void editUser(int userId);
	public void addCourse(Course course);
	public void deleteCourse(int courseId);
	public void editCourse(int courseId);
	public List <User> viewUsers();
}
