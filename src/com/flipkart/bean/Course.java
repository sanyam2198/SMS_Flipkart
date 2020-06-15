// Bean class of courses. Defines the courses parameters.

package com.flipkart.bean;

public class Course {
	
	String coursename;
	int courseid;
	String courseDescription;
	/**
	 * @return the coursename
	 */
	public String getCoursename() {
		return coursename;
	}
	/**
	 * @param coursename the coursename to set
	 */
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	/**
	 * @return the courseid
	 */
	public int getCourseid() {
		return courseid;
	}
	/**
	 * @param courseid the courseid to set
	 */
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}
	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

}
