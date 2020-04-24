package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base 
{
	public static WebDriver driver;
	Properties prop = new Properties();
	public WebDriver InitializeDriver() throws IOException, InterruptedException
	{	
		//System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser");
		String url=prop.getProperty("url");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/BrowserDrivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/BrowserDrivers/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("HeadlessChrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/BrowserDrivers/chromedriver");
			ChromeOptions chromeOptionsObject =  new ChromeOptions();
			chromeOptionsObject.addArguments("headless");
			driver = new ChromeDriver(chromeOptionsObject);
		}
		else if (browserName.equals("HeadlessFirefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/BrowserDrivers/geckodriver");
			FirefoxOptions firefoxOptionsObject = new FirefoxOptions();
			firefoxOptionsObject.addArguments("headless");
			firefoxOptionsObject.setHeadless(true);
			driver = new FirefoxDriver(firefoxOptionsObject);
		}
		else if(browserName.equals("IE"))
		{
			//code for IE Browser.
		}
		Thread.sleep(2000);
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
	public static void getScreenshot(String scrnsht) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshots/"+scrnsht+"scrnsht.png"));
	}
	
}
