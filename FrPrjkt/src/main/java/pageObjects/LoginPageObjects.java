package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects 
{
	public WebDriver driver;
	By email = By.cssSelector("input#user_email");
	By pwd = By.cssSelector("input#user_password");
	By submit = By.xpath("//input[@type='submit']");
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
