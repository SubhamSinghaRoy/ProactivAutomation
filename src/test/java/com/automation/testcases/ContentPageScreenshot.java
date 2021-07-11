package com.automation.testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.utilities.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ContentPageScreenshot extends BaseClass{

	
	@Test
	public void takeContentPageScreenshot() {
		
		logger = report.createTest("Content Page Test");
		int i=0;
		List<WebElement> linksList = clickableLinks(driver);

		logger.info("Test Started");
		for (WebElement link : linksList) {
			String url = link.getAttribute("href");
			
			try{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open()");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(tabs.get(1));
			    driver.get(url);
				WebElement pageTitle = driver.findElement(By.xpath("//body"));
				WebDriverWait wait =new WebDriverWait(driver, 15);
				wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
				if(pageTitle.getText().contains("Page Not Found")) {
					logger.fail(url+" launched and Page link is broken", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
				}
				Screenshot(i);
				Thread.sleep(1000);
				js.executeScript("window.close()");
				driver.switchTo().window(tabs.get(0));
				}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
			
		}
	

	public List<WebElement> clickableLinks(WebDriver driver){
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> contentPageLinks = driver.findElements(By.xpath("//ul[@class='mz-sitenav-list main-menu-sec menu']/li//ul//a"));
		//contentPageLinks.addAll(driver.findElements(By.xpath("//div[@class='footer-container']//a")));
		for (WebElement e : contentPageLinks) {
			if(e.getAttribute("href")!=null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}
	
	public void Screenshot(int i) {
	Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000)).takeScreenshot(driver);
    try {
        ImageIO.write(screenshot.getImage(),"PNG",new File("./ContentPage_Screenshots/content_page_"+i+".png"));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	}
}
