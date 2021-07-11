package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MemberDashboard {

	WebDriver driver;
	public MemberDashboard(WebDriver ldriver) {
		this.driver=ldriver;
	} 
	
	@FindBy(xpath="//li[@class='menu-item']/a[contains(.,'Account')]")
	WebElement myaccount;
	
	@FindBy(xpath="//a[@href='/logout?returnUrl=/user/login']")
	WebElement signout;
	
	public void clickSingOut() {
		Actions builder = new Actions(driver);	
		Action mouseOver = builder.moveToElement(myaccount).build();
		mouseOver.perform();
		signout.click();
	}
}
