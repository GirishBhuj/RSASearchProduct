package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericClass {
	public WebDriver mBrowser;
	
	public GenericClass(WebDriver browser)
	{
		this.mBrowser = browser;
	}

	public void SwitchWindowToChid()
	{
		System.out.println("In Utils class SwitchWindowToChid method");
		
		if (mBrowser.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
			{	}
		else
		{
			Set<String> WindowHandles = mBrowser.getWindowHandles();
			Iterator<String> mIterator = WindowHandles.iterator();
			String ParentWindow = mIterator.next();
			String ChildWindow = mIterator.next();
			mBrowser.switchTo().window(ChildWindow);
		}

		
	}
}
