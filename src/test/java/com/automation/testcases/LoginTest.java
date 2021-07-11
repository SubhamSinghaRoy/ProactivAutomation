package com.automation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.MemberDashboard;
import com.automation.utilities.BaseClass;
import com.automation.utilities.XLUtility;
import com.aventstack.extentreports.MediaEntityBuilder;

public class LoginTest extends BaseClass{


	@Test(dataProvider = "LoginData")
	public void login(String username, String password, String type) throws IOException {

		logger = report.createTest("Login CXT");

		String exp_title = "member-dashboard";
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		MemberDashboard md = PageFactory.initElements(driver, MemberDashboard.class);

		logger.info("Site Launched");
		
		hp.clickLoginlink();
		lp.loginToMember(username, password);
		String act_title = driver.getTitle ();

		if(type.equals("valid")) {
			if(exp_title.equals(act_title)) {
				Assert.assertTrue(true);
				logger.pass("Login Success with "+username+" and "+password, MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
				md.clickSingOut();
			}
			else {
				Assert.fail();
				logger.fail("Login unsuccessful with "+username+" and "+password, MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}
		}

		else if(type.equals("invalid")){
			if(exp_title.equals(act_title)) {
				Assert.fail();
				logger.fail("Login Success with "+username+" and "+password, MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
				md.clickSingOut();
			}
			else {
				Assert.assertTrue(true);
				logger.pass("Login unsuccessful with "+username+" and "+password, MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}

		}

		Reporter.log("Test ended here");

	}

	@DataProvider(name="LoginData")
	public Object [][] getData() throws Exception{

		String path = "./TestData/Data.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalRows = xlutil.getRowCount("Login");
		int totalCols = xlutil.getCellCount("Login",1);

		String [][] loginData = new String[totalRows][totalCols];

		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				loginData[i-1][j] = xlutil.getCellData("Login", i, j);
			}
		}
		return loginData;

	}
}
