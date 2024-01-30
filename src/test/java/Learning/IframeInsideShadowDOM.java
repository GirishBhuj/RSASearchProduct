package Learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframeInsideShadowDOM
{

	public static WebDriver browser;
	public static WebDriverWait wait;
	public static WebElement w1;

	
	public static void main(String[] args) throws InterruptedException 
	{		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        
		try 
		{
			browser = new ChromeDriver(options);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}

		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //5 seconds wait will be applicable for all setps
		browser.get("https://selectorshub.com/iframe-in-shadow-dom/");
		browser.manage().window().maximize();
        Thread.sleep(500);

        //Locate the shadow DOM
        //<div id="userName" class="jackPart"></div>
        SearchContext FirstShadowDOM = browser.findElement(By.cssSelector("#userName")).getShadowRoot();
        
        //Locate the Iframe in Shadow DOM and then search the element
        browser.switchTo().frame(FirstShadowDOM.findElement(By.cssSelector("#pact1")));
        browser.findElement(By.cssSelector("#glaf")).sendKeys("Girish Ramesh Bhujbal");
	}
}