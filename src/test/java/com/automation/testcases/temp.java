package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.utilities.BaseClass;

public class temp extends BaseClass{

	@Test
	public void test() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.SelectCountryJapan();
		System.out.println(driver.getCurrentUrl());
	}
	
	
	
}
