package com.luv2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.Entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try{
			
			//start a transaction
			session.beginTransaction();
			
			//query the students
			
			List<Student> theStudents= session.createQuery("from Student").list();
			
			
			for(Student tempStudent: theStudents){
				System.out.println(tempStudent);
			}
			
			
			
			//query Students: lastName='Bogati'
			
			theStudents= session.createQuery("from Student s where s.lastName='Bogati'").list();
			
			for(Student tempStudent: theStudents){
				System.out.println(tempStudent);
			}
			
			session.getTransaction().commit();
			
		}
		finally{
			
			factory.close();
		}

	}

}
