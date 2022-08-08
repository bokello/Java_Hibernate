package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try 
		{
		
			System.out.println("Connect to database"+ jdbcUrl);
			
			Connection conn = 
					DriverManager.getConnection(jdbcUrl,user,pass);
			
			
			System.out.println("Connection succesful !!");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}
