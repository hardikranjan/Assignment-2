package com.hardik.seleniumAssignment;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

import Utils.*;
import Waste.Detail;
import Waste.LoadDriver;
import Waste.WaitingClass;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class Controller {
	WebDriver webDriver ;
	WebElement element;
	Properties properties = new Properties();
	boolean val = true;
	
	@Test
	public void browserStart() throws Exception{
		
		webDriver = LoadDriver.loading();
		Reporter.log("Open Browser",val);
		

	}
	
	@Test(dependsOnMethods="browserStart")
	public void start() throws InterruptedException, IOException, BiffException, WriteException{
		
		WaitingClass.implicitWait(webDriver);		
		Reporter.log("Open Respective Website",val);
		Detail.openWebsite(webDriver,properties.getProperty("website"));
		
		Reporter.log("Open LoginPage",val);
		webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).click();
		
		boolean status = webDriver.findElement(By.xpath("//*[@id='newnav']/header/div/nav/ul/li[1]/a")).isDisplayed();
		Assert.assertTrue(status);
		
		Reporter.log("Open SignUp Page",val);
		element = WaitingClass.waitVisibilityConditionByXpath(webDriver, properties.getProperty("signUpXpath"));
		Detail.findByXpath(webDriver,properties.getProperty("signUpXpath")).click();
		//webDriver.findElement(By.xpath(properties.getProperty("signUpXpath"))).click();
		
		Reporter.log("Get EmaiId from Excel Sheet",val);
		String emailId = ReadFromExcelFile.getExcelData(0,1);
		
		Reporter.log("Send Value in SignIn Text");
		element = Detail.css(webDriver,properties.getProperty("signIdText"));
		element.sendKeys(emailId);
		element.click();
		//webDriver.findElement(By.cssSelector(properties.getProperty("signIdText"))).sendKeys(emailId);
		
		Reporter.log("SignUp Button Click");
		
		//webDriver.findElement(By.cssSelector(properties.getProperty("signUpButton"))).click();
		
	}
}
