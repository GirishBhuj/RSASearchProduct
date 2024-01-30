package Learning;
	import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class ListSelectionCode {
		private static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6)); //5 seconds wait will be applicable for all setps
			driver.get("https://shop.demoqa.com/");
			driver.navigate().to("https://shop.demoqa.com/?s=" + "dress" + "&post_type=product");

			WebElement WarningMsg = driver.findElement(By.cssSelector(".woocommerce-store-notice__dismiss-link"));	
			WarningMsg.click();

			
			List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
			items.get(0).click();
			
			WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
			addToCart.click();		

			try 
			{				
				Alert mAlert = driver.switchTo().alert();
				mAlert.dismiss();
				
				driver.findElement(By.cssSelector("#pa_color > option:nth-child(2)")).click();
			} catch (NoAlertPresentException NoAlertExp)
			{
				NoAlertExp.printStackTrace();
			}


			driver.findElement(By.cssSelector("option.attached:nth-child(4)")).click();

			driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
						
			//continueToCheckout
			driver.findElement(By.cssSelector(".pull-right > li:nth-child(3) > a:nth-child(1)")).click();		
			
			Thread.sleep(5000);
			
			driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Lakshay");
			
			driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Sharma");
			
			//First click on Country list and then enter India
			driver.findElement(By.cssSelector("#select2-billing_country-container")).click();
			driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("India");
			driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);

			WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
			address.sendKeys("Shalimar Bagh");
			
			WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
			postcode.sendKeys("110088");		

			driver.findElement(By.cssSelector("#billing_email")).sendKeys("test@gmail.com");
			
			driver.findElement(By.cssSelector("#billing_phone")).sendKeys("07438862327");
					
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("#select2-billing_state-container")).click();
			driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("Kerala");
			driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(Keys.ENTER);
			
			
			WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
			shipToDifferetAddress.click();
			Thread.sleep(3000);
			
			List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
			paymentMethod.get(0).click();
		
			
			driver.findElement(By.cssSelector("#terms.input-checkbox")).click(); //acceptTC
			
			driver.findElement(By.cssSelector("#place_order")).submit();
			driver.quit();
		}
	}