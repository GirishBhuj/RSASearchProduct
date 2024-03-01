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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableElement {

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
		
		WebDriver browser = WebDriverManager.chromedriver().capabilities(options).create();

		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //5 seconds wait will be applicable for all setps
		browser.get("https://jqueryui.com/resources/demos/resizable/default.html");
		browser.manage().window().maximize();

		WebElement mResizableEle = browser.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions mActions = new Actions(browser);
		mActions.dragAndDropBy(mResizableEle, 150,150).perform();
	}
}