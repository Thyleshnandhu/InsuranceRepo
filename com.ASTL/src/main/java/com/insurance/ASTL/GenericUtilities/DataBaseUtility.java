package com.insurance.ASTL.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	/**
	 * this method is used to connect to database
	 * @throws Throwable 
	 */
public void connectToDB() throws Throwable
{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection(PathConstant.dbURL, PathConstant.dbUserName, PathConstant.dbPassWord);
	
}

/**
 * this method is used to excute quary
 * @throws Throwable 
 */
public String executeQuery(String query,int colno,String expData) throws Throwable
{
	ResultSet result=con.createStatement().executeQuery(query);
	boolean flag=true;
	while(result.next())
	{
		String data=result.getString(colno);
		if(data.equalsIgnoreCase(expData))
		{
			flag=false;
			break;
		}
	}
	if(flag==true)
	{
		System.out.println("---Data is verified---");
	}
	else
	{
		System.out.println("--Data is not verified--");
	}
	return "";
}


/**
 * this method will close the database
 * @throws Throwable 
 */

public void closeDatabase() throws Throwable
{
	con.close();
}
}

