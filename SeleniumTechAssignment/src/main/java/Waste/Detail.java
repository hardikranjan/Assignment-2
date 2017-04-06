package Waste;
import java.io.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Detail {
	public static WebDriver driver = null; 
	public static FileInputStream fileInput;
	public static WebElement element;
	
	public static WebDriver getDriver(){
		driver = new ChromeDriver();
		return driver;
	}
	
	public static void openWebsite(WebDriver driver,String url){
		driver.get(url);
	}
	
	public static FileInputStream readFile(String fileName) throws FileNotFoundException{
		fileInput = new FileInputStream(new File(fileName));
		return fileInput;
	}
	
	public static WebElement findByXpath(WebDriver driver,String id){
		element =  driver.findElement(By.xpath(id));
		return element;
	}
	
	public static void enter(WebElement elem,String name){
		elem.sendKeys(name);
	}
	
	public static WebElement css(WebDriver driver,String css){
		element = driver.findElement(By.cssSelector(css));
		return element;
	}
	
}
	

