package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SelectQueryTest {
           public static void main(String[] args) throws SQLException {
        	   Connection con=null;
        	   try {
        	   Driver driver=new Driver();
        	   //step1: register the database
        	   DriverManager.registerDriver(driver);
        	   //step2: get connection for the database
        	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ isurance", "root", "root");
        	   //step3: create statement
        	   Statement state =con.createStatement();
        	   String query="select * from project;";
        	   //step4: Execute query
        	  ResultSet result = state.executeQuery(query);
        	  while(result.next()) {
        		  System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
        	  }
		}
          
           catch(Exception e) {
        	   
           }
           finally {
        	   con.close();
           }
}}
