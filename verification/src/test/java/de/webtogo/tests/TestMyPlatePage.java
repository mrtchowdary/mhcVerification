package de.webtogo.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.webtogo.base.Base;
import de.webtogo.pages.LoginPage;
import de.webtogo.pages.MyPlatePage;

public class TestMyPlatePage extends Base{

	LoginPage loginpage;
	MyPlatePage myplate;
	
	public TestMyPlatePage(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		loginpage = new LoginPage();
		myplate = loginpage.Login(prop.GetDataFromConfig("username"),prop.GetDataFromConfig("password"));
	}
	
	@Test(priority=1)
	public void VerifyTitle(){
		logger=report.createTest("MyPlate - logo verification");
		Reporter.log("Verifying MyPlate page title",enableLogs);
		logger.info("Verifying MyPlate page title");
		Assert.assertEquals(myplate.getPageTitle(), "IDA", "Page title not matched");
		Reporter.log("MyPlate page title verified successfully",enableLogs);
		logger.info("MyPlate page title verified successfully");
		report.flush();
	}
	
//	@Test(priority=2)
//	public void VerifyUserName(){
//		logger=report.createTest("MyPlate - username verification");
//		Reporter.log("Verifying username in MyPlate",enableLogs);
//		logger.info("Verifying username in MyPlate");
//		Assert.assertTrue(myplate.verifyUsername().equals(prop.GetDataFromConfig("username")),"User name not matched");
//		Reporter.log("Username verified successfully",enableLogs);
//		logger.info("Username verified successfully");
//		report.flush();
//	}
//	
//	@Test(priority=3, dataProvider="getDataFromInfoSheet", dataProviderClass=ReadExcelData.class)
//	public void OpenUser(String AccountID, String UniqueID){
//		logger=report.createTest("MyPlate - Open user account");
//		Reporter.log("Open support user and then open user account",enableLogs);
//		logger.info("Open support user and then open user account");
//		myplate.myPlate(prop.GetDataFromConfig("searchitem"), (long)Double.parseDouble(AccountID));
//		Reporter.log("User account opened successfuly",enableLogs);
//		logger.info("User account opened successfuly");
//		report.flush();
//	}
	
}
