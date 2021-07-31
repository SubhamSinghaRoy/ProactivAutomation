package com.automation.testcases;

import com.automation.pages.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.utilities.BaseClass;

import java.io.IOException;
public class OrderTest extends BaseClass{

	@Test
	public void placeOrder() throws IOException {

		logger = report.createTest("Sample Order");
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		sasPage sp = PageFactory.initElements(driver, sasPage.class);
		CartPage cp = PageFactory.initElements(driver, CartPage.class);
		CheckoutPage checkout = PageFactory.initElements(driver, CheckoutPage.class);
		ConfirmationPage conf = PageFactory.initElements(driver, ConfirmationPage.class);

		hp.homeOrderClick();
		sp.selectSystem();
		sp.clickStep1NextButton();
		sp.selectSupply();
		sp.selectKit();
		sp.clickStep2NextButton();
		cp.clickCartCheckout();
		checkout.enterFirstName();
		checkout.enterLastName();
		checkout.enterAddress();
		checkout.enterCity();
		checkout.enterState();
		checkout.enterZip();
		checkout.enterPhone();
		checkout.clickshippingContinue();
		checkout.clickshippingContinue();
		checkout.selectShippingMethod();
		checkout.clickshippingContinue();
		checkout.enterCCDetails();
		checkout.enterCardType();
		checkout.enterCardNumber();
		checkout.enterCardName();
		checkout.enterExpMonth();
		checkout.enterExpYear();
		checkout.enterCVV();
		checkout.clickContinueBilling();
		checkout.enterEmail();
		checkout.enterPassword();
		checkout.selectCheckbox();
		checkout.clickOrder();

		if(conf.bannerVisible()==true){
			conf.getOrderNumber();
			logger.pass("order placed successfully and order number is "+conf.getOrderNumber()+"", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}
		
		else
		{
			logger.fail("order could not be placed successfully", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}

	}
	
}
