package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		boolean isPageLoaded = js.executeScript("return document.readyState").toString().equals("complete"); 

		if (isPageLoaded) {
			System.out.println("page was loaded completley");
		} else {
			System.out.println("page is not loaded completley");
		}

		System.out.println("Link Test is " + driver.findElement(By.linkText("Link Test")).isDisplayed());
		System.out.println(
				" Partial Link Test" + driver.findElement(By.partialLinkText("Partial Link Test")).isDisplayed());

		driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("aaa");
		;
		driver.findElement(By.name("lastname")).sendKeys("bbb");
		driver.findElement(By.id("sex-1")).click();

		driver.findElement(By.cssSelector("#exp-2")).click();
		System.out.println("Link Test is " + driver.findElement(By.cssSelector("#exp-2")).isSelected());
		driver.findElement(By.id("datepicker")).sendKeys("20/6/2019");
		driver.findElement(By.id("profession-1")).click();

		System.out.println(driver.findElement(By.id("profession-1")).isSelected());

		System.out.println(driver.findElements(By.tagName("a")).size());
		Select command_Dpd = new Select(driver.findElement(By.cssSelector("#selenium_commands")));
		command_Dpd.selectByVisibleText("Browser Commands");
		List<WebElement> list =  command_Dpd.getOptions();
		for(WebElement name : list)
		{
			System.out.println("name of commands"+name.getText());
		}

		driver.quit();
	
	}

}
