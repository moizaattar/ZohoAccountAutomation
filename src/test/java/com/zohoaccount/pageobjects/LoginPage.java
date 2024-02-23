package com.zohoaccount.pageobjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zohoaccount.baseclass.BaseClass;


public class LoginPage extends BaseClass {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "login_id")
	WebElement userName;

	@FindBy(id = "nextbtn")
	WebElement nextButton;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@id= 'nextbtn']/span")
	WebElement signIn;

	@FindBy(xpath = "//div[@class='zohoapps__candybox__z-icon']")
	WebElement ninedots;

	@FindBy(xpath = "//a[@href='https://crm.zoho.in/crm/ShowHomePage.do']")
	WebElement crm;
	Actions action = new Actions(driver);
	
	@FindBy (id="crmpluscommonui_crm_Accounts") 
	WebElement accountsTab;
	
	@FindBy(xpath = "//*[@id='table_row_1']/lyte-td[3]/span[1]/link-to/button")
	WebElement createAcc;
	JavascriptExecutor j = (JavascriptExecutor) driver;

	public void uName(String name) {
		userName.sendKeys(name);
	}

	public void nBtn() {
		nextButton.click();
	}

	public void uPassword(String pass) {
		password.sendKeys(pass);

	}

	public void signInBtn() {
		nextButton.click();
	}

	public void dots() {
		ninedots.click();
	}

	public void selectCrmOption() throws InterruptedException {
		action.moveToElement(crm).click().perform();
		//crm.click();
	}
	
	public void selectAccountTab() {
		Set<String> handles = driver.getWindowHandles();  //parentwindow, childwindow, subchildwindow
		Iterator it = handles.iterator();
		
		String parentwindow = (String) it.next();
		String childtwindow = (String) it.next();
		
		driver.switchTo().window(childtwindow);
		accountsTab.click();
		
	}
	
	
	public void createAccBtn() {
	//	action.moveToElement(createAcc).click().perform();
	//	createAcc.click();
		
		j.executeScript("arguments[0].click();", createAcc);
	}
	

}
