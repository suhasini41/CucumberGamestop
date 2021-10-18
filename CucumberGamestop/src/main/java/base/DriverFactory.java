package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	private WebDriver driver = null;
	
	public static DriverFactory df = null;
	
	private DriverFactory()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	public static DriverFactory getDriverFactory()
	{
		if(df==null)
		{
			df = new DriverFactory();
		}
		return df;
	}
	public WebDriver getDriver()
	{
		return driver;
	}
}
