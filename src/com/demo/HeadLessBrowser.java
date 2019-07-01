package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//////NOT SUITABLE FOR MOUSEMOVEMENT//////////////
//////////HEADLESS AND GHOST DRIVER/////////////
/////////VERT FAST////

public class HeadLessBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.findElement(By.name("email")).sendKeys("shilpa");
		driver.findElement(By.name("pass")).sendKeys("reddy");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

	}

}
