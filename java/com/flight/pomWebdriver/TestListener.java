package com.flight.pomWebdriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.ITestContext ;		
	


	public class TestListener extends TestListenerAdapter{	
	//public class ListenerTest implements ITestListener{	
		
	/*WebDriver driver;

	public TestListener(WebDriver driver) {
		this.driver = driver;

	}
*/
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("***** Error "+result.getName()+" test has failed *****");
	
}





	
   public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}
	
	
	
 
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
  
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	

}//Class
