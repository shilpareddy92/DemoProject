package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
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
		
		Actions a= new Actions(driver);
		
		//1.move to element/////////
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Add-Ons']"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Indian Armed Forces Personnel']")).click();
		
		//2.right click to element/////////
		//a.moveToElement(driver.findElement(By.xpath("//a[text()='SpiceClub']"))).contextClick().build().perform();
		a.contextClick(driver.findElement(By.xpath("//a[text()='SpiceClub']"))).build().perform();
		driver.quit();
		
		

	
	}

}
