package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Student;

public class StudentDemo1 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try{
			
			System.out.println("Creating new Student object...");
			Student tempStudent= new Student("Sameer","Bogati","Sameer@gmail.com");
			Student tempStudent2= new Student("santosh","shrestha","santosh@gmail.com");
			Student tempStudent3= new Student("Amir","Kapri","Amir@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving The Student");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally{
			
			factory.close();
		}

	}
	}


