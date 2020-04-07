package FrGrp;

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
	public void Assertion() throws IOException
	{
		driver=InitializeDriver();
		AssertObjects ao = new AssertObjects(driver);
		AssertJUnit.assertTrue(ao.lookForContact().isDisplayed());
	}
}
