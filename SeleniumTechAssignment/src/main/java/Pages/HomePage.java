package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	WebDriver webDriver;
	Properties properties = new Properties();
	FileInputStream fileInput;
	
	public HomePage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		
		fileInput = new FileInputStream(new File("HomePage.properties"));
		properties.load(fileInput);
	}
	
	/*public HomePage readFile() throws IOException{	
		
		return new HomePage(webDriver);
	}*/
	
	public HomePage openHomePageUrl() throws IOException {
		Reporter.log("Open Appdirect HomePage",true);
		webDriver.get(properties.getProperty("website"));
		return new HomePage(webDriver);
	}
	
	public HomePage clickOnLogin() throws IOException{
		webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).click();
		return new HomePage(webDriver);
	}
	
	public HomePage checkPageStatus() throws IOException{
		Reporter.log("Verify If Appdirect HomePage is Displayed",true);
		boolean status = webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).isDisplayed();
		Assert.assertTrue(status);
		return new HomePage(webDriver);
	}
	
	public HomePage implicitWait(WebDriver webDriver) throws IOException{
		webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return new HomePage(webDriver);
	}
	
}
