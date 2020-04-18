package FrGrp;

import org.apache.logging.log4j.*;
import resources.Base;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import resources.Base;

public class LoginPage extends Base
{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void loginPageAccess() throws IOException, InterruptedException
	{
		driver = InitializeDriver();
		log.info("Driver is initialized");
		LoginPageObjects lo = new LoginPageObjects(driver);
		lo.loginEnter().sendKeys(id());
		log.info("Username entered");
		lo.passwordEnter().sendKeys(pssd());
		log.info("Password entered");
		lo.submitClick().click();
		log.info("clicked on the submit button");
		Thread.sleep(2000);
		driver.quit();
	}
	@AfterTest
	public void endSession() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		driver=null; //Optimization
	}
}
