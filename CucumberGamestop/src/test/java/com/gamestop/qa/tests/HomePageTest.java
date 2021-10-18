package com.gamestop.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gamestop.qa.pages.HomePage;

import base.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class HomePageTest
{
	DriverFactory df = DriverFactory.getDriverFactory();
	WebDriver driver = df.getDriver();
	
	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	
	@Given("^the homePage with title \"([^\"]*)\"$")
	public void the_homePage_with_title(String expectedHomePageTitle) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(hp.title(), expectedHomePageTitle);
	}

	@When("^I enter the product name \"([^\"]*)\"$")
	public void i_enter_the_product_name(String item) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		hp.enterSearchItem(item);
	}

	@When("^click search icon$")
	public void click_search_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   hp.clickSearchIcon();
	}

	@Then("^I should be in the search results page with title \"([^\"]*)\"$")
	public void i_should_be_in_the_search_results_page_with_title(String expectedSearchPageTitle) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals(hp.title(), expectedSearchPageTitle);
	}

	
}
