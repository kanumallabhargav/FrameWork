package FrGrp;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import resources.Base;

public class HomePage extends Base 
{
	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
		driver = InitializeDriver();
		HomePageObjects ho = new HomePageObjects(driver);
		//driver.get("http://www.qaclickacademy.com/");
		ho.getLogin().click();
		Thread.sleep(2000);
		driver.quit();
	}
}
