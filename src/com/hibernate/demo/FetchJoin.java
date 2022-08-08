package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class FetchJoin {

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
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ " JOIN FETCH i.courses "
			 				+ " where i.id=: theInstructorId"
							,Instructor.class);
			
			query.setParameter("theInstructorId", theId);
			
			// execute the query
			Instructor tempInstructor  = query.getSingleResult();
			
			System.out.println("Instructor "+ tempInstructor);
		
			System.out.println("Instructor Courses "+ tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		
	}

}
