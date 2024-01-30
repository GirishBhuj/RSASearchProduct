package Utils;

/*
Test Setup class object constructor()
InitilizeBrowser class object BrowserManager()
PageObjManager class's object constructor()
PageObjManager class's getLandingPage()
LandingPageElements class constructor()
LandingPageElements SearchItem()
LandingPageElements getProductItemName()
OffersPageSetpDefiniiton class consturactor
PageObjManager class's getOfferPage()
OfferPageElements class constructor()
OfferPageElements ClickTopDeals()
Utils class SwitchWindowToChid()
OfferPageElements SearchItem()
OfferPageElements getOfferPageProductName()
===In method to Verify Landing page product name with Offers page product name =======
In Hooks class's EndTest()
*/

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjManager;

public class TestSetup 
{
	public WebDriver browser;
	public String LandingPageProdName;
	public PageObjManager mPageObjManager;
	public InitilizeBrowser mInitilizeBrowser;
	public GenericClass mGenericClass;
	
	public TestSetup() throws IOException
	{
		if (System.getProperty("SOP") == "TRUE")
		{	
			System.out.println("In Test Setup clas object constructor");
		}
		mInitilizeBrowser = new InitilizeBrowser();
		mPageObjManager = new PageObjManager(mInitilizeBrowser.BrowserManager());
		mGenericClass = new GenericClass(mInitilizeBrowser.BrowserManager());
	}
}