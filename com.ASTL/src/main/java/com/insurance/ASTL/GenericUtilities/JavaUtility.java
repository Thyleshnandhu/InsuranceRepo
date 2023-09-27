package com.insurance.ASTL.GenericUtilities;

import java.util.Date;
import java.util.Random;


public class JavaUtility 
{
	/**
	 * This method will generate random number
	 * @return
	 */
	public int getrandomNumber()
	{
		Random ran=new Random();
		int randnum=ran.nextInt(1000);
		return randnum;
	}
	/**
	 * This method will return system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date date=new Date();
		return date.toString();
	}
	/**
	 * This method will return date in particular format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date datetime=new Date();
		String[] d = datetime.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String date=d[2];
		String year=d[3];
		String finalformat=day+" "+month+" "+date+" "+year;
		return finalformat;
	}

}
