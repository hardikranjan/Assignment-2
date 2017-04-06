package Waste;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitingClass {

	public static void implicitWait(WebDriver webDriver){
		webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public static WebElement waitVisibilityConditionByXpath(WebDriver webDriver,String xPath){
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
	
	
	
}
