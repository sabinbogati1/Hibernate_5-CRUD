package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		try{
			
			int studentId = 1;
			
			System.out.println("Getting Student With id " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			//delete the Student
			System.out.println("Deleting The Student: "+ myStudent);
			session.delete(myStudent);
			
			//commit The Transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally{
			
			factory.close();
		}

	}

}
