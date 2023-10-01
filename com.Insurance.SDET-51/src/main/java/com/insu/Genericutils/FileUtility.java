package com.insu.Genericutils;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to fetch common data present inside the property file 
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	

}
