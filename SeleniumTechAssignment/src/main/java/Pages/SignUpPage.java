package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	
public class SignUpPage {
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);  
	String emailId = "username"+ randomInt +"@gmail.com";
	WebDriver webDriver; 
	Properties properties = new Properties();
	FileInputStream fileInput;
	
	public SignUpPage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("SignUpPage.properties"));
		properties.load(fileInput);
	}
	
	public SignUpPage enterEmailIdInSignUpText() throws IOException{
		webDriver.findElement(By.xpath(properties.getProperty("signUpTextField"))).sendKeys(emailId);
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage clickSignUpButton() throws IOException{
		webDriver.findElement(By.xpath(properties.getProperty("signUpButton"))).click();
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage checkTitle() throws IOException{
		Assert.assertTrue(webDriver.getTitle().contains("Sign Up for AppDirect"));
		return new SignUpPage(webDriver);
	}
}
