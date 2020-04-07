package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public WebDriver driver;
	Properties prop = new Properties();
	public WebDriver InitializeDriver() throws IOException
	{	
		
		FileInputStream fis = new FileInputStream("/Users/bhargavkanmalla/FrPrjkt/src/main/java/resources/Data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "/Users/bhargavkanmalla/Documents/selenium-java-3.141.59/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/bhargavkanmalla/Documents/selenium-java-3.141.59/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("IE"))
		{
			//code for IE Browser.
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	public String id()
	{
		String emailid = prop.getProperty("username");
		return emailid;
	}
	public String pssd()
	{
	    String password = prop.getProperty("password");
		return password;
	}
}
