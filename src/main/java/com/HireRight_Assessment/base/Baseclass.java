package com.HireRight_Assessment.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	public static void launchUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void inputToElement(WebElement element, String input) {
		element.sendKeys(input);
	}
}
