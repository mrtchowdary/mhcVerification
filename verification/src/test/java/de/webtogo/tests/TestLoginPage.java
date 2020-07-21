package de.webtogo.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.webtogo.base.Base;
import de.webtogo.pages.LoginPage;

public class TestLoginPage extends Base{
	
	LoginPage loginPage;
	
	public TestLoginPage(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		logger=report.createTest("Login - title verification");
		Reporter.log("verifying login page title",enableLogs);
		logger.info("verifying login page title");
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "IDA Login");
		Reporter.log("login page title verified successfully",enableLogs);
		logger.info("login page title verified successfully");
		report.flush();
	}
	
	@Test(priority=2)
	public void WtgLogoImageTest(){
		logger=report.createTest("Login - logo verification");
		Reporter.log("verifying WTG Logo on the login screen",enableLogs);
		logger.info("verifying WTG Logo on the login screen");
		Assert.assertTrue(loginPage.validateWTGImage());
		Reporter.log("WTG Logo verified successfully",enableLogs);
		logger.info("WTG Logo verified successfully");
		report.flush();
	}
	
//	@Test(priority=3, dataProvider="getDataFromLoginSheet", dataProviderClass=ReadExcelData.class)
//	public void loginTest(String Username, String Password){
//		logger=report.createTest("Login - login with valid credentials");
//		Reporter.log("Verifying IDA login with valid credentials",enableLogs);
//		logger.info("Verifying IDA login with valid credentials");
//		loginPage.Login(Username,Password);
//		Reporter.log("Login in to IDA is successful",enableLogs);
//		logger.info("Login in to IDA is successful");
//		report.flush();
//	}
	
}
