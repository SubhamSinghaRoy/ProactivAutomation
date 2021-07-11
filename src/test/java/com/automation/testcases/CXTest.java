package com.automation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.MemberDashboard;
import com.automation.utilities.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CXTest extends BaseClass{

	
//	List<WebElement> linksList = clickableLinks(driver);
	
	@Test
	public void testmemberSite() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		MemberDashboard md = PageFactory.initElements(driver, MemberDashboard.class);
		try {
			logger = report.createTest("CXT Site Test");
			hp.clickLoginlink();
			lp.loginToMember("New017@yopmail.com", "Tpcweb123");
			if(driver.getTitle().equals("member-dashboard")) {
				logger.pass("Login Successful");
				List<WebElement> dashboardLinks = driver.findElements(By.xpath("//div[@class='memberDashboard']//a"));
				for(WebElement link : dashboardLinks) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", link);
					link.click();
					WebElement pageTitle = driver.findElement(By.xpath("//body"));
					WebDriverWait wait =new WebDriverWait(driver, 15);
					wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
					if(pageTitle.getText().contains("Page Not Found")) {
						logger.fail(link+" launched and but broken", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
					}
					else {
						logger.pass(link+" launched and fine", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
					}
					driver.navigate().back();
					js.executeScript("window.scrollBy(0,-300)", "");
				}
			}
			else {
				logger.fail("Login failed",MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public List<WebElement> clickableLinks(WebDriver driver){
//		List<WebElement> linksToClick = new ArrayList<WebElement>();
//		List<WebElement> dashboardLinks = driver.findElements(By.xpath("//div[@class='memberDashboard']//a"));
//		for (WebElement e : dashboardLinks) {
//			if(e.getAttribute("href")!=null) {
//				linksToClick.add(e);
//			}
//		}
//		return linksToClick;
//	}
}
