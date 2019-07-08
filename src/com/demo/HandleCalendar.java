package com.demo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendar {
	
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
	
	 driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']/following-sibling::button")).click();
	WebElement nextElement = driver.findElement(By.xpath("//span[text()='Next']"));
	WebElement previousLink = driver.findElement(By.xpath("//span[text()='Prev']")); 
	
	List<WebElement> months = driver.findElements(By.cssSelector(".ui-datepicker-month"));
	List<WebElement> years = driver.findElements(By.cssSelector(".ui-datepicker-year"));
	
	String date = "32-May-2017";
	String dateArr[] = date.split("-"); // {18,September,2017}
	String day = dateArr[0];
	String month = dateArr[1];
	String useryear = dateArr[2];
	boolean isyear=false;
	
	for(WebElement year :years)
	{
		if(year.getText().equals(useryear))
		{
			isyear =true;
		}
		else
		{
			nextElement.click();
			
		}
	}
	
	
	final int totalWeekDays = 7;
	
//	//2-1 2-2 2-3 2-4 2-5 2-6 2-7
//	//3-2 3-2 3-3 3-4 3-5 3-6 3-7
//	boolean flag = false;
//	String dayVal = null;
//	for(int rowNum=2; rowNum<=7; rowNum++){
//		
//		for(int colNum = 1; colNum<=totalWeekDays; colNum++){
//			try{
//		    dayVal =driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
//			}catch (NoSuchElementException e){
//				System.out.println("Please enter a correct date value");
//				flag = false;
//				break;
//			}
//			System.out.println(dayVal);
//			if(dayVal.equals(day)){
//				driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
//				flag = true;
//				break;
//			}				
//		}
//		if(flag){
//			break;
//		}
//		
//	}

	
}


	
	}

