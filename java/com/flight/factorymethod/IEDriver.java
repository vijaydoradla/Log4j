package com.flight.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver extends WebDriverCreator{
	
	
	public WebDriver factoryMethod() {
		System.setProperty("IEDriverServer.exe", "webdriver.ie.driver");
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
	
	

}
