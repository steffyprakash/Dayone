package com.basefunction;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class BaseClass
{
public static WebDriver driver; 
	
	//Browser launch `
	public static void browserLaunch(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
     	driver.manage().window().maximize();
	}
	
	//Webpage launch
	 public static void webpageLaunch(String url)
	 {
		 driver.get(url);
	 }
	//find element(locator)-login
	  public static void clickElements(WebElement element1)
	  { 
		  element1.click(); 
	  }
	  public static void enterkeys(WebElement element,String value) 
	  {
		  element.sendKeys(value);
	  }    
		

	  //Screenshots
	  public static void screenshot(String path,String filename) throws IOException 
	  {
	    TakesScreenshot ts=(TakesScreenshot)driver;
		File from=ts.getScreenshotAs(OutputType.FILE);
		File to=new File(path +"\\" + filename + ".png");
		Files.copy(from, to);
	  }
	public static void  sendKeys(WebElement element,String name)
	{
		element.sendKeys(name);
	}
}





