package Learning;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		//Use the arguments for Chrome -->https://github.com/GoogleChrome/chrome-launcher/blob/main/docs/chrome-flags-for-tools.md
		option.addArguments("--headless=new");
		
		ChromeDriver driver = new ChromeDriver(option);
		
		//Navigate to Google News
		driver.get("https://news.google.com/");
		
		//Get the title of landing page
		String titleLandingPage = driver.getTitle();
		System.out.println("Title of Landing page is "+titleLandingPage);
		
		Thread.sleep(3000L);
		
		
		//Click on First new  -LS Passes
		driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/main/div[2]/c-wiz/section/div[2]/div/div[4]/c-wiz/c-wiz/article/div[1]/div[1]/a")).click();

		//Get the window session id of all windows after action online 25
		Set<String> setWindowSessionId = driver.getWindowHandles();
		Iterator<String> iter = setWindowSessionId.iterator();
		String firstWindowSessionID = iter.next(); //Landing page - news.google.com
		System.out.println("Session ID of landing page "+firstWindowSessionID);
		String secondWindowSessionID = iter.next(); //Tabbed window - Right now Telengana CM news
		System.out.println("Session ID of tabbed page "+secondWindowSessionID);
		
		//Switch to Tabbed Window by session ID
		driver.switchTo().window(secondWindowSessionID);
		
		Thread.sleep(3000L);
		
		//Get the title of tabbed  window
		String titleTabbedPage = driver.getTitle();
		System.out.println("Title of Tabbed page is "+titleTabbedPage);
		
		
		//Close the browser
		driver.quit();		
	}
}