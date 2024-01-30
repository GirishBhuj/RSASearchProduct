package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPageElements {
	public WebDriver lbrowser; 
	
	//Constructor declaration
	public CheckOutPageElements(WebDriver browser)
	{
		// Assigning local browser variable (lbrowser) with what get while crating object of this class (browser)
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("CheckOutPageElements class constructor()");
		}
		
		this.lbrowser = browser;
	}
	
	//<img class=" " src="https://rahulshettyacademy.com/seleniumPractise/images/bag.png" alt="Cart">
	By CartBag = By.cssSelector("[alt='Cart']");

	//<button type="button" class=" ">PROCEED TO CHECKOUT</button>
	By CheckOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

	//HTML code - <button class="promoBtn">Apply</button>
	By PromoBtn = By.cssSelector(".promoBtn");
	
	By PlaceOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	By ProdName = By.cssSelector("p.product-name");
	
	public void CheckoutItem()
	{
		lbrowser.findElement(CartBag).click();
		lbrowser.findElement(CheckOutButton).click();		
	}
	
	public Boolean VerifyPromoBtn()
	{
		return lbrowser.findElement(PromoBtn).isDisplayed();
		
	}
	
	public Boolean VerifyPlaceOrderBtn()
	{
		return lbrowser.findElement(PlaceOrder).isDisplayed();
		
	}

	public String ExtractProdutName()
	{
		return lbrowser.findElement(ProdName).getText().split("-")[0].trim();
	}	
}