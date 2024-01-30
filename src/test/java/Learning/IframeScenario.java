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

public class IframeScenario
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
		browser.get("https://selectorshub.com/iframe-scenario/");
		browser.manage().window().maximize();
        Thread.sleep(500);
        
        
        //Locate the Iframe and switch to frame
        browser.switchTo().frame(browser.findElement(By.xpath("//*[@id='pact1']")));
        browser.switchTo().frame(browser.findElement(By.xpath("//*[@id='pact2']")));
        browser.switchTo().frame(browser.findElement(By.xpath("//*[@id='pact3']")));

        
      //This element is inside 3 nested frames.
        //XPath for frame1 = //iframe[@id='pact1'];
        //XPath for frame2 = //iframe[@id='pact2'];
        //XPath for frame3 = //iframe[@id='pact3'];
        //XPath for inspectedElement = ;
        
        browser.findElement(By.xpath("//input[@id='glaf']")).sendKeys("Manju che (.)(.)");
	}
}