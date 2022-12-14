package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class DeleteDemo {

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
		
			// get instructor by Id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor"+ tempInstructor);
			
			// delete the instructor
			if(tempInstructor != null)
			{
				// will also delete the detail object due to cascade type ALL
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
