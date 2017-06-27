package com.flight.pomWebdriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.flight.singleton.WebDriverSingleton;



@Listeners(TestListener.class)
	
public class FlightSearchTest  {
	WebDriver driver;
	Logger logger;
	private static final String applicationURL = "https://www.easyjet.com/en/";
	
	private static final String homepage = "Book direct for our guaranteed cheapest prices | easyJet.com";
	private static final String departureCity = "Stockholm";
	private static final String expDepartureName = "Arlanda";

	private static final int adultsDisplayedTickets = 1;
	private static final String searchResultsPage = "Book cheap flights and find last minute flight deals – easyJet.com";

	private static final String currencyType = "kr";

	@Test
	
	public void flightTicketsBooking() throws Exception {
		
		FlightTicketsBookingPage ticketsBookingPage = PageFactory.initElements(driver, FlightTicketsBookingPage.class);
		// Closing Cookie policy Pop up
		ticketsBookingPage.cookiePolicyPopup();
		// Verifying Home Page opened
		// Assert.assertEquals(driver.getTitle().contains("easyJet"),"Flight Tickets booking page not found");

		// Under "Flights" tab, in "From" field type city "Stockholm"
		ticketsBookingPage.orginCity(departureCity);

		// Verify the value of "From" field contains airport name "Arlanda"
		Assert.assertTrue(ticketsBookingPage.getDepatureCity().contains(expDepartureName));
		// In "To" field choose city "London" using custom selector (button at
		// the right side from input field)
		ticketsBookingPage.destinationAirport();

		// Choose any departure dates
		ticketsBookingPage.depatureDate();
		// Choose any return dates
		ticketsBookingPage.returnDate();
		// Verify 1 adult passenger is added automatically
		Assert.assertEquals(ticketsBookingPage.defaultSelectedAdultsTickets(), adultsDisplayedTickets,
				"Default Adults tickets not match");
		// Add 1 one more passenger of type "Children"
		ticketsBookingPage.addChildPassenger();
		// Click "Show flights" button
		ticketsBookingPage.showFlights();

	}

	@Test(dependsOnMethods = { "flightTicketsBooking" })
	public void verifyingSearchResults() throws Exception {

		FlightSearchResultsPage flightSearchResultsPage = PageFactory.initElements(driver,
				FlightSearchResultsPage.class);

		// Verify that search results page is opened
		//Assert.assertEquals(driver.getTitle().contains("Book cheap flights and find last minute"), "Search Results page not found");
		 
		// Verify that search results contain prices for out bound flights
		Assert.assertTrue(flightSearchResultsPage.getOutboundFlightsDetails().contains(currencyType),
				"Outbound Flights details not contain prices details");
		// Verify that search results contain prices for return flights
		Assert.assertTrue(flightSearchResultsPage.getReturnFlightsDetails().contains(currencyType),
				"Return Flights details not contain prices details");

	}

	
	@BeforeClass
	public void launchBrowser() {
		    
		driver  = WebDriverSingleton.getWebDriverInstance();
		// Open main application page https://www.easyjet.com/en/
		driver.get(applicationURL);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	     logger = LogManager.getRootLogger();
         logger.info("Application Page Opened Successfully");
		 Reporter.log("Application Page Opened Successfully");
		
	}

	

	@AfterClass
	public  void closeWebBrowser(){
        if (null != driver){
        	driver.quit();
        	logger.info("Application Page closed Successfully");
        	Reporter.log("Application Page closed Successfully");
        }
        driver = null;
    }
	
	@AfterMethod
	public void takeScreenshot(ITestResult result){
		String methodName=result.getName().toString().trim();
		takeScreenShotOnFailure(methodName);
	}
	
	
	   public  void takeScreenShotOnFailure(String methodName)  {
		   String filePath = System.getProperty("file.separator");
		   
		 File file = new File("Screenshots" + filePath + "Results");
			if (!file.exists()) {
				file.mkdir();
			}
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();

		try {
	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("D:\\SeleniumWorkSpace\\pomWebdriver\\Results\\"+dateFormat.format(dt)+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}   
	    }
	
	
	   
	   
}//
