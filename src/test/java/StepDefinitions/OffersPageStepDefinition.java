package StepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import PageObjects.OfferPageElements;
import PageObjects.PageObjManager;
import Utils.TestSetup;
import io.cucumber.java.en.Then;

public class OffersPageStepDefinition 
{
	public WebDriver browser;
	public String LandingPageProdName;
	public String OfferPageProdName;
	PageObjManager mPageObjManager;
	TestSetup mTestSetup; // Class level global variable
	
	//Constructor declaration
	public OffersPageStepDefinition(TestSetup mTestSetup)
	{
		System.out.println("OffersPageSetpDefiniiton class consturactor");
		this.mTestSetup = mTestSetup; // Assigning mTestSetup with this class mTestSetup.
	}

	
	@Then("^User search product with Shortname as (.+) in Offers page$")
	public void user_search_product_with_shortname_as_in_offers_page(String OfferSearchString) throws InterruptedException
	{
		//mTestSetup.browser.findElement(By.linkText("Top Deals")).click();
		//SwitchWindow();
		//Thread.sleep(2000);
		//mTestSetup.browser.findElement(By.xpath("//input[@type='search']")).sendKeys(OfferSearchString);		
		
		//OfferPageElements mOfferPageElements = new OfferPageElements(mTestSetup.browser);
		OfferPageElements mOfferPageElements = mTestSetup.mPageObjManager.getOfferPage();
		mOfferPageElements.ClickTopDeals();
		mTestSetup.mGenericClass.SwitchWindowToChid();

		Thread.sleep(2000);
		mOfferPageElements.SearchItem(OfferSearchString);
		OfferPageProdName = mOfferPageElements.getOfferPageProductName();
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("Offer page product name: "+OfferPageProdName);
		}
	}
	
	@Then("Same product displayed in Offers page")
	public void validate_same_product_displayed_in_offers_page() 
	{
		System.out.println("===In method to Verify Landing page product name with Offers page product name =======");
		System.out.println("mTestSetup.LandingPageProdName "+ mTestSetup.LandingPageProdName);
		System.out.println("OfferPageProdName "+ OfferPageProdName);
		assertEquals(mTestSetup.LandingPageProdName,OfferPageProdName);
	}

}