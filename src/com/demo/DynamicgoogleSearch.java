package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicgoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
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
		driver.findElement(By.xpath("//input[@title ='Search']")).sendKeys("selenium");
		Thread.sleep(10000);
		List<WebElement> elements= driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class ='sbl1']/span"));
		for(int i=0;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			if(elements.get(i).getText().contains("selenium tutorial"))
			{
				elements.get(i).click();
				break;
			}
					
			
		
	}
	}

}
