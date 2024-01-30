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

public class ShadowDomElement
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
		browser.get("https://selectorshub.com/xpath-practice-page/");
		browser.manage().window().maximize();
        Thread.sleep(500);
        
        //Close the pop up message
        browser.findElement(By.xpath("//img[@title='Close']")).click();
        
        //<div id="userName" class="jackPart"></div>
        SearchContext shadow1 = browser.findElement(By.cssSelector("#userName")).getShadowRoot();
        shadow1.findElement(By.cssSelector("#kils")).sendKeys("Girish Bhujbal");

        //=====================================
        //Nested Shadow DOM - id=pizza is inside nested shadow DOM i.e. shadow0
        //<div id="app2" qaid="country"></div>
        SearchContext shadow2 = shadow1.findElement(By.cssSelector("#app2")).getShadowRoot();
        shadow2.findElement(By.cssSelector("#pizza")).sendKeys("Vadapav");
	
        // Element inside closed shadow DOM - Find the nearest top element (Here is Div tag with 'userPass' id)
        // then press Tab key to go to element inside closed shadow DOM
        browser.findElement(By.xpath("//div[@id='userPass']")).click();
        Actions mAct = new Actions(browser);
        mAct.sendKeys(Keys.TAB).perform();
        mAct.sendKeys("mypassword").perform();
        
        
        // Element inside Iframe and Shadow dom - Switch to ifrmae and Find the nearest top element
        // then press Tab key to go to element inside closed shadow DOM
        //browser.switchTo().frame(browser.findElement(By.xpath("//iframe[@id='pact']")));
	}
}