package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		JavascriptExecutor Js = (JavascriptExecutor)driver;

		boolean isPageLoaded = Js.executeScript("return document.readyState").toString().equals("complete"); 

		if (isPageLoaded) {
			System.out.println("page was loaded completley");
		} else {
			System.out.println("page is not loaded completley");
			
		}
		
		driver.findElement(By.name("fileupload")).sendKeys("C:\\Users\\SDagadapally\\Downloads\\Resume.docx");
		driver.quit();

	}

}
