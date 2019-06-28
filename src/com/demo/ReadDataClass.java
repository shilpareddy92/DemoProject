package com.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataClass {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream inputstream = new FileInputStream(
				"C:\\Users\\SDagadapally\\eclipse-workspace\\DemoProject\\src\\com\\demo\\config.properties");
		prop.load(inputstream);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));

	}

}
