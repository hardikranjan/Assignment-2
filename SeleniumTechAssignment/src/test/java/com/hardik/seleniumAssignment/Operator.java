package com.hardik.seleniumAssignment;

import java.io.IOException;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Pages.*;
import Waste.WaitingClass;

public class Operator {
	WebDriver webDriver;
	Properties properties = new Properties();
	Browser browser;
	LoginPage loginPage;
	WaitingClass waitingClass;
	WebElement webElement;
	SignUpPage signUpPage;
	HomePage homepage;
	
	@Test
	public void browser() throws IOException{
		browser = new Browser(webDriver);
		webDriver= browser.startBrowser(browser.selectBrowser());	
	}
	
	@Test(dependsOnMethods="browser")
	public void verifyHomePage() throws IOException {
		homepage = PageFactory.initElements(webDriver, HomePage.class);
		homepage.openHomePageUrl()
		.implicitWait(webDriver)
		.clickOnLogin()
		.checkPageStatus();
	}
	
	@Test(dependsOnMethods="verifyHomePage")
	public void verifyLoginPage() throws IOException{
		loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		loginPage.waitVisibilityConditionByXpath(webDriver)
		.openSignUpPage()
		.signUpStatus();
	}
	
	@Test(dependsOnMethods="verifyLoginPage")
	public void verifySignUpPage() throws IOException{
		signUpPage = PageFactory.initElements(webDriver, SignUpPage.class);
		signUpPage.checkTitle()
		.enterEmailIdInSignUpText()
		.clickSignUpButton();	
	}
}