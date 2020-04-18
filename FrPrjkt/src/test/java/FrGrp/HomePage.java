package FrGrp;

import org.testng.annotations.AfterTest;
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
		ho.getLogin().click();
	}
	@AfterTest
	public void endSession() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		driver=null;
	}
}
