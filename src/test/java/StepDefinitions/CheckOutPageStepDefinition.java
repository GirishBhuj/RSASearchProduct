package StepDefinitions;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CheckOutPageElements;
import PageObjects.PageObjManager;
import Utils.TestSetup;
import io.cucumber.java.en.Then;

public class CheckOutPageStepDefinition 
{
	public WebDriver browser;
	public CheckOutPageElements mCheckOutPageElements;
	PageObjManager mPageObjManager;
	TestSetup mTestSetup; // Class global variable

	//Constructor declaration
	public CheckOutPageStepDefinition(TestSetup mTestSetup)
	{
		this.mTestSetup = mTestSetup; // Assigning mTestSetup with this class mTestSetup.
		mCheckOutPageElements = mTestSetup.mPageObjManager.getCheckOutPage();
	}


	@Then("User enters the promo code and place the order")
	public void user_enters_promo_code_and_place_the_order() throws InterruptedException
	{
		Assert.assertTrue(mCheckOutPageElements.VerifyPromoBtn());
		Assert.assertTrue(mCheckOutPageElements.VerifyPlaceOrderBtn());	
	}

	@Then("^User proceeds to Checkout the order and validate (.+) items in the checkout page$")
	public void user_proceeds_to_checkout_the_order_and_validate_shortname_as_in_landing_page(String CartProdName) throws InterruptedException
	{
		mCheckOutPageElements.CheckoutItem();
		System.out.println("CheckOutPageSetpDefinition");
		System.out.println("mTestSetup.LandingPageProdName:"+mTestSetup.LandingPageProdName + " mCheckOutPageElements.ExtractProdutName:"+mCheckOutPageElements.ExtractProdutName());
		assertEquals(mTestSetup.LandingPageProdName,mCheckOutPageElements.ExtractProdutName());
	}
	
}