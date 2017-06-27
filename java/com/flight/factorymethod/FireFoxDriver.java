package com.flight.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriver extends WebDriverCreator{
	
	
	String 	projectPath = System.getProperty("user.dir");
	String  filepath = projectPath+"\\Resources\\geckodriver.exe";
	
	public WebDriver factoryMethod() {
	
		System.setProperty("webdriver.gecko.driver", filepath);
	
		return new FirefoxDriver();
	   }
	
	
	

}
