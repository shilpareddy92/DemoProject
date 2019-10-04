package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

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
		
		Actions a= new Actions(driver);
		//1.double click to element/////////
		WebElement username =driver.findElement(By.id("email"));
		a.moveToElement(username)
		.sendKeys(Keys.ENTER)
		.keyDown(username, Keys.SHIFT)
		.sendKeys("name").keyUp(username, Keys.SHIFT).doubleClick().contextClick().build().perform();
		System.out.println(username.getCssValue("font-size"));
		username.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);

		System.out.println(username.getSize().getHeight());
		System.out.println(username.getSize().getWidth());
		
		
		System.out.println(username.getLocation().getX());
		System.out.println(username.getLocation().getY());
	}

}
