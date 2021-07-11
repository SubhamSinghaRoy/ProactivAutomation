package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Unable to load config file : " + e.getMessage());
		}

	}

	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getEnv() {
		return pro.getProperty("Environment");
	}

	public String getUatUrl() {
		return pro.getProperty("uatUrl");
	}

	public String getProdUrl() {
		return pro.getProperty("prodUrl");
	}

	public String getSystemname() {
		return pro.getProperty("systemName");
	}

	public String getSupply() {
		return pro.getProperty("supply");
	}

	public String getSystemCategory() {
		return pro.getProperty("systemCategory");
	}

	public String getKitName() {
		return pro.getProperty("kitName");
	}

	public String getFirstName() {
		return pro.getProperty("firstname");
	}

	public String getLastName() {
		return pro.getProperty("lastname");
	}

	public String getAddress() {
		return pro.getProperty("address");
	}

	public String getCity() {
		return pro.getProperty("city");
	}

	public String getState() {
		return pro.getProperty("state");
	}

	public String getZipCode() {
		return pro.getProperty("zip");
	}

	public String getPhone() {
		return pro.getProperty("phone");
	}

	public String getShippingMethod() {
		return pro.getProperty("shipping");
	}

	public String getCardType() {
		return pro.getProperty("cardtype");
	}

	public String getCardNumber() {
		return pro.getProperty("cardno");
	}

	public String getCardName() {
		return pro.getProperty("cardname");
	}

	public String getExpMonth() {
		return pro.getProperty("month");
	}

	public String getExpYear() {
		return pro.getProperty("year");
	}

	public String getCVV() {
		return pro.getProperty("cvv");
	}

	public String getEmail() {
		return pro.getProperty("emailID");
	}

	public String getPassword(){
		return pro.getProperty("password");
	}

}