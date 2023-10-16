package com.HireRight_Assessment.pom;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.HireRight_Assessment.base.Baseclass;

public class PageElements extends Baseclass {
	
	public PageElements() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-button")
	private WebElement login_btn;
	
	@FindBy(xpath = "//div[@class='inventory_item']")
	private List<WebElement> product_list ;
	
	@FindBy(xpath = "//div[@class='pricebar']/div[@class='inventory_item_price']")
	private List<WebElement> price_list;
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin_btn() {
		return login_btn;
	}
	public List<WebElement> getProduct_list() {
		return product_list;
	}
	public List<WebElement> getPrice_list() {
		return price_list;
	}
	
	
	
	

}
