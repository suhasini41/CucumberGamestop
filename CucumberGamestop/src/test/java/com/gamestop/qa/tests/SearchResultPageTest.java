package com.gamestop.qa.tests;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gamestop.qa.pages.ProductPage;
import com.gamestop.qa.pages.SearchResultPage;

import base.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Waits;

public class SearchResultPageTest 
{
	DriverFactory df = DriverFactory.getDriverFactory();
	WebDriver driver = df.getDriver();
	
	SearchResultPage srp = PageFactory.initElements(driver, SearchResultPage.class);
	ProductPage pp = PageFactory.initElements(driver, ProductPage.class);
	
	List<WebElement> list; 
	String parentWindow;
	String productWindow;
	boolean clicked = false;
	
	@Given("^the search list is displayed$")
	public void the_search_list_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		list = srp.getProducts();
	   Assert.assertTrue(list.size()>0);
	}

	@When("^clicked on \"([^\"]*)\"$")
	public void clicked_on(String product) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		while(clicked==false)
		{
			clicked = srp.clickOnProduct(product);
			if(clicked==true)
			{
				break;
			}
			else
			{
				srp.clickNext();
			}
		}
	    Assert.assertTrue(clicked);
	}
	@When("^the product is added to cart$")
	public void the_product_is_added_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    pp.clickAddToCartButton();
	    Waits.waitTillTextToBeVisible(pp.getKeepShoppingLink(), "Keep Shopping");
	    pp.clickKeepShoppingLink();
	}


	@Then("^the product page title should contain \"([^\"]*)\"$")
	public void the_product_page_title_should_contain(String product) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Waits.waitForTitle(product);
		
	    Assert.assertTrue(srp.getTitle().contains(product));
	    srp.back();
	    srp.clickPageOne();
	}
	
	@Given("^the cart icon is displayed$")
	public void the_cart_icon_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(srp.isCartIconDisplayed());
	}

	@Then("^the number of items in the cart must be (\\d+)$")
	public void the_number_of_items_in_the_cart_must_be(int expectedNumberOfItemsInCart) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(srp.actualNumberOfItemsInCart(),expectedNumberOfItemsInCart);
	    
	}



}
