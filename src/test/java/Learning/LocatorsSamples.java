package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsSamples {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //5 seconds wait will be applicable for all setps
		browser.get("https://rahulshettyacademy.com/locatorspractice");
		
		//<input type='text' placeholder='Username"  id="inputUsername" value="">
		//browser.findElement(By.id("inputUsername")).sendKeys("rahul");
		//CSS selector and ID
		//browser.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		browser.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("rahul");
		
		//<input type="password" placeholder="Password" name="inputPassword" value="">
		//browser.findElement(By.name("inputPassword")).sendKeys("password");
		//CSS selector and attribute with value
		//browser.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("password");
		
		// Using Xpath. //tagname[@attribute='value']
		browser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
	
		
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//browser.findElement(By.className("signInBtn")).click();
		//CSS selector
		browser.findElement(By.cssSelector("button.signInBtn")).click();

		
//		<input type='text' placeholder='Username"  id="inputUsername" value="">
//				<p class="error>
//
//				Class name : tagname.classname --> p.error
//					tagname#id --> input#inputUsername
//
//				CSS selector: syntax - tagname[attribute=value] --> input[placeholder='inputUsername']
				
		System.out.println(browser.findElement(By.cssSelector("p.error")).getText());
		browser.findElement(By.linkText("Forgot your password?")).click();

		/* Using Xpath with multiple instances. //tagname[@attribute='value'][index value]
		HTML code
			<form action="#">
					<h2>Forgot password</h2>
					<input type="text" placeholder="Name">
					<input type="text" placeholder="Email">
					<input type="text" placeholder="Phone Number"><br>
					<div class="forgot-pwd-btn-conainer">
					<button class="go-to-login-btn">Go to Login</button>
					<button class="reset-pwd-btn">Reset Login</button>
				</div>
			</form> 
 */
		browser.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Shri Ram");
		browser.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("shri.ram@bharat.com");
		browser.findElement(By.xpath("//input[@type='text'][2]")).clear();
		browser.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("shri.laxman@bharat.com");
	

//		<form action="#">
//			<h2>Forgot password</h2>
//			<input type="text" placeholder="Name">
//			<input type="text" placeholder="Email">
//			<input type="text" placeholder="Phone Number"><br>
//			<div class="forgot-pwd-btn-conainer">
//			<button class="go-to-login-btn">Go to Login</button>
//			<button class="reset-pwd-btn">Reset Login</button>
//			</div>
//		</form>
		// Enter value in phone number by travsering to phone number text box
		browser.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");		
	}
}