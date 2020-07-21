package de.webtogo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import de.webtogo.base.Base;

public class BrowserFactory extends Base{

	public WebDriver InitializeDriver(String browser){
		if(browser.toLowerCase().equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver();
		}else if(browser.toLowerCase().equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.toLowerCase().equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.GetDataFromConfig("url"));
		return driver;
	}
}
