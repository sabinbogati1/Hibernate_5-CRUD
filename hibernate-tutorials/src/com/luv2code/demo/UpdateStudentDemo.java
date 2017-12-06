package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		try{
			
			int studentId = 1;
			
			System.out.println("Saved Student Generated id " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student.....");
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			
			
			//New Code
			
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			//Update Email For All students
			System.out.println("Update Email For All The Students");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//Commit The Transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			
			
			
			
			
			
			
			
			
			
		}
		finally{
			
			factory.close();
		}

	}

}
