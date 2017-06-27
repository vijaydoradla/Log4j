package com.flight.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ChromeDriverCreator extends WebDriverCreator {
	@Override	
public WebDriver factoryMethod() {
		
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();;
		
		return driver;
	}
	

}
