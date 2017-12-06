package com.luv2code.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		
		
		String jdbcUrl= "jdbc:mysql://localhost:3306/hb_student_tracker";
		String username= "root";
		String password="";
		
		
		try{
			
			System.out.println("Connecting to database" + jdbcUrl);
			
			
			Connection myConn= (Connection) DriverManager.getConnection(jdbcUrl,username,password);
			
			System.out.println("Connection SuccessFull");
			
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		

	}

}
