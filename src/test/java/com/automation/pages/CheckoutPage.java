package com.automation.pages;

import com.automation.utilities.OrderDetails;
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
	OrderDetails od = new OrderDetails();
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
		try {
			firstName.sendKeys(od.getFirstName());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterLastName() {
		try {
			lastName.sendKeys(od.getLastName());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterAddress() {
		try {
			address.sendKeys(od.getAddress());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterCity() {
		try {
			city.click();
			city.sendKeys(od.getCity());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterState() {
		try {
			Select state = new Select(driver.findElement(By.id("account_state")));
			state.selectByVisibleText(od.getState());
			WebDriverWait wait = new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.visibilityOf(zipcode));
			//Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void enterZip() {
		try {
			zipcode.sendKeys(od.getZip());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterPhone() {
		try {
			phone.sendKeys(od.getPhone());
			Thread.sleep(2000);
		} catch (Exception e) {
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
		try {
			driver.findElement(By.xpath("//div[@class='shipping-method-section']//span[contains(text(),'"+od.getShipping()+"')]")).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCCDetails(){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", payWithCCButton);
		payWithCCButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardType(){
		try {
			Select cardtype = new Select(driver.findElement(By.id("mz-payment-credit-card-type")));
			cardtype.selectByValue(od.getCardType());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardNumber(){
		try {
			cardNumber.sendKeys(od.getCardNum());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCardName(){
		try {
			cardName.sendKeys(od.getCardName());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterExpMonth(){
		try {
			Select month = new Select(driver.findElement(By.name("expiration-month")));
			month.selectByValue(od.getMonth());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterExpYear(){
		try {
			Select year = new Select(driver.findElement(By.name("mz-payment-expiration-year")));
			year.selectByValue(od.getYear());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterCVV(){
		try {
			cvv.sendKeys(od.getCVV());
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickContinueBilling(){
		continueBillingButton.click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOf(cvv));
	}

	public void enterEmail(){
		try {
			Thread.sleep(2000);
			emailField.sendKeys(od.getEmail());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterPassword(){
		try {
			passwordField.sendKeys(od.getPass());
			Thread.sleep(2000);
		} catch (Exception e) {
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
