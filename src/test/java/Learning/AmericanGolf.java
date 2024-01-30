package Learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmericanGolf {

	public static WebDriver browser;
	public static WebDriverWait wait;
	public static WebElement w1;
	public static List<WebElement> l1;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Point p1;
	public static JavascriptExecutor j1;

	
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
		browser.get("https://www.americangolf.co.uk");
		browser.manage().window().maximize();
	
		//Wait for title condition
		//System.out.println(browser.getTitle());
		//wait.until(ExpectedConditions.titleIs("American Golf · Europe's Largest Golf Retailer · Online & Instore"));
		
		//Check if Cookie Window present by the Accept Cookie button
		if (isCookieAcceptanceWindowPresent("//*[@id='termly-code-snippet-support']/div/div/div/div/div/div/div[2]/button[2]")) {
			browser.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div/div/div[2]/button[2]")).click();
		}
				
		
		//Hover over Golfs menu button
		w1 = browser.findElement(By.xpath("//*[@id='header-navigation']/div/ul/li[3]/a"));
		act = new Actions(browser);
		act.moveToElement(w1).build().perform();
		
		Thread.sleep(3000L);
		
		//Validate if Wedges text is present
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='CLUBS_1']/ul/li[1]/ul/li[7]/a/span"), "Wedges"));
		
		//Click on Wedges
		w1 = browser.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[1]/ul/li[7]/a/span"));
		act = new Actions(browser);
		act.moveToElement(w1).click();
		act.build().perform();

		if(isEmailSignUpPopUPPresent("/html/body/div[8]/div/div[1]"))
		{
			//Click on cross button
			browser.findElement(By.xpath("/html/body/div[8]/div/div[1]")).click();
			//Thread.sleep(2000L);
		}
		
		p = browser.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[2]/div[1]")).getLocation();
		//System.out.println(p.x+"--"+p.y);
		j = (JavascriptExecutor)browser;
		j.executeScript("window.scrollBy(76, 2200)", "");
		
		//Min Price of left point of the slider before sliding
		String priceMinBeforeSliding = browser.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[2]/div[1]")).getText();
		System.out.println("Min price before sliding is "+priceMinBeforeSliding);
		
		//Thread.sleep(2000L);
		
		//Move left point of slider from left to right
		w1 = browser.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[1]/div/div/div[1]/div"));
		act = new Actions(browser);
		//12 = price incrementend by 10
		//45 = price incrementend by 40
		act.dragAndDropBy(w1, 45, 0).build().perform();

		
		Thread.sleep(2000L);
		p1 = browser.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[2]/div[1]")).getLocation();
		System.out.println(p1.x+"--"+p1.y);
		j1 = (JavascriptExecutor)browser;
		j1.executeScript("window.scrollBy(76, 1200)", "");
		
		//Move right point of slider from right to left
		w1 = browser.findElement(By.xpath("//*[@id=\"secondary\"]/div[1]/div[8]/div/div/div[1]/div/div/div[3]/div"));
		act = new Actions(browser);
		act.dragAndDropBy(w1, -35,0).build().perform();
		
	
		//Min Price of left point of the slider after sliding
		String priceMinAfterSliding = browser.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[2]/div[1]")).getText();
		System.out.println("Min price after sliding is "+priceMinAfterSliding);
	}
	
	public static boolean isCookieAcceptanceWindowPresent(String xpathVal)
	{
		int x = browser.findElements(By.xpath(xpathVal)).size();
		if(x==1)
		{
			System.out.println("Cookie window present");
			return true;
		}
		else
		{
			System.out.println("Cookie window not present");
			return false;
		}
	}
	
	public static boolean isEmailSignUpPopUPPresent(String xpathVal) {
		int x = browser.findElements(By.xpath(xpathVal)).size();
		if(x==1) {
			System.out.println("Email Sign up window present");
			return true;
		}else {
			System.out.println("Email Sign up window not present");
			return false;
		}
	}
}