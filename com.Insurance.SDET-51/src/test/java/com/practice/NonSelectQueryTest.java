package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		try {
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ isurance", "root", "root");
		
		Statement state=con.createStatement();
		
		String query=" insert into project values('Thyleshwari','insurance',1),('nandhu','insurance',1),('prasad','insurance',1);";
		
		 result = state.executeUpdate(query);
	}
	catch(Exception e) {
		
	}
	finally {
		if(result>0) {
			System.out.println("data is created");
			
		}
		else {
			System.out.println("Data is not created");
		}
		con.close();
	}

}}
