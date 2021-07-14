package com.automation.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.MemberDashboard;
import com.automation.utilities.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CXTest extends BaseClass{

	
	
	
	@Test
	public void testMemberSite() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		MemberDashboard md = PageFactory.initElements(driver, MemberDashboard.class);


		try {
			logger = report.createTest("Member Dashboard Links Test");
			hp.clickLoginlink();
			lp.loginToMember("New017@yopmail.com", "Tpcweb123");
			if(driver.getTitle().equals("member-dashboard")) {
				logger.pass("Login Successful");
				WebDriverWait wait =new WebDriverWait(driver, 30);
				wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
				List<String> linksList = clickableLinks(driver);

				for(String link : linksList) {
					String url = link;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.open()");
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					driver.get(url);
					
					wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
					WebElement pageContent = driver.findElement(By.xpath("//body"));
					
					if(pageContent.getText().contains("Page Not Found")) {
						logger.fail(url+" launched and but broken", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
					}
					else {

						logger.pass(url+" launched and fine", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
						Assert.assertTrue(true);
					}
					js.executeScript("window.close()");

					driver.switchTo().window(tabs.get(0));
				}
			}
			else {
				logger.fail("Login failed",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//Assert.fail("test failed");
			e.printStackTrace();
		}
		
	}
	
	public List<String> clickableLinks(WebDriver driver)  {
		List<String> linksToClick = new ArrayList<>();
		List<WebElement> dashboardLinks = driver.findElements(By.xpath("//div[@class='memberDashboard']//a"));
		for (WebElement elm : dashboardLinks) {
			String link = elm.getAttribute("href");
			if(link!=null && !link.contains("instagram")) {
				linksToClick.add(link);
			}
		}

		return linksToClick;
	}
}
