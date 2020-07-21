package de.webtogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.webtogo.base.Base;

public class LoginPage extends Base{

		@FindBy(id="un")
		WebElement UserName;
		
		@FindBy(id="pw")
		WebElement Password;
		
		@FindBy(xpath="//input[@class='ib']")
		WebElement SignINButton;
		
		@FindBy(xpath="//div[@class='login_logo']")
		WebElement WTGLogo;
		
		@FindBy(id="checkbox_remember")
		WebElement LoginCheckbox;
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateWTGImage(){
			return WTGLogo.isDisplayed();
		}
		
		public MyPlatePage Login(String uname, String pword){
			UserName.sendKeys(uname);
			Password.sendKeys(pword);
			if(LoginCheckbox.isSelected()) LoginCheckbox.click();
			SignINButton.click();
			
			return new MyPlatePage();
		}
}