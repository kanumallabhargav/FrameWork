package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertObjects
{
	public WebDriver driver;
	private By contactObject = By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[8]/a");
	public AssertObjects(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement lookForContact()
	{
		return driver.findElement(contactObject);
	}
}
