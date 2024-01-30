package StepDefinitions;

import org.openqa.selenium.WebDriver;
import PageObjects.LandingPageElements;
import PageObjects.PageObjManager;
import Utils.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition 
{
	public WebDriver browser;
	public String LandingPageProdName;
	PageObjManager mPageObjManager;
	LandingPageElements mLandingPageElements;
	TestSetup mTestSetup; // Class global variable

	//Constructor declaration
	public LandingPageStepDefinition(TestSetup mTestSetup)
	{
		this.mTestSetup = mTestSetup; // Assigning mTestSetup with this class mTestSetup.
	}


	@Given("User is on GreenCart Home page")
	public void user_is_on_home_page() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		//mTestSetup.browser = new ChromeDriver();
		//mTestSetup.browser.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@When("^User search product with Shortname as (.+) and get the actual name of product$")
	public void user_search_product_with_shortname_as_and_get_the_actual_name_of_product(String SearchString) throws InterruptedException
	{
		//mTestSetup.browser.findElement(By.xpath("//input[@type='search']")).sendKeys(SearchString);
		//HTML code for below locator : <h4 class="product-name">Tomato - 1 Kg</h4>
		//mTestSetup.LandingPageProdName = mTestSetup.browser.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		
		//LandingPageElements mLandingPageElements = new LandingPageElements(mTestSetup.browser);

		//System.out.println("LandingPageStepDefinition SearchString "+SearchString);
		mLandingPageElements = mTestSetup.mPageObjManager.getLandingPage();
		
		mLandingPageElements.SearchItem(SearchString);		
		mTestSetup.LandingPageProdName = mLandingPageElements.getProductName();
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("LandingPageStepDefinition mTestSetup.LandingPageProdName : "+mTestSetup.LandingPageProdName);
		}
	}
	
	@When("Added {string} items of selected product to cart")
	public void added_items_of_selected_product_to_cart(String string)
	{
		mLandingPageElements.IncreItem(Integer.parseInt(string));
		mLandingPageElements.AddToCart();
	}
}