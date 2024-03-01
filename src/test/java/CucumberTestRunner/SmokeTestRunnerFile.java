package CucumberTestRunner;

/*
 * Execution flow 
 * TestRunner -> Featurefile -> StepDefinition -> TestSetup (open browser), 
 * In Test Setup class object constructor
InitilizeBrowser class object BrowserManager method
InitilizeBrowser class object BrowserManager method
InitilizeBrowser class object BrowserManager method
PageObjManager class's object constructor()
PageObjManager class's object constructor()
PageObjManager class's getLandingPage()
LandingPageElements class constructor()
LandingPageElements SearchItem() lSearchProdName:TOM
PageObjManager class's getLandingPage()
LandingPageElements class constructor()
LandingPageElements SearchItem() lSearchProdName:TOM
PageObjManager class's object constructor()
PageObjManager class's getLandingPage()
LandingPageElements class constructor()
LandingPageElements SearchItem() lSearchProdName:Beet
In Hooks class's EndTest method
In Hooks class's EndTest method
In Hooks class's EndTest method
 */


import org.testng.annotations.DataProvider;

//import CucumberOptions.AbstarctTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/Features/SmokeTest", // Feature file path
		glue= "StepDefinitions", //Step definition package name
		monochrome=true, 
		plugin= {"html:target/TestResult.html","json:target/TestResult.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//,tags= "@PlaceOrderTests"
		//tags= {"@scenario1,@scenario2,@scenario3"} //Multiple tags
		//tags= {"@SIT","@Regression"} //AND - Run a tag having both tags
		//tags= {"@TestSuite,@Regression"} //Or - Run a tag having any of tags listed here
		//tags= {"@FunctionalTest"} //Executing a whole feature file
		//tags= {"@TestSuite,~@SIT"} //Exculding the tag by using ~	
	)

public class SmokeTestRunnerFile extends AbstractTestNGCucumberTests {

	// To run scenarios in parallel mode
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
