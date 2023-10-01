package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String user = p.getProperty("username");
		String pw = p.getProperty("password");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(user);
		System.out.println(pw);
		
	}

}
