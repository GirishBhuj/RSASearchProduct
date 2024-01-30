package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjManager {
	public LandingPageElements mLandingPageElements;
	public OfferPageElements mOfferPageElements;
	public CheckOutPageElements mCheckOutPageElements;
	public WebDriver mbrowser;
	
	
	public PageObjManager(WebDriver browser)
	{
		if (System.getProperty("SOP") == "TRUE")
		{
				System.out.println("PageObjManager class's object constructor()");
		}
		this.mbrowser = browser;
	}
	
	public LandingPageElements getLandingPage()
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("PageObjManager class's getLandingPage()");
		}
		mLandingPageElements = new LandingPageElements(mbrowser);
		return mLandingPageElements;
	}
	
	public OfferPageElements getOfferPage()
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("PageObjManager class's getOfferPage()");
		}
		mOfferPageElements = new OfferPageElements(mbrowser);
		return mOfferPageElements;
	}
	
	public CheckOutPageElements getCheckOutPage()
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("PageObjManager class's CheckOutPageElements()");
		}
		mCheckOutPageElements = new CheckOutPageElements(mbrowser);
		return mCheckOutPageElements;
	}
}