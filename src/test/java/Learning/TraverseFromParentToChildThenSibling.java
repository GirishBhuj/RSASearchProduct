package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraverseFromParentToChildThenSibling {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //5 seconds wait will be applicable for all setps
		browser.get("https://rahulshettyacademy.com/AutomationPractice");

		/* HTML Code - code will goto 'Login' button
		 * <div style="text-align: right;margin-top: -30px;">
	          <a href="https://www.rahulshettyacademy.com/"><button class="btn btn-primary">Home</button></a>
	          <button class="btn btn-primary">Practice</button>	
	          <button class="btn btn-primary">Login</button>
	          <button class="btn btn-primary">Signup</button>
      	</div>
		 */
		//
		System.out.println(browser.findElement(By.xpath("//header/div/a/button")).getText());
		System.out.println(browser.findElement(By.xpath("//header/div/button[1]")).getText());
		System.out.println(browser.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(browser.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());
	}

}
