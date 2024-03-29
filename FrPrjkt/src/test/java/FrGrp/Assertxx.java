package FrGrp;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AssertObjects;
import resources.Base;

public class Assertxx extends Base
{
	@Test
	public void Assertion() throws IOException, InterruptedException
	{
		driver=InitializeDriver();
		AssertObjects ao = new AssertObjects(driver);
		AssertJUnit.assertTrue(ao.lookForContact().isDisplayed());
	}
	@AfterTest
	public void endSession() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		driver=null;
	}
}
