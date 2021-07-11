package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//div[@class='footerLinks']//button[@class='cart-checkout']")
	WebElement checkoutButton;
	
	public void clickCartCheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", checkoutButton);
		checkoutButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
