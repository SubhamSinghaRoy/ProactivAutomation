package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {

    WebDriver driver;
    public ConfirmationPage(WebDriver ldriver){
        this.driver=ldriver;
    }

    @FindBy(xpath = "//div[@class='mz-confirmationblock']//strong")
    WebElement orderNumber;

    @FindBy(id = "confirmBannerSection")
    WebElement confirmationBanner;

    public String getOrderNumber(){
        return orderNumber.getText();
    }

    public boolean bannerVisible(){
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(confirmationBanner));
        return confirmationBanner.isDisplayed();
    }
}
