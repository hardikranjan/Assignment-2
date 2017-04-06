package com.hardik.seleniumAssignment;

import java.io.*;
import java.util.Properties;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Browser extends EnumBrowser {
	
	public static final int Chrome = 0;
	public static final int Firefox = 1;
	public static final int IE = 2;
	boolean val = true;
	Scanner scanner = new Scanner(System.in);
	InternetBrowser browser;
	String choice;
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties = new Properties();

	Browser(InternetBrowser browser){
		this.browser = browser;
	}
	
	Browser(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
			
		Reporter.log("Reading Respective Property File",true);
		fileInput = new FileInputStream(new File("Browser.properties"));
		properties.load(fileInput);	
	}
	
	public String selectBrowser(){
		System.out.println("Which Browser To Start");
		for(InternetBrowser browser: InternetBrowser.values()){
			System.out.print(browser+" ");
		}
		choice = scanner.next();
		return choice;
	}
	
	public WebDriver startBrowser(String browserName) throws IOException{
		if(InternetBrowser.Chrome.toString().equalsIgnoreCase(browserName)){
			Reporter.log("Open Chrome Browser",val);
			System.setProperty(properties.getProperty("driverName"),properties.getProperty("driverPath"));
			webDriver = new ChromeDriver();
		}
		else if(InternetBrowser.Firefox.toString().equalsIgnoreCase(browserName)){
			
		}
		else if(InternetBrowser.IE.toString().equalsIgnoreCase(browserName)){
			
		}
		return webDriver;
	}
}