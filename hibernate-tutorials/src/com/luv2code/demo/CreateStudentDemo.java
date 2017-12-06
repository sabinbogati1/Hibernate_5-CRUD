package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try{
			
			System.out.println("Creating new Student object...");
			Student tempStudent= new Student("Sabin","Bogati","sabin@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving The Student");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally{
			
			factory.close();
		}

	}

}
