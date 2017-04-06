package Waste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.testng.Reporter;

public class LoadDriver {
	static WebDriver webDriver;
	static boolean val = true;
	static Properties properties = new Properties();
	static FileInputStream fileInput;
	static String fileName = "config.properties";
	
	public static WebDriver loading() throws IOException{
		Reporter.log("Load Property File",val);
		fileInput = Detail.readFile(fileName);
		properties.load(fileInput);
		return webDriver;
	}
}
