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

public class AlertExample {

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
		
		//WebDriver browser = WebDriverManager.chromedriver().create();
		//WebDriver browser = WebDriverManager.firefoxdriver().create();
		//WebDriver browser = WebDriverManager.edgedriver().create();
		//WebDriver browser = WebDriverManager.safaridriver().create();		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		browser = new ChromeDriver(options);
		
        /* 
        try {
    		WebDriver browser = WebDriverManager.chromedriver().capabilities(options).create();
    		browser = new ChromeDriver(options);        	
        } catch (NumberFormatException ex)
        {
        	ex.printStackTrace();
        }*/

		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //5 seconds wait will be applicable for all setps
		browser.get("https://rahulshettyacademy.com/AutomationPractice/");
		browser.manage().window().maximize();

		try 
		{
			//browser.findElement(By.xpath("//input[@id='alertbtn']")).click();
			browser.findElement(By.xpath("//input[@id='confirmbtn']")).click();

			Alert mAlert = browser.switchTo().alert();
			System.out.println(mAlert.getText());
			//mAlert.dismiss();
			mAlert.accept();
			//mAlert.sendKeys("");		
		} catch (NoAlertPresentException NoAlertExp)
		{
			NoAlertExp.printStackTrace();
		}
	}
}