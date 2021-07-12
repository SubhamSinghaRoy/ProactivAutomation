package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String url) {
		switch (browserName) {
			case "Chrome" -> {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver89.exe");
				driver = new ChromeDriver();
			}
			case "Firefox" -> {
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			case "IE" -> {
				System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			default -> System.out.println("Browser not supported");
		}
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	}
	

	public static void closeApplication(WebDriver driver) {
		driver.quit();
	}
}
