package com.zohoaccount.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zohoaccount.baseclass.BaseClass;
import com.zohoaccount.pageobjects.AccountCreation;
import com.zohoaccount.pageobjects.LoginPage;

public class AccountTestCases extends BaseClass{
	
	public AccountTestCases() throws IOException {
		super();
	}
	
	@BeforeTest
	public void setUp() throws IOException{
		initialization();
	}
	
	@Test
	public void loginPageTestCase() throws IOException, InterruptedException{
		LoginPage lp = new LoginPage();
		AccountCreation acccreation = new AccountCreation();
		
		lp.uName(prop.getProperty("username"));
		lp.nBtn();
		lp.uPassword(prop.getProperty("Password"));
		lp.signInBtn();
		lp.dots();
		Thread.sleep(5000);
		lp.selectCrmOption();
		Thread.sleep(5000);
		lp.selectAccountTab();
		
		Thread.sleep(8000);
		lp.createAccBtn();
		acccreation.accountName(prop.getProperty("accountname"));
	}
	
	

}
