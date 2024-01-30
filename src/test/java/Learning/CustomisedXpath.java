package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomisedXpath {
	public static WebDriverWait wait;
	public static Actions act;
	public static WebElement w1;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
	
		
		WebDriver browser = new ChromeDriver(options);
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //5 seconds wait will be applicable for all setps
		browser.get("https://mail.rediff.com/cgi-bin/login.cgi");
		browser.manage().window().maximize();

        
        //Implicit Wait
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Explicit Wait
		wait  = new WebDriverWait(browser, Duration.ofSeconds(20));
        
		//Validate that the text "username" is present for username edit box - using text() function of xpath
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text() = 'Username']"), "Username"));
		
        //Type on Username
		browser.findElement(By.xpath("//*[@id='login1']")).sendKeys("selenium.testmay2017");
        
        //Validate that the text "password" is present for password edit box
      	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text() = 'Password']"), "Password"));
      		
        //Type on Passwords
      	browser.findElement(By.xpath("//*[@id='password']")).sendKeys("test@1234");
      	
      	//Validate for a attribute value in Sign In button - customised with compound class for xpath 
      	wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@class='floatL leftwidth']/div[2]/div[2]/div[2]/div[1]/input[2]"), "name", "proceed"));
      	
      	//Click on sign button Customised xpath with AND or OR logic
      	browser.findElement(By.xpath("//input[@type = 'submit' and @value = 'Sign in']")).submit();
	
      	
      	//Validate that "write mail" text is present
      	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//b[text() = 'Write mail']"), "Write mail"));
      	
      	
      	//Click on Write Mail link
      	//driver.findElement(By.className("rd_active")).click();
      	
      	//If page does not open like in line 54, use the Actions class to simulate mouse movement and Keystrokes
      	//Click using Actions class
      	//When using actions class, use the build() method to build the simulation
      	//Also use the perform() method to perform the simulation
      	//If  build() method and perform() method not used, will show error
      	act = new Actions(browser);
      	w1 = browser.findElement(By.xpath("//b[text() = 'Write mail']"));
      	act.moveToElement(w1).click();
      	act.build().perform();
      	
      	
      	
    	//Validate that "To:" text is present
      	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[@class = 'lbl-link rd_lbl_addr_to']"), "To:"));
      	
      	//Type on To field
      	//driver.findElement(By.xpath("//li[@id='as-original-TO_IDcmp3']/input[1]")).clear(); 
      	//driver.findElement(By.xpath("//li[@id='as-original-TO_IDcmp3']/input[1]")).sendKeys("kaushik.aryaan@gmail.com");
      	browser.findElement(By.xpath("//input[starts-with(@id, 'TO_IDcmp')]")).clear(); 
      	browser.findElement(By.xpath("//input[starts-with(@id, 'TO_IDcmp')]")).sendKeys("kaushik.aryaan@gmail.com");
      	browser.findElement(By.xpath("//input[starts-with(@id, 'TO_IDcmp')]")).sendKeys(Keys.RETURN);
      	
        //Validate that "Subject:" text is present
      	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//label[text() = 'Subject:']"), "Subject:"));
      	
        //Type on Subject field
      	browser.findElement(By.xpath("//input[contains(@class, 'rd_inp_sub rd_subject_datacmp')]")).clear();
      	browser.findElement(By.xpath("//input[contains(@class, 'rd_inp_sub rd_subject_datacmp')]")).sendKeys("Mail Sending Subject");
	
      	//To write in Compose area , we need to switch to frame as compose area is inside frame
      	//Frame is a web page embedded inside another webpage
      	//Selenium has focus in main page as it has opened the main page
      	//To work on compose area, which is inside frame, we need to switch focus from main page to frame
      	//frame is created by iframe tag
      	/*
      	 * We can switch to frame by three methods:
      	 * 
      	 *  driver.switchTo().window(SessionID)
      	 *  a) driver.switchTo().frame(index Number) - index number starts with 0
      	 *  b) driver.switchTo().frame(id attribute value or name attribute value) - iframe's
      	 *  id attribute or name attribute
      	 *  c) driver.switchTo().frame(WebElement w) - by the address of the frame. Address
      	 *  can be kept in WebElement interface by all 8 locators)
      	 *  
      	 * 
      	 * 
      	 */
      	
      	//Switch to the frame by address
      	w1  = browser.findElement(By.xpath("//iframe[@class = 'cke_wysiwyg_frame cke_reset']"));
      	browser.switchTo().frame(w1);
    	
      	
      	//Type on compose area after switching to frame
      	browser.findElement(By.xpath("/html/body")).sendKeys("Email Sending...");
      	
      	//Get the focus back to main page from frame
      	browser.switchTo().defaultContent();
      	
      	
        //Validate that "Send" text is present
      	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Send"), "Send"));
      	
      	
      	//Click on Send link
      	browser.findElement(By.linkText("Send")).click();
      	
        //Validate that "Logout" text is present
      	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("Logout"), "Logout"));
      	
      	//Click on Logout link
      	browser.findElement(By.partialLinkText("out")).click();
      	
      	//Close the app
      	//browser.quit(); 	
	}

}
