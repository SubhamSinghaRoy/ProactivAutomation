package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;
    }


    @FindBy(id = "email")
    WebElement uname;

    @FindBy(id = "form-password")
    WebElement pass;

    @FindBy(xpath = "//div[@class='formElements']//button")
    WebElement loginbutton;

    public void loginToMember(String username, String password) {
        uname.clear();
        uname.sendKeys(username);
        pass.clear();
        pass.sendKeys(password);
        loginbutton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
