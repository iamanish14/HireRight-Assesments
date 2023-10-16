package com.HireRight_Assessment.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HireRight_Assessment.base.Baseclass;
import com.HireRight_Assessment.pom.PageElements;

public class TestRunner extends Baseclass {
	List<Double> priceList = new ArrayList<>();
	PageElements pg ;
	Double max_price;
	@Test
	public void login() {
		getDriver();
		launchUrl("https://www.saucedemo.com/");
		pg = new PageElements();
		inputToElement(pg.getUsername(), "standard_user");
		inputToElement(pg.getPassword(), "secret_sauce");
		clickOnElement(pg.getLogin_btn());
	}
	@Test(dependsOnMethods = "login")
	public void addToCart() {
		pg = new PageElements();
		Assert.assertEquals(pg.getProduct_list().size(), 6);
		Double price = null;
		List<WebElement> price_list = pg.getPrice_list();
		for (WebElement product_price : price_list) {
			String text = product_price.getText().substring(1);
			price = Double.parseDouble(text);
			
			priceList.add(price);
			
		}
		System.out.println(priceList);
		 max_price = Collections.max(priceList);
		 
		 WebElement addToCart = driver.findElement(By.xpath("//div[@class='pricebar']/div[contains(@class,'inventory_item_price') and text() = '"+max_price+"']//following-sibling::button"));
		addToCart.click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='pricebar']/div[contains(@class,'inventory_item_price') and text() = '"+max_price+"']//following-sibling::button")).getText(), "Remove","product added to cart");
	}

}
