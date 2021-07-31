package com.automation.pages;

import com.automation.utilities.OrderDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utilities.ConfigDataProvider;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sasPage {

	WebDriver driver;
	JavascriptExecutor js;
	ConfigDataProvider config = new ConfigDataProvider();
	OrderDetails od = new OrderDetails();

	public sasPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//div[@class='nextButton']")
	WebElement step1_nextButton;

	@FindBy(xpath = "//p[@id='add-to-cart']")
	WebElement step2_nextButton;
	


	public void selectSystem() {
		try {
			driver.findElement(By.xpath("//div[@class='systemCategory']//div[contains(text(),'"+od.getSysName()+"')]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void clickStep1NextButton() {
		step1_nextButton.click();
	}
	
	public void selectSupply(){
		try {
			driver.findElement(By.xpath("//div[@data-mz-productsupply='"+od.getSupply()+"']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectKit() {
		try {
			js = (JavascriptExecutor) driver;
			WebElement kit = driver.findElement(By.xpath("//div[@id='mz-drop-zone-kit-section"+od.getSysCat()+"']//div[@id='productsSec' and contains(.,'"+config.getKitName()+"')]"));
			js.executeScript("arguments[0].scrollIntoView();", kit);
			kit.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickStep2NextButton() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", step2_nextButton);
		step2_nextButton.click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
}
