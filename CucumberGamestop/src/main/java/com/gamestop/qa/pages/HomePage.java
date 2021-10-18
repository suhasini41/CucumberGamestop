package com.gamestop.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@role='search']//input[@name='q']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@role='search']//button[@type='submit']")
	WebElement searchIcon;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String title()
	{
		return driver.getTitle();
	}
	
	public void enterSearchItem(String item)
	{
		searchBox.sendKeys(item);
	}
	public void clickSearchIcon()
	{
		searchIcon.click();
		
	}
	

}
