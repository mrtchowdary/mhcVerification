package de.webtogo.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import de.webtogo.util.BrowserFactory;
import de.webtogo.util.Helper;
import de.webtogo.util.ReadExcelData;
import de.webtogo.util.ReadPropertiesFile;

public class Base {
	public static boolean enableLogs;
	public static WebDriver driver;
	public static ReadExcelData excel;
	public static ReadPropertiesFile prop;
	public static ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetupSuite(){
		excel = new ReadExcelData();
		prop = new ReadPropertiesFile();
		enableLogs = prop.GetDataFromConfig("enablelogs").equals("true");
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./reports/verification_"+Helper.DateFormater()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void SetupMethod(){
		driver = new BrowserFactory().InitializeDriver(prop.GetDataFromConfig("browser"));
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException{
		String path;
		Helper helper = new Helper();
		if(result.getStatus() == ITestResult.SUCCESS){
			path = helper.takeScreenshot();
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}else if(result.getStatus() == ITestResult.FAILURE){
			path = helper.takeScreenshot();
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		driver.quit();
	}
	
	@AfterSuite
	public void tearDownSuite(){
		report.flush();
	}
}
