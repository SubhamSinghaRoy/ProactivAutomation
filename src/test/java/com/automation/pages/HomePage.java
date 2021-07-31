package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//div[@class='top-header']//a[@class='order-now']")
	WebElement homeorderCTA;
	
	@FindBy(xpath = "//nav[@class='mz-utilitynav']//select")
	WebElement countryDropdown;
	
	@FindBy(xpath = "//nav[@class='mz-utilitynav']//a[@data-mz-action='login']")
	WebElement loginLink;
	
	public void homeOrderClick() {
		homeorderCTA.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	public void selectCountryUSA() {
		Select country = new Select(countryDropdown);
		country.selectByVisibleText("USA");
	}
	
	public void selectCountryCanada() {
		Select country = new Select(countryDropdown);
		country.selectByVisibleText("Canada");
	}
	
	public void SelectCountryJapan() {
		Select country = new Select(countryDropdown);
		country.selectByVisibleText("Japan");
	}
	
	public void clickLoginlink() {
		loginLink.click();
		WebDriverWait wait =new WebDriverWait(driver, 15);
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
}
