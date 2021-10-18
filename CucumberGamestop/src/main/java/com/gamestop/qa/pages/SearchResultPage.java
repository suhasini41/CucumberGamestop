package com.gamestop.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='product-grid-tile-wrapper']//div[@class='product grid-tile']")
	List<WebElement> products;
	
	@FindBy(xpath="//a[@class='right-arrow ']")
	WebElement next;
	
	@FindBy(xpath="//a[contains(@class,'pagination-numbering ')][1]")
	WebElement pageOne;
	
	@FindBy(xpath="//a[@class='minicart-link']")
	WebElement cartIcon;
	
	@FindBy(xpath="//a[@class='minicart-link']/span[3]")
	WebElement numberOfItemsInCart;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	
	public List<WebElement> getProducts()
	{
		return products;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public boolean clickOnProduct(String product)
	{
		boolean flag = false;
		try
		{
			List<WebElement> list = getProducts();
			for(WebElement e : list)
		    {
		    	String p = e.getText();
		    	System.out.println(p);
		    	if(p.contains(product))
		    	{
		    		e.click();
		    		flag = true;
		    		break;
		
		    	}
		    }
		}
		catch(Exception e)
		{
			List<WebElement> list = getProducts();
			for(WebElement e1 : list)
		    {
		    	String p = e1.getText();
		    	
		    	if(p.contains(product))
		    	{
		    		e1.click();
		    		flag = true;
		    		break;
		
		    	}
		    }
		}
		return flag;
	}
	public void back()
	{
		driver.navigate().back();
	}
	public void clickNext()
	{
		next.click();
	}
	
	public void clickPageOne()
	{
		pageOne.click();
	}
	
	public boolean isCartIconDisplayed()
	{
		return cartIcon.isDisplayed();
	}
	
	public int actualNumberOfItemsInCart()
	{
		return Integer.parseInt(numberOfItemsInCart.getText());
	}

}
