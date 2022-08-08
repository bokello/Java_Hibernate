package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try 
		{				
			// start a transaction
			session.beginTransaction();
		
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.youtube.com",
							"Coding Spring Hibernate");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
									
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
