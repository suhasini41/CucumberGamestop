package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/featureFiles/SearchProduct.feature",
		glue = "com/gamestop/qa/tests",
		plugin = {"pretty", "html:target/report.html"},
		monochrome = true,
		strict = true,
		dryRun = false
		)
public class TestRunner {

}
