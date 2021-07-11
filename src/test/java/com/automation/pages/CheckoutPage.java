package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.automation.utilities.ConfigDataProvider;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriver driver;
	ConfigDataProvider config = new ConfigDataProvider();
	JavascriptExecutor js;


	public CheckoutPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="address-line1")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
//	@FindBy(id="account_state")
//	WebElement state;
	
	@FindBy(name="postal-code")
	WebElement zipcode;
	
	@FindBy(name="shippingphone")
	WebElement phone;
	
	@FindBy(xpath = "//div[@id='step-shipping-method']//button[contains(text(),'continue')]")
	WebElement shippingContinueButton;

	@FindBy(xpath = "//button[@class='enable-pay-with-card ']")
	WebElement payWithCCButton;

	@FindBy(name = "credit-card-number")
	WebElement cardNumber;

	@FindBy(name = "credit-card-name")
	WebElement cardName;

	@FindBy(id = "mz-payment-security-code")
	WebElement cvv;

	@FindBy(xpath = "//button[@data-mz-action='continueBilling']")
	WebElement continueBillingButton;

	@FindBy(name = "new-account-email")
	WebElement emailField;

	@FindBy(name = "new-account-password")
	WebElement passwordField;

	@FindBy(id = "mz-terms-and-conditions")
	WebElement tcCheckbox;

	@FindBy(xpath = "//button[@data-mz-action='submit']")
	WebElement orderNow;

	public void enterFirstName() {
		firstName.sendKeys(config.getFirstName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterLastName() {
		lastName.sendKeys(config.getLastName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterAddress() {
		address.sendKeys(config.getAddress());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterCity() {
		city.click();
		city.sendKeys(config.getCity());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterState() {
		Select state = new Select(driver.findElement(By.id("account_state")));
		state.selectByVisibleText(config.getState());
		try {
			WebDriverWait wait = new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) zipcode));
			//Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void enterZip() {
		zipcode.sendKeys(config.getZipCode());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterPhone() {
		phone.sendKeys(config.getPhone());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickshippingContinue() {
		shippingContinueButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectShippingMethod() {
		driver.findElement(By.xpath("//div[@class='shipping-method-section']//span[contains(text(),'"+config.getShippingMethod()+"')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCCDetails(){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", payWithCCButton);
		payWithCCButton.click();
		//js.executeScript("arguments[0].scrollIntoView();", continueBillingButton);
//		Select cardtype = new Select(driver.findElement(By.id("mz-payment-credit-card-type")));
//		cardtype.selectByVisibleText(config.getCardType());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardType(){
		Select cardtype = new Select(driver.findElement(By.id("mz-payment-credit-card-type")));
		cardtype.selectByValue(config.getCardType());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardNumber(){
		cardNumber.sendKeys(config.getCardNumber());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardName(){
		cardName.sendKeys(config.getCardName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterExpMonth(){
		Select month = new Select(driver.findElement(By.name("expiration-month")));
		month.selectByValue(config.getExpMonth());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterExpYear(){
		Select year = new Select(driver.findElement(By.name("mz-payment-expiration-year")));
		year.selectByValue(config.getExpYear());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCVV(){
		cvv.sendKeys(config.getCVV());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickContinueBilling(){
		continueBillingButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterEmail(){
		emailField.sendKeys(config.getEmail());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterPassword(){
		passwordField.sendKeys(config.getPassword());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectCheckbox(){
		tcCheckbox.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOrder(){
		orderNow.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
