package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
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
/////1.Dynamic IDs--contains can be used
		System.out.println("Link Test is " + driver.findElement(By.xpath("//input[contains(@id ,'emai')]")).isDisplayed());
	
	
	/////2.Dynamic IDs--Starts with can be used
			System.out.println("Link Test is " + driver.findElement(By.xpath("//input[starts-with(@id ,'emai')]")).isDisplayed());
			
			
			
		/////3.Dynamic IDs--links
			
			List<WebElement> links = driver.findElements(By.tagName("a"));	
			System.out.println("links are "+links.size());
			for(WebElement link :links)
			{
				System.out.println(link.getText());
			}
	
	}

}
