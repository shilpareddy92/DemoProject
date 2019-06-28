package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
WebDriver driver =  new ChromeDriver();
driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
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

driver.findElement(By.name("proceed")).click();
Alert UserNameAlert = driver.switchTo().alert();

System.out.println(UserNameAlert.getText());

UserNameAlert.accept();
driver.quit();
	}

}
