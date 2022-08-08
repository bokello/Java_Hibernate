package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

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
		
			Instructor tempInstructor = 
					new Instructor("Susan", "Kogalo", "susankogalo@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.youtube.com",
							"Playing Games");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
									
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
