package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptActivities {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.facebook.com/");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				isPageLaoded();
				getTitle();
				getInnerText();
				EnterText();
				flash(driver.findElement(By.id("u_0_a")),"rgb(200,0,0)");
				drawborder(driver.findElement(By.id("u_0_a")));
				refreshBrowserByJS(driver);
				
				
				
				WebElement groups = driver.findElement(By.xpath("//a[text()='Sign Up']"));
				
				
				
				
				scrollPageDown(driver);
				clickElementByJS(driver.findElement(By.id("u_0_a")), driver);
				
				
				generateAlert(driver, "There is an issue with Login button on Login Page");
				Alert a= driver.switchTo().alert();
				a.accept();
				Thread.sleep(10000);
				isPageLaoded();
				scrollIntoView(groups, driver);
				
				
				
			
	}
	
	public static  void isPageLaoded()
	{
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		boolean isPageLoaded = Js.executeScript("return document.readyState").toString().equals("complete");
		if (isPageLoaded) {
			System.out.println("page was loaded completley");
		} else {
			System.out.println("page is not loaded completley");
			
		}
	}
	
	public static void  getInnerText()
	{
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		String innertext= Js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println("Inner text of the page"+innertext);
	} 
	
	public static void  getTitle()
	{
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		String title= Js.executeScript("return document.title;").toString();
		System.out.println("Title of the page "+title);
	} 
	
	

	public static void  EnterText()
	{
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("document.getElementById('email').value='admin@testmail.com'");
	}
	
	
	public static void changeColor(WebElement element,String color)
	{
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
	}
	
	public static void flash(WebElement element,String color)
	{
		
		String bgcolor  = element.getCssValue("backgroundColor");
		for (int i = 0; i <  10; i++) {
            changeColor( element,"rgb(0,200,0)");//1
            changeColor( element,bgcolor);//2
        }
	}
	
	public static void drawborder(WebElement element)
	{
		
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].style.border = '3px solid red'",element);
	}
	
	public static void generateAlert(WebDriver driver, String message){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("alert('"+message+"')");

    }
    
    public static void clickElementByJS(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);
    	
    }
	
    public static void refreshBrowserByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
    
    public static void scrollPageDown(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
}
