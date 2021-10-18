package com.gamestop.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage
{
	WebDriver driver;
	
	@FindBy(xpath="//button[@id='add-to-cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[contains(text(),'Keep Shopping')]")
	WebElement keepShoppingLink;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickAddToCartButton()
	{
		addToCartButton.click();
	}
	
	public void clickKeepShoppingLink()
	{
		keepShoppingLink.click();
	}
	public WebElement getKeepShoppingLink()
	{
		return keepShoppingLink;
	}

}
