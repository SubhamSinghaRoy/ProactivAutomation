package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.utilities.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CountryDropdownTest extends BaseClass{

	@Test
	public void testCounryDropdown() {
		
		String usaTitle = "For All Skin Types | Acne & Skincare Treatment | Proactiv®";
		String canadaTitle = "Proactiv Plus Acne Treatment | Proactiv® Official Site";
		
		logger = report.createTest("Country Dropdown");
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		
		try {
			hp.selectCountryCanada();
			if(driver.getTitle().equals(canadaTitle)){
				Assert.assertTrue(true);
				logger.pass("Canada site is opened successfully", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}
			else {
				Assert.fail();
				logger.fail("Canada site not launched", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}
			
			hp.selectCountryUSA();
			
			if(driver.getTitle().equals(usaTitle)) {
				Assert.assertTrue(true);
				logger.pass("USA site is opened successfully", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}
			else {
				Assert.fail();
				logger.fail("USA site not launched",MediaEntityBuilder.createScreenCaptureFromBase64String(helper.captureScreenshot(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
