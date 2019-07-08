package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
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
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		List<WebElement> elemnts= driver.findElements(By.xpath("//button[@id= 'dropdownMenuButton']/following-sibling::div//a"));
		System.out.println(elemnts.size());
		
		for(int i =0 ;i<elemnts.size() ;i++)
		{
			String name= elemnts.get(i).getText();
			System.out.println(name);
			if(name.equals("Action"))
			{
				elemnts.get(i).click();
			}
				}
	}

}
