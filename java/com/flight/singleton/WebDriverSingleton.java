package com.flight.singleton;

import org.openqa.selenium.WebDriver;
import com.flight.factorymethod.ChromeDriverCreator;
//import com.flight.factorymethod.WebDriverCreator;

public class WebDriverSingleton {
	
	private static WebDriver driver;
	
    private WebDriverSingleton() {}

    public static  WebDriver getWebDriverInstance() {
        if (null == driver) {
        	ChromeDriverCreator creator = new ChromeDriverCreator();
            driver = creator.factoryMethod();
        }
        return driver;
    }

    
	
	
	
	
	
	

}
