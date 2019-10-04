package com.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor Js = (JavascriptExecutor) driver;

		boolean isPageLoaded = Js.executeScript("return document.readyState").toString().equals("complete");

		if (isPageLoaded) {
			System.out.println("page was loaded completley");
		} else {
			System.out.println("page is not loaded completley");

		}

		List<WebElement> links = driver.findElements(By.tagName("a"));

		List<WebElement> IMG = driver.findElements(By.tagName("img"));

		links.addAll(IMG);

		System.out.println("size of all links  " + links.size());
		List<WebElement> activelinks = new ArrayList<WebElement>();

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getAttribute("href") != null) {
				activelinks.add(links.get(i));
			}
		}
		System.out.println("size of active links " + activelinks.size());

		for (int j = 0; j < activelinks.size(); j++) {
			HttpURLConnection connection;
				try {
					 connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
					 connection.connect();
					 int responsecode= connection.getResponseCode();
					 connection.disconnect();
					 if(responsecode != 200)
					 {
						 System.out.println(activelinks.get(j).getAttribute("href")+"-----"+responsecode);
					 }
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			 
		}
		 System.out.println("done");

	}

}
