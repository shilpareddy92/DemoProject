package Patterns;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Testing {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
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
		driver.findElement(By.cssSelector("a[title='Log in to your customer account']")).click();
		driver.findElement(By.id("email")).sendKeys("jetblue@grr.la");
		driver.findElement(By.id("passwd")).sendKeys("jetblue");
		driver.findElement(By.cssSelector("#block_top_menu li:nth-of-type(3) [title='T-shirts']")).click();
		driver.findElement(By.cssSelector("[alt='Faded Short Sleeve T-shirts']")).click();
		WebElement element= driver.findElement(By.cssSelector(".fancybox-iframe"));
		
		
		driver.switchTo().frame(element);
		driver.findElement(By.cssSelector(".exclusive span")).click();
		driver.switchTo().defaultContent();
		
		
		WebElement Lable= driver.findElement(By.cssSelector("[class='layer_cart_product col-xs-12 col-md-6'] h2"));
		new WebDriverWait(driver,10000).until(ExpectedConditions.visibilityOf(Lable));
		
		driver.findElement(By.cssSelector("[class='layer_cart_product col-xs-12 col-md-6'] h2")).isDisplayed();
		
		String text = driver.findElement(By.cssSelector("#layer_cart_product_title")).getText();
		System.out.println(text);
		if(text.equals("Faded Short Sleeve T-shirts"))
		{
			System.out.println("valid");
		}
		
		
		 text = driver.findElement(By.cssSelector("#layer_cart_product_attributes")).getText();
		 System.out.println(text);
		 if(text.equals("Orange, S"))
			{
				System.out.println("valid");
			}
		 
		 if(text.equals("Orange, S"))
			{
				System.out.println();
			}
		 driver.findElement(By.cssSelector(".layer_cart_product_info div:nth-child(3) .dark")).isDisplayed();
		 driver.findElement(By.cssSelector(".layer_cart_product_info div:nth-child(4) .dark")).isDisplayed();
		 
		 driver.findElement(By.cssSelector("[title='Proceed to checkout'] span")).click();
		 
		 
		
		 
		 driver.findElement(By.cssSelector(".icon-trash")).click();
	
		
		driver.quit();
		
		
		
		
		
	}
		
		

	}

