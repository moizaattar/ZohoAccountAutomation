package com.zohoaccount.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohoaccount.baseclass.BaseClass;

public class AccountCreation extends BaseClass {
	
	public AccountCreation() {
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id="Crm_Accounts_ACCOUNTNAME_LInput")
	WebElement accName;
	

	
	public void accountName(String accountname) {
		accName.sendKeys(accountname);
	}

}
