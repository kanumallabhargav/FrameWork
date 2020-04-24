package FrGrp;

import org.apache.logging.log4j.*;
import resources.Base;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import FrGrpJava.DBConnect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import resources.Base;

public class LoginPage extends Base
{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void loginPageAccess() throws IOException, InterruptedException, SQLException
	{	
		driver = InitializeDriver();
		log.info("Driver is initialized");	//LOG-----------------------------------------------------------------------------
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String databaseName=prop.getProperty("dbname");
		String SQLQuery = prop.getProperty("SQLQuery");
		String DBID = prop.getProperty("DBID");
		String DBPassword = prop.getProperty("DBPassword");
		String host = prop.getProperty("hostName");
		String portNumber = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+portNumber+"/"+databaseName, DBID, DBPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQLQuery);
		while (rs.next())
		{
			String uid = rs.getString("uid");
			String pwd = rs.getString("password");
			LoginPageObjects lo = new LoginPageObjects(driver);
			lo.loginEnter().sendKeys(uid);
			log.info("Username entered");	//LOG---------------------------------------------------------------------------------
			lo.passwordEnter().sendKeys(pwd);
			log.info("Password entered");	//LOG---------------------------------------------------------------------------------
			lo.submitClick().click();
			log.info("clicked on the submit button");	//LOG---------------------------------------------------------------------
		}
	}
	@AfterTest
	public void endSession() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		driver=null; //Optimization
	}
}