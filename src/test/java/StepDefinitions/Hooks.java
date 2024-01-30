package StepDefinitions;

import java.io.IOException;
import Utils.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestSetup mTestSetup; // Class global variable
	
	//Constructor declaration
	public Hooks(TestSetup mTestSetup)
	{
		this.mTestSetup = mTestSetup; // Assigning mTestSetup with this class mTestSetup.
	}

	
	@Before("@PlaceOrderTests")
	public void BeforeCheckOut(Scenario mSC)
	{
        System.out.println("This will be executed before Placeordertest");
	}

	
	@Before
	public void SetupBrowser(Scenario mSC)
	{
		System.out.println("Hooks class Before() "+mSC.getName());
	}

	@After
	public void EndTest() throws IOException
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("Hooks class's EndTest()");
		}
		mTestSetup.mInitilizeBrowser.BrowserManager().quit();
	}
	
	@After("@PlaceOrderTests")
	public void AfterCheckOut(Scenario mSC)
	{
        System.out.println("This will be executed after Placeordertest");
	}

	
}