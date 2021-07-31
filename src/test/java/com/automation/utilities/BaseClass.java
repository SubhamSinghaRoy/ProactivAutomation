package com.automation.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver; 
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public Helper helper;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		helper = new Helper();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/PA_"+helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		if(config.getEnv().equalsIgnoreCase("Prod")) {
			driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getProdUrl());
		}
		else if(config.getEnv().equalsIgnoreCase("UAT")) {
			driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUatUrl());
		}
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.closeApplication(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("Step failed", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			logger.pass("Test successfully completed", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
}
