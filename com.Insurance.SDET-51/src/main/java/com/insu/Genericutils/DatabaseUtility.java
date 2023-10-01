package com.insu.Genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
     Connection con=null;
     /**
      * This method is used to connect database
      * @throws Throwable
      */
     public void connectToDB() throws Throwable {
    	 Driver driver= new Driver();
    	 DriverManager.registerDriver(driver);
    	 con = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUsername, IpathConstants.dbPassword);
    	 
     }
     /**
      * This method used to execute query and get the data
      * @param query
      * @param columnNo
      * @param ExpData
      * @return
      * @throws Throwable
      */
     public String executeQueryAndGetData(String query, int columnNo, String ExpData) throws Throwable {
    	  ResultSet result = con.createStatement().executeQuery(query);
    	 boolean flag=false;
    	 while(result.next()) {
    		 String data=result.getString(columnNo);
    		 if(data.equalsIgnoreCase(ExpData)) {
    			 flag=true;
    			 break;
    		 }
    	 }
    	 if(flag==true) {
    		 System.out.println("--Data is verified");
    		 return ExpData;
    	 }
    	 else {
    		 System.out.println("--Data is not present");
    		 return "";
    	 }
    	     }
     /**
      * This method is used to close database connection
      * @throws Throwable
      */
     public void closeDB() throws Throwable {
    	 con.close();
     }
     
}
