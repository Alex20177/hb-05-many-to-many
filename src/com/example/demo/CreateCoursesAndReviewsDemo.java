package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;
import com.example.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {	
			
			//Start a transaction
			session.beginTransaction();
			
			//Creating a new course
			Course tempCourse = new Course("Mastering in JAVA");
			tempCourse.addReview(new Review("Excelente course"));
			tempCourse.addReview(new Review("Annoying course"));
			tempCourse.addReview(new Review("It is a dum course"));	
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}//Close try. 
		
		finally {
			session.close();
			factory.close();
		}//Close finally. 
		
	}//Close main method.

}//Close CreateStudenDemo class.
