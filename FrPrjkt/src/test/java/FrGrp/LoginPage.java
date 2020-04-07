package FrGrp;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import resources.Base;

public class LoginPage extends Base
{
	@Test
	public void loginPageAccess() throws IOException, InterruptedException
	{
		driver = InitializeDriver();
		//driver.get("https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1");
		LoginPageObjects lo = new LoginPageObjects(driver);
		lo.loginEnter().sendKeys(id());
		lo.passwordEnter().sendKeys(pssd());
		lo.submitClick().click();
		Thread.sleep(2000);
		driver.quit();
	}
}
