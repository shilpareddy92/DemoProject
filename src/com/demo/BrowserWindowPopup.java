package com.demo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor Js = (JavascriptExecutor)driver;

		boolean isPageLoaded = Js.executeScript("return document.readyState").toString().equals("complete"); 

		if (isPageLoaded) {
			System.out.println("page was loaded completley");
		} else {
			System.out.println("page is not loaded completley");
			
		}
		
		driver.findElement(By.id("button1")).click();
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();
		
		Set<String> windows= driver.getWindowHandles();
		System.out.println("size " +windows.size());
		Iterator<String> iterator = windows.iterator();
		
		String window1 = iterator.next();
		System.out.println("window1 " +window1);
		driver.switchTo().window(window1);
		System.out.println("window1 " +driver.getTitle());
		driver.close();
		
		String window2 = iterator.next();
		System.out.println("window2 " +window2);
		driver.switchTo().window(window2);
		System.out.println("window2 " +driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Enroll Your Self']")).click();
		driver.findElement(By.name("your-name")).sendKeys("aaa");
		driver.findElement(By.name("your-email")).sendKeys("aaa.com");
		driver.close();
	
		
		
		String window3 = iterator.next();
		System.out.println("window3 " +window3);
		driver.switchTo().window(window3);
		System.out.println("window3 " +driver.getTitle());
		driver.close();
		
		
		String window4 = iterator.next();
		System.out.println("window4 " +window4);
		driver.switchTo().window(window4);
		System.out.println("window4 " +driver.getTitle());
		driver.quit();
		}
		
	

}
