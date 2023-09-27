package com.insurance.ASTL.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	/**
	 * This file is used to fetch common data from property file.
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fin=new FileInputStream(PathConstant.propertyfilepath);
		Properties pro=new Properties();
		pro.load(fin);
		String result = pro.getProperty(key);
		return result;
	}

}
