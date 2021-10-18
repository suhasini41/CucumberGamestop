package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class Waits
{
	static DriverFactory df = DriverFactory.getDriverFactory();
	static WebDriver driver = df.getDriver();
	
	static WebDriverWait wait = new WebDriverWait(driver,15);
	
	public static void waitForTitle(String titleText)
	{
		wait.until(ExpectedConditions.titleContains(titleText));
	}
	
	public static void waitTillTextToBeVisible(WebElement element, String text)
	{
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

}
