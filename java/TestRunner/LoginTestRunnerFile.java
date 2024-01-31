package TestRunner;

import org.testng.annotations.DataProvider;

//import CucumberOptions.AbstarctTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/Features", // Feature file path
		glue= "StepDefinitions", //Step definition package name
		monochrome=true, 
		plugin= {"html:target/TestResult.html","json:target/TestResult.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)

public class LoginTestRunnerFile extends AbstractTestNGCucumberTests {

	// To run scenarios in parallel mode
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
