package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPageElements {
	public WebDriver lbrowser;
	
	//Constructor declaration
	public OfferPageElements(WebDriver browser)
	{
		// Assigning local browser variable (lbrowser) with what we get while crating object of this class (browser)
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("OfferPageElements class constructor()");
		}
		this.lbrowser = browser;
	}
	
	private By TopDealsLink = By.linkText("Top Deals");
	private By SearchTextBox = By.xpath("//input[@type='search']");
	
	/*Below is HTML code for tr td:nth-child(1) cssSelector.
	 * <tr>
			<td>Tomato</td>
			<td>37</td>
			<td>26</td>
		</tr>
	 */
	//mTestSetup.browser.findElement(By.cssSelector("tr td:nth-child(1)")).getText(); // Prints Tomato
	//mTestSetup.browser.findElement(By.cssSelector("tr td:nth-child(2)")).getText()); // prints 37
	//mTestSetup.browser.findElement(By.cssSelector("tr td:nth-child(3)")).getText()); // prints 26

	private By ProductName = By.cssSelector("tr td:nth-child(1)");
	
	public void ClickTopDeals()
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("OfferPageElements ClickTopDeals()");
		}
		lbrowser.findElement(TopDealsLink).click();
	}
	
	public void SearchItem(String lSearchProdName)
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("OfferPageElements SearchItem()");
		}
		lbrowser.findElement(SearchTextBox).sendKeys(lSearchProdName);
	}

	public String getOfferPageProductName()
	{
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("OfferPageElements getOfferPageProductName()");
		}
		return 	lbrowser.findElement(ProductName).getText();
	}	
}