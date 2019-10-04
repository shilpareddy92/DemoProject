package Patterns;

import org.openqa.selenium.WebDriver;

public  class test{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Library().getDriver("https://www.google.com/");
	}

}


class WebDriverUtil {

	
	WebDriver driver;
	public WebDriver getDriver()
	{
		return driver;
		
	}
}


 

 class Library {
	
	 WebDriver driver;
	 public WebDriver getDriver(String url)
	 {
		 new WebDriverUtil().getDriver().get("https://www.google.com/");
		return driver;
	 }
}

 