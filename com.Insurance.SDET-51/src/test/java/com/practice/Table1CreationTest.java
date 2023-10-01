package com.practice;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Table1CreationTest
{

	
	private static Scanner sc;

	public static void insertData(int id, String name) 
	{
		Connection con=null;
		try 
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		        String input = "INSERT INTO tyss VALUES(?, ?);";
		        String duplicate="SELECT COUNT(*) FROM tyss WHERE name=?;";
		        PreparedStatement preparedStatement = con.prepareStatement(input);
		        PreparedStatement preparedStatementDuplicate = con.prepareStatement(duplicate);
		        preparedStatementDuplicate.setString(1, name);
		        ResultSet count = preparedStatementDuplicate.executeQuery();
		        count.next();
		        int result = count.getInt(1);
		        if(result==0)
		        {

		        preparedStatement.setInt(1, id);
		        preparedStatement.setString(2, name);
		        
		        

		        int rowsAffected = preparedStatement.executeUpdate();
		        if (rowsAffected > 0) 
		        {
		            System.out.println("Data inserted successfully.");
		        } 
		        else 
		        {
		            System.out.println("Failed to insert data.");
		        }
		        }
		        else
		        {
		        	System.out.println("Duplicate data");
		        }

		        preparedStatement.close();
		        con.close();
		    } 
		catch (SQLException e) 
		{
		        e.printStackTrace();
		}
	}
	
public static void main(String[] args) throws Throwable 
{
	sc = new Scanner(System.in);
	System.out.println("Enter the ID ");
	int eid=sc.nextInt();
	System.out.println("Enter the name ");
	String ename=sc.next();
	insertData(eid,ename);
}
}

