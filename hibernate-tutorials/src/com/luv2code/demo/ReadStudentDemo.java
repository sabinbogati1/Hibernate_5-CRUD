package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try{
			
			Student tempStudent= new Student("Donald","Trump","donald@gmail.com");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			System.out.println("Geeting Student id...");
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
			
			session = factory.getCurrentSession();
			
			 session.beginTransaction();
			 
			 Student myStudent= session.get(Student.class, tempStudent.getId());
			
			 System.out.println("Get Complete:" + myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
			
		}
		finally{
			
			factory.close();
		}

	}
		
		

	}


