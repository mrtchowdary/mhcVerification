package de.webtogo.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.webtogo.base.Base;

public class MyPlatePage extends Base{

	@FindBy(id="modal1")
	WebElement modalDailog;
	
	@FindBy(xpath="//div[@class='modal-footer']//a[@href='#!']")
	WebElement modalDialogOKButton;
	
	@FindBy(xpath="//form[@name='ms']//input[@name='objectSearch']")
	WebElement SearchBar;
	
	@FindBy(xpath="//div[@id='gms']")
	WebElement SearchItem;
	
	@FindBy(xpath="//div[@class='mainMenu']//input[@id='mqs']")
	WebElement EnterAccountID;
	
	@FindBy(xpath="//li[@class='user']//a//img")
	WebElement GetUsername;
	
	@FindBy(id="locList")
	WebElement ClickOnUser;
	
	public MyPlatePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public String verifyUsername(){
		return GetUsername.getAttribute("alt");
	}
	
	public void closeModalDialog(){
		try{
		if(modalDailog.isDisplayed())
			modalDialogOKButton.click();
		}catch(NoSuchElementException e){
			System.out.println("Modal dialog not present");
		}
	}
	
	public void EnterSearchItem(String supportUser){
		SearchBar.sendKeys(supportUser);
	}
	
	public void ClickSearchItem(){
		SearchItem.click();
	}
	
	public void enterAccountID(long accID){
		EnterAccountID.sendKeys("#"+String.valueOf(accID));
	}
	
	public void clickOnAccountID(){
		ClickOnUser.click();
	}
	
	public void myPlate(String SupportUser, long AccountID){
		closeModalDialog();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(SearchBar));
			EnterSearchItem(SupportUser);
			wait.until(ExpectedConditions.visibilityOf(SearchItem));
			ClickSearchItem();
			wait.until(ExpectedConditions.visibilityOf(EnterAccountID));
			enterAccountID(AccountID);
			wait.until(ExpectedConditions.visibilityOf(ClickOnUser));
			clickOnAccountID();
			Thread.sleep(10000);;
		} catch (InterruptedException e) {
			System.out.println("Interrupted exception "+ e.getMessage());
		}
	}
}
