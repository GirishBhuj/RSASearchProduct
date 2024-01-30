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

public class ShadowDomInsideIframe
{

	public static WebDriver browser;
	public static WebDriverWait wait;
	public static WebElement w1;
	public static List<WebElement> l1;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Point p1;
	public static JavascriptExecutor j1;
	public Alert mAlert;

	
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
		browser.get("https://selectorshub.com/shadow-dom-in-iframe/");
		browser.manage().window().maximize();
        Thread.sleep(500);
        
        
        //Locate the Iframe and switch to frame
        browser.switchTo().frame(browser.findElement(By.xpath("//*[@id='pact']")));
        
        //Locate the shadow DOM
        //<div id="userName" class="jackPart"></div>
        SearchContext FirstShadowDOM = browser.findElement(By.cssSelector("#snacktime")).getShadowRoot();
        //FirstShadowDOM.findElement(By.cssSelector("#tea")).sendKeys("Nutan Girish Bhujbal");
        
        //https://www.youtube.com/watch?v=0R0erfuJ76g&t=42s
        JavascriptExecutor mJse = (JavascriptExecutor) browser;
        //RHC on element select inspect and then copy JS path
        WebElement mElement = (WebElement) mJse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
        
        
        String mJse1 = "arguments[0].setAttribute('value','Maju che galle')";
        mJse.executeScript(mJse1,mElement);

        System.out.println(mElement.getText());

        //Nested shadow DOM
        // Locate the first Shadow DOM then search second shadow DOM inside first Shadow DOM
        SearchContext SecondShadowDOM = FirstShadowDOM.findElement(By.cssSelector("#app2")).getShadowRoot();
        SecondShadowDOM.findElement(By.cssSelector("#pizza")).sendKeys("Vadapav");

	}
}