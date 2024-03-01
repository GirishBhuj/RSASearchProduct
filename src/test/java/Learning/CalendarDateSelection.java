package Learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDateSelection {

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
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		/* WebDriver browser = WebDriverManager.chromedriver().capabilities(options).create();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //5 seconds wait will be applicable for all setps
		*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		browser = new ChromeDriver(options);
		
		browser.get("https://www.spicejet.com/");
		browser.manage().window().maximize();

        try {
            // Click on the departure date picker
            //WebElement departureDatePicker = browser.findElement(By.id("ctl00_mainContent_view_date1"));

        	WebElement departureDatePicker = browser.findElement
        			(By.xpath("//div[@class='css-1dbjc4n r-18u37iz']//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n']//*[name()='svg']")); 	
            departureDatePicker.click();

        	WebElement PreMonth = browser.findElement
        			(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-19bllq0 r-u8s1d r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle' and contains(@cx,'24.5')]")); 	
        	PreMonth.click();        	

            Thread.sleep(2000);

            WebElement desiredDate = browser.findElement
            		(By.xpath("//div[@class='css-1dbjc4n r-150rngu r-18u37iz r-16y2uox r-1wbh5a2 r-lltvgl r-buy8e9 r-1sncvnh']//div[2]//div[1]//div[3]//div[3]//div[5]//div[1]//div[1]"));
            desiredDate.click();

            // You may add further actions or assertions here if needed

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //browser.quit();
        }
	}
}