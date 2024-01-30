package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageElements {
	public WebDriver lbrowser;
	
	//Constructor declaration
	public LandingPageElements(WebDriver browser)
	{
		// Assigning local browser variable (lbrowser) with what get while crating object of this class (browser)
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("LandingPageElements class constructor()");
		}
		this.lbrowser = browser;
	}
	
	By SearchTextBox = By.xpath("//input[@type='search']"); //Locator code to find element using Xpath
	By ProductName = By.cssSelector("h4.product-name");
	
	//<a href="#" class="increment">+</a>
	By AddItemBtn = By.cssSelector("a.increment");
	
	/* <div class="product-action">
			<button class="" type="button">ADD TO CART</button>
		</div>
	*/
	By AddToCartBtn = By.cssSelector(".product-action button");
	
	//==================
	
	public void SearchItem(String lSearchProdName)
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("LandingPageElements SearchItem() lSearchProdName:"+ lSearchProdName);
		}
		lbrowser.findElement(SearchTextBox).sendKeys(lSearchProdName);
	}

	public String getProductName() throws InterruptedException
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("LandingPageElements getProductItemName()");
		}
		Thread.sleep(1000);
		return 	lbrowser.findElement(ProductName).getText().split("-")[0].trim();
	}
	
	public void IncreItem(int mQty)
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("LandingPageElements IncreItem()");
			System.out.println(mQty);
		}

		int mCount=mQty-1;
		while(mCount > 0)
		{
			//System.out.println(mCount);
			lbrowser.findElement(AddItemBtn).click();
			mCount--;
		}
	}
	
	public void AddToCart()
	{
		lbrowser.findElement(AddToCartBtn).click();
	}
}