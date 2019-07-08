package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://ui.freecrm.com");
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
		driver.findElement(By.name("email")).sendKeys("dshilpareddy92@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Shilpa!23");
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		Thread.sleep(10000);
		
		String Beforexpath ="//table[@class ='ui celled sortable striped table custom-grid']/tbody/tr[";
							//table[@class ='ui celled sortable striped table custom-grid']/tbody/tr[2]/td//input
		String afterxpath ="]/td[2]";
		
		List<WebElement> coloums = driver.findElements(By.xpath("//table[@class ='ui celled sortable striped table custom-grid']/thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class ='ui celled sortable striped table custom-grid']/tbody/tr/td[1]"));
		
		System.out.println("colomns  "+coloums.size());
		System.out.println("rows  "+rows.size());
		
		for(int i =1 ;i<=rows.size() ;i++)
		{
			String name= driver.findElement(By.xpath(Beforexpath+i+afterxpath)).getText();
			System.out.println(name);
			if(name.contains("achyutha charan"))
			{
				WebElement element = driver.findElement(By.xpath(Beforexpath+i+"]/td[1]/div/input[@name='id']"));
				JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("arguments[0].click();", element);
			}
				}
//		
		
		WebElement element = driver.findElement(By.xpath("//td[text()='achyutha  charan']/preceding-sibling::td/child::div//input"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);
		

	}
	
}
