package com.flight.factorymethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class SingleTonWebDriver {
	
	
	private static WebDriver driver;

	//private void SingleTonWebDriver() {}
	

	public static WebDriver getDriverInstance() {
		if (driver == null) {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		return driver;
	}

	public static void browserClose() {
		 if (null != driver){
	            driver.quit();
	        }

		      driver = null;
	}

	
	
	

}
