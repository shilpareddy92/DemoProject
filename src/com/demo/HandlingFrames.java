package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.toolsqa.com/iframe-practice-page/");
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
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		for(WebElement element  : iframes)
		{
			System.out.println(element.getAttribute("id"));
		}
		driver.switchTo().frame("IF2");
		driver.findElement(By.xpath("//span[text()='Automation Tools Tutorial']")).isDisplayed();
		
		driver.switchTo().defaultContent();
		driver.quit();

	}

}
