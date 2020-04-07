package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects 
{
	public WebDriver driver;
	By log = By.cssSelector("a[href*='sign_in']");
	
	public HomePageObjects(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(log);
	}
}
