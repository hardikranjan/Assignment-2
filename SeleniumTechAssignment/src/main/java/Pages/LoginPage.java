package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	
	WebDriver webDriver;
	Properties properties = new Properties();
	WebDriverWait wait;
	FileInputStream fileInput;
	
	public LoginPage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("LoginPage.properties"));
		properties.load(fileInput);
	}
	
	public LoginPage openSignUpPage() throws IOException{
		Reporter.log("Open SignUp Page",true);
		webDriver.findElement(By.xpath(properties.getProperty("signUpXpath"))).click();
		return new LoginPage(webDriver);
	}
	
	public LoginPage signUpStatus() throws IOException{
		Reporter.log("Verify If Appdirect LoginPages is Displayed",true);
		boolean status = webDriver.findElement(By.className(properties.getProperty("status_password"))).isDisplayed();
		Assert.assertTrue(status);
		return new LoginPage(webDriver);
	}
	
	public LoginPage waitVisibilityConditionByXpath(WebDriver webDriver) throws IOException{
	    wait = new WebDriverWait(webDriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("signUpXpath"))));
		return new LoginPage(webDriver);
	}
	
}
