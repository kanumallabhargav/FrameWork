package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects 
{
	public WebDriver driver;
	private By email = By.cssSelector("input#user_email");
	private By pwd = By.cssSelector("input#user_password");
	private By submit = By.xpath("//input[@type='submit']");
	public LoginPageObjects(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement loginEnter()
	{
		return driver.findElement(email);
	}
	public WebElement passwordEnter()
	{
		return driver.findElement(pwd);
	}
	public WebElement submitClick()
	{
		return driver.findElement(submit);
	}
}
