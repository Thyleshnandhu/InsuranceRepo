package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class TableCreationTest {
    public static void main(String[] args) throws Throwable {
        Connection con = null;
        try {
           
            // Register the MySQL JDBC driver (com.mysql.cj.jdbc.Driver)
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            // Get a connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");

            // Create an SQL query for insertion
           Statement state=con.createStatement();
           String query="Select * from tyss;";
           ResultSet result = state.executeQuery(query);
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter the name: ");
           String name = sc.nextLine();
         int countId=0;
         boolean flag=false;
         while(result.next()) {
        	 String actual=result.getString(2);
        	 String id=result.getString(1);
         
         if(actual.equalsIgnoreCase(name)) {
        	 flag=true;}}
        	 
         if(flag==true) {
        	 System.out.println("name is alreay exixts");
         }
         else {
        	 String query1="insert into tyss values("+ countId +","+name+");";
        	 int res=state.executeUpdate(query1);
        	 System.out.println("data added successfully");
         }
        }
        catch (Exception e) {
        	
        }
        finally {
        	con.close();
        }
        }}

