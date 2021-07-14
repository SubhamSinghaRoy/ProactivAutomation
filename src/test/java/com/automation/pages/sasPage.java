package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utilities.ConfigDataProvider;

public class sasPage {

	WebDriver driver;
	JavascriptExecutor js;
	ConfigDataProvider config = new ConfigDataProvider();
	
	public sasPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//div[@class='nextButton']")
	WebElement step1_nextButton;

	@FindBy(xpath = "//p[@id='add-to-cart']")
	WebElement step2_nextButton;
	

	
	public void selectSystem() {
		driver.findElement(By.xpath("//div[@class='systemCategory']//div[contains(text(),'"+config.getSystemname()+"')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void clickStep1NextButton() {
		step1_nextButton.click();
	}
	
	public void selectSupply(){
		driver.findElement(By.xpath("//div[@data-mz-productsupply='"+config.getSupply()+"']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectKit() {
		js = (JavascriptExecutor) driver;
		WebElement kit = driver.findElement(By.xpath("/div[@id='mz-drop-zone-kit-section"+config.getSystemCategory()+"']//div[@id='productsSec' and contains(.,'"+config.getKitName()+"')]"));
		js.executeScript("arguments[0].scrollIntoView();", kit);
		kit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickStep2NextButton() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", step2_nextButton);
		step2_nextButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
}
