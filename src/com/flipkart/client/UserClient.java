// The user client class that is being menu driver by the client. Contains all the functionalities that student, professor or admin can perform.

package com.flipkart.client;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

import com.flipkart.java8.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Registration;
import com.flipkart.bean.User;
import com.flipkart.exception.UserException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

public class UserClient {

	private static Logger logger = Logger.getLogger(UserClient.class);

	public static void main(String args[]) {

		UserInterface userOpt = new UserOperation();

		logger.info(
				"\n\n-------------------------------------   WELCOME TO STUDENT REGISTRATION SYSTEM------------------------------------------\n");

		// Selecting from the options
		logger.info("1 Check Identity");
		

		while (true) {
			logger.info("Select an operation you want to do ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				String role = "";
				
					// Checking the credentials of the user i.e user name and password.
					User user = new User();
					String userName;
					String password;
					
					try {
						
						logger.info("Enter the userName");
					    userName = sc.nextLine();
						userName = sc.nextLine();
						user.setUserName(userName);

						logger.info("Enter your password");
						password = sc.nextLine();
						user.setPassword(password);
						user.setUserId(-1);
						role = userOpt.checkIdentity(user);
						
						logger.info(role);
					}
					
					catch (com.flipkart.exception.LoginException e) {
						// TODO Auto-generated catch block
						logger.error(e.getMessage());
					}

					// Initializing the time for login and it will be displayed during the login in
					// a proper format.
					Instant startTime = Instant.now();
					logger.info("Your login time");
					DateAndTime dateAndTime = new DateAndTime();
					dateAndTime.displayCurrentDateAndTime();

					// If the user is a student the following options would be available.

					if (role.equals("student")) {

						
						logger.info("===========================================================");
						logger.info("|         STUDENT MENU       	                        |");
						logger.info("===========================================================");
					    logger.info("|  1. Add Course              	                        |");
					    logger.info("|  2. Drop Course            	                        |");
					    logger.info("|  3. Pay Bill           	                        |");
					    logger.info("|  4. View Report Card                                   |");
					    logger.info("|  5. Request Catalog                                    |");
					    logger.info("|  6. Register User         	                        |");
					    logger.info("|  7. Log out              	                        |");
					    logger.info("|                          	                        |");
					    logger.info("===========================================================");

						while (true) {
							logger.info("Enter your choice");
							int choice2 = sc.nextInt();

							switch (choice2) {

							// Adding the courses.
							case 1:
								logger.info("Enter the course Id");
								int courseId = sc.nextInt();
								
								int userId = user.getUserId();

								StudentInterface studentOpt = new StudentOperation();
								studentOpt.addCourse(courseId, userId);
								logger.info(courseId + " successfully added for " + userId);
								break;

							// Dropping the courses.
							case 2:
								logger.info("Enter the course Id");
								courseId = sc.nextInt();
								
								userId = user.getUserId();
								studentOpt = new StudentOperation();
								studentOpt.dropCourse(courseId, userId);
								logger.info(courseId + " successfully dropped for " + userId);
								break;

							// Paying the final Bill.
							case 3:

								logger.info("These are your payment methods :-");
								logger.info("1 Cash");
								logger.info("2 Credit Card");
								logger.info("3 Debit Card");
								logger.info("4 Cheque");
								userId = user.getUserId();
								studentOpt = new StudentOperation();
								int payment = studentOpt.doPayment(userId);
								logger.info("You have to pay INR " + payment + " for all the courses.");
								break;

							// Viewing final grades in the report card
							case 4:
								
								userId = user.getUserId();
								studentOpt = new StudentOperation();
								Map<Integer, String> gradesList = studentOpt.viewGrades(userId);

								logger.info("####################################################################");
								logger.info("Here's your report card " + userId +"\n");
								logger.info("All the grades are listed here : \n");
							
								// Printing all the valid grades.
								
								for (Map.Entry m : gradesList.entrySet()) {
									String str = (String) m.getValue();
									if(str != null && !str.isEmpty())
									logger.info("In course " + m.getKey() + " you got grade " + m.getValue());
								}
								logger.info("####################################################################");

								break;

							// Requesting the catalog having all the courses.
							case 5:
								studentOpt = new StudentOperation();
								List<Course> catalog = studentOpt.requestCatalog();
								logger.info("####################################################################");
								logger.info("All the courses are listed here : \n");
								catalog.forEach(course -> logger.info(course.getCoursename() + "   "
										+ course.getCourseid() + "   " + course.getCourseDescription()));
								logger.info("####################################################################");
								break;

							

							// Doing the registration process.
							case 6:
								
								userId = user.getUserId();
								logger.info("Enter Registration Id");
								int registrationId = sc.nextInt();
								logger.info("Enter the payment Id");
								int paymentId = sc.nextInt();

								RegistrationInterface registrationOpt = new RegistrationOperation();
								registrationOpt.completeRegistration(userId, registrationId, paymentId);
								logger.info("Welcome to the University  " + userId);
								break;

							// Logging out
							case 7:
								Instant endTime = Instant.now();
								logger.info("Your logout time");
								dateAndTime = new DateAndTime();
								dateAndTime.displayCurrentDateAndTime();
								Duration duration = Duration.between(startTime, endTime);
								logger.info("Thank you !!");
								logger.info("Session Lasted for : " + duration.toMinutes() + " mins ");
								return;
							}
						}
					}

					// If the user is a professor the following options would be available.

					if (role.equals("professor")) {

						// All the options that are available to the professor.

						logger.info("======================================");
					    logger.info("|        PROFESSOR MENU              |");
					    logger.info("======================================");
					    logger.info("|  1. View Courses                   |");
					    logger.info("|  2. View All Courses               |");
					    logger.info("|  3. View Student Details           |");
					    logger.info("|  4. Record Grades                  |");
					    logger.info("|  5. Add Course to teach            |");
					    logger.info("|  6. Log out                        |");
					    logger.info("======================================");
					    
						while (true) {
							logger.info("Enter your choice");
							int choice2 = sc.nextInt();

							switch (choice2) {

							// Viewing all the courses a professor is teaching.
							case 1:
								// logger.info("Enter your userId");
								int userId = user.getUserId();
								logger.info("####################################################################");
								logger.info("Professor " + userId + " teaches following courses");
								ProfessorInterface professorOpt = new ProfessorOperation();
								List<Integer> profCourses = professorOpt.viewProfessorCourses(userId);

								for (Integer courses : profCourses) {
									logger.info(courses);
								}
								logger.info("####################################################################");
								break;

							// Viewing the whole catalog of courses to select a course from.
							case 2:
								professorOpt = new ProfessorOperation();
								List<Course> catalog = professorOpt.viewCourses();
								logger.info("####################################################################");
								logger.info("All the courses are listed here : \n");
								catalog.forEach(course -> logger.info(course.getCoursename() + "   "
										+ course.getCourseid() + "   " + course.getCourseDescription()));
								logger.info("####################################################################");
								break;


							// Viewing the students that are enrolled in a course taught by professor.
							case 3:
								
								userId = user.getUserId();
								professorOpt = new ProfessorOperation();

								Map<Integer, Integer> students = professorOpt.viewStudents(userId);

								logger.info("####################################################################");
								logger.info("All the students and courses are listed here : \n");
								for (Map.Entry m : students.entrySet()) {
									logger.info(m.getKey() + " " + m.getValue());
								}
								logger.info("####################################################################");
								break;

								
							// Submitting the final grades for the student along with the corresponding
							// course.
							case 4:
								
								userId = user.getUserId();

								logger.info("Enter the userId of student");
								int sUserId = sc.nextInt();
								logger.info("Enter the courseId");
								int courseId = sc.nextInt();
								logger.info("Enter the grade");
								String grade = sc.nextLine();
								grade = sc.nextLine();

								professorOpt = new ProfessorOperation();
								professorOpt.submitGrades(userId, sUserId, courseId, grade);
								logger.info("User "+ sUserId + " has been awarded "+ grade+ " in the course "+ courseId);
								break;

							// Selection of a course by professor.
							case 5:
								
								userId = user.getUserId();
								logger.info("Enter the courseId you want to teach");
								courseId = sc.nextInt();

								professorOpt = new ProfessorOperation();
								professorOpt.selectCourse(userId, courseId);
								logger.info("Congrats ! you are the new professor of " + courseId + " course.");
								break;
							
							// Logging out.
							case 6:
								Instant endTime = Instant.now();
								logger.info("Your logout time");
								dateAndTime = new DateAndTime();
								dateAndTime.displayCurrentDateAndTime();
								Duration duration = Duration.between(startTime, endTime);
								logger.info("Thank you !!");
								logger.info("Session Lasted for : " + duration.toMinutes() + " mins ");
								// logger.info("Session Lasted for : " + duration.toMinutes() + " mins "+
								// duration.toSeconds()+ " secs.");
								return;
							}
						}
					}

					// If the user is an admin the following options would be available.

					if (role.equals("admin")) {

						// Following functionalities are available with the admin.


						logger.info("============================");
					    logger.info("|        ADMIN MENU         |");
					    logger.info("============================");
					    logger.info("|  1. Add User              |");
					    logger.info("|  2. Delete User           |");
					    logger.info("|  3. Edit User             |");
					    logger.info("|  4. Add Course            |");
					    logger.info("|  5. Delete Course         |");
					    logger.info("|  6. Log Out               |");
					    logger.info("============================");
						AdminInterface adminOpt = new AdminOperation();

						while (true) {
							logger.info("Enter your choice");
							int choice2 = sc.nextInt();

							switch (choice2) {

							// Creating a new user(Professor/Student/Admin) in the system
							case 1:
								user = new User();
								logger.info("Enter the userId");
								int userId = sc.nextInt();
								user.setUserId(userId);

								logger.info("Enter the password");
								password = sc.nextLine();
								password = sc.nextLine();
								user.setPassword(password);

								logger.info("Enter the userName");
								userName = sc.nextLine();
								user.setUserName(userName);

								logger.info("Enter the role");
								role = sc.nextLine();
								user.setRole(role);

								logger.info("Enter the gender");
								String gender = sc.nextLine();
								user.setGender(gender);
								adminOpt.addUser(user);
								 logger.info(user.getUserName()+ " added");
								break;

							// Removing an existing user(Professor/Student/Admin) from the system
							case 2:
								logger.info("Enter the userId to delete");
								userId =  sc.nextInt();
								adminOpt.deleteUser(userId);
								 logger.info(user.getUserName()+ " deleted");
								break;

							// Updating user(Professor/Student/Admin) details in the system
							case 3:
								logger.info("Enter the userId to edit");
								userId = sc.nextInt();
								adminOpt.editUser(userId);
								break;

							// Creating a new course in the system .
							case 4:
								Course course = new Course();
								logger.info("Enter the coursename");
								String coursename = sc.nextLine();
								coursename = sc.nextLine();
								course.setCoursename(coursename);

								logger.info("Enter the courseid");
								int courseID = sc.nextInt();
								course.setCourseid(courseID);

								logger.info("Enter the Course Description");
								String courseDesc = sc.nextLine();
								courseDesc = sc.nextLine();
								course.setCourseDescription(courseDesc);

								logger.info("Enter the Course Payment");
								int coursePayment = sc.nextInt();
								course.setCoursePayment(coursePayment);
								adminOpt.addCourse(course);
								logger.info(coursename+ " added");
								break;

							// Removing an existing course from the system .
							case 5:
								logger.info("Enter the courseId to delete");
								int courseId = sc.nextInt();
								adminOpt.deleteCourse(courseId);
								logger.info(courseId+ " deleted");
								break;
							
							case 6:
								Instant endTime = Instant.now();
								logger.info("Your logout time");
								dateAndTime = new DateAndTime();
								dateAndTime.displayCurrentDateAndTime();
								Duration duration = Duration.between(startTime, endTime);
								logger.info("Thank you !!");
								logger.info("Session Lasted for : " + duration.toMinutes() + " mins ");
								return;
							}
						}
					}

			
			}

		}
	}
}


////Updating course details in the system
//case 6:
//	logger.info("Enter the courseId to edit");
//	courseId = sc.nextInt();
//	adminOpt.editCourse(courseId);
//	break;
//
//// Viewing all the users along with Mr/Mrs/Miss included before their names.
//	
//	
//case 7:
//	List<User> userList = adminOpt.viewAllStudents();
//
//	logger.info("##############################################################################");
//	logger.info("\n");
//	//String userList1 = userList.stream().flatMap(user2 -> Stream.of(user2.getGender().equals("male") ? "Mr.".concat(user2.getUserName()): "Miss.".concat(user2.getUserName()),user2.getPassword(), user2.getRole(), "\n")).collect(Collectors.joining(" "));
//	logger.info(userList);
//	logger.info("##############################################################################");
//	break;
