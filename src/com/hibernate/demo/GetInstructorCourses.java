package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class GetInstructorCourses {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try 
		{				
			// start a transaction
			session.beginTransaction();
		
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
						
			System.out.println("Instructor "+ tempInstructor);
			
			System.out.println("Course"+ tempInstructor.getCourses());
						
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
