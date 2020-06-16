// The user client class that is being menu driver by the client. Contains all the functionalities that student, professor or admin can perform.

package com.flipkart.client;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.java8.*;
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
		
		// Selecting from the options 
		logger.info("1 Check Identity");

		while(true) 
		{
			logger.info("Select an operation you want to do ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				String role="";
				try {
					// Checking the credentials of the user i.e user name and password.
					
					 User user = new User();
					 role= userOpt.checkIdentity(user);
					 logger.info(role);
					 
					 // Initializing the time for login and it will be displayed during the login in a proper format.
					 Instant startTime = Instant.now();
					 logger.info("Your login time");
					 DateAndTime dateAndTime = new DateAndTime();
					 dateAndTime.displayCurrentDateAndTime();
					 
					 // If the user is a student the following options would be available.
					 
					 if(role.equals("student")) {
						 logger.info("\n 1 Add Course\n 2 Drop Course\n 3 Pay Bill\n 4 View Report Card\n 5 Request Catalog \n 6 Register User \n 7 Log Out");
					 
					 while(true) {
						 logger.info("Enter your choice");
						 int choice2 = sc.nextInt();
						 
						 switch(choice2) {
						 case 1:
							 StudentInterface studentOpt = new StudentOperation();
							 studentOpt.addCourse();
							 break;
							 
						 case 2:
							 studentOpt = new StudentOperation();
							 studentOpt.dropCourse();
							 break;
							 
						 case 3:
							 studentOpt = new StudentOperation();
							 studentOpt.doPayment();
							 break;
							 
						 case 4:
							 logger.info("Enter your userId");
							 int userId = sc.nextInt();
							 studentOpt = new StudentOperation();
							 studentOpt.viewGrades(userId);
							 break;
							 
						 case 5:
						      studentOpt = new StudentOperation();
						      String courseCatalog = studentOpt.requestCatalog();
						      logger.info(courseCatalog);
						      break;
						
						 case 6:
							logger.info("Enter the userId to be registered");
							userId = sc.nextInt();
							RegistrationInterface registrationOpt = new RegistrationOperation();
							registrationOpt.completeRegistration(userId);
							break;
						
						 case 7:
							 Instant endTime = Instant.now();
							 logger.info("Your logout time");
							 dateAndTime = new DateAndTime();
							 dateAndTime.displayCurrentDateAndTime();
							 Duration duration = Duration.between(startTime, endTime);
							 logger.info("Session Lasted for : " + duration.toMinutes() +  " mins "+ duration.toSeconds()+ " secs.");
							 break;
						 }
					 }
					 }
					 
					// If the user is a professor the following options would be available.
					 
					 if(role.equals("professor")) {
						 logger.info("\n1 View My Courses\n2 View Course Catlaog\n 3 View Student Details\n 4 Record Grades\n");
					 
					 while(true) {
						 logger.info("Enter your choice");
						 int choice2 = sc.nextInt();
						 
						 switch(choice2) {
						 case 1:
							 logger.info("Enter your userId");
							 int userId = sc.nextInt();
							 ProfessorInterface professorOpt = new ProfessorOperation();
							 professorOpt.viewProfessorCourses(userId);
							 break;
						 case 2:
							 professorOpt = new ProfessorOperation();
							 professorOpt.viewCourses();
							 break;
						 case 3:
							 logger.info("Enter your userId");
							 userId = sc.nextInt();
							 professorOpt = new ProfessorOperation();
							 professorOpt.viewStudents(userId);
							 break;
						 case 4:
							 logger.info("Enter your userId");
							 userId = sc.nextInt();
							 professorOpt = new ProfessorOperation();
							 professorOpt.submitGrades(userId);
							 break;
						 }
					 }
					 }
					 
					// If the user is an admin the following options would be available.
					 
					 if(role.equals("admin")) {
						 logger.info("\n 1 Add user\n 2 Delete User\n 3 Edit/Update User\n 4 Add Course\n 5 Delete Course\n 6  Edit/Update Course \n 7 View All Students ");
					 
						 AdminInterface adminOpt = new AdminOperation();
						 
					 while(true) {
						 logger.info("Enter your choice");
						 int choice2 = sc.nextInt();
						 
						 switch(choice2) {
						 case 1:
							 adminOpt.addUser();
							 break;
							 
						 case 2:
							 logger.info("Enter the userId to delete");
							 int userId=sc.nextInt();
							 adminOpt.deleteUser(userId);
							 break;
							 
						 case 3:
							 logger.info("Enter the userId to edit");
							  userId=sc.nextInt();
							 adminOpt.editUser(userId);
							 break;
							 
						 case 4:
							 adminOpt.addCourse();
							 break;
							 
						 case 5:
							 logger.info("Enter the courseId to delete");
							 int courseId=sc.nextInt();
							 adminOpt.deleteCourse(courseId);
							 break;
							 
						 case 6:
							 logger.info("Enter the courseId to edit");
							 courseId=sc.nextInt();
							 adminOpt.editCourse(courseId);
							 break;
						 case 7:
							 adminOpt.viewAllStudents();
							 break;
						 }
					 }
					 }
					 
					
					 
					 
				}
				catch(Exception e) {
					//logger.error(e.viewLog());
					e.printStackTrace();
				}
			break;
			
			// Registering a new user here. 
//			case 2:
//				try {
//					logger.info("Enter the userId to be registered");
//					int userId = sc.nextInt();
//					RegistrationInterface registrationOpt = new RegistrationOperation();
//					registrationOpt.completeRegistration(userId);
//				}
//				catch(Exception e) {
//					//logger.error(e.viewLog());
//					e.printStackTrace();
//				}
//				break;
//				
//			default:
//				break;
			
		}
		
	}
}
}
