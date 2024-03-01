package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicXpath {

	public static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException 
	{
		String mUrl = "https://selectorshub.com/xpath-practice-page/";
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //5 seconds wait will be applicable for all setps


		ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=mr");
		browser = new ChromeDriver(options);
		
		browser.get(mUrl);
		browser.manage().window().maximize();
		
		if(browser.findElements(By.xpath("//*[@class='sgpb-popup-close-button-6']")).size() == 1)
		{
			browser.findElement(By.xpath("//*[@class='sgpb-popup-close-button-6']")).click();
		}

		js = (JavascriptExecutor)browser;
		js.executeScript("window.scrollBy(76, 1200)", "");
		
		/*
			<div id="tableWrapper" xpath="1">
			<table id="resultTable" class="table hover">
			<thead>
			<tr>
			<th class="checkbox-col" rowspan="1"><input id="ohrmList_chkSelectAll" name="chkSelectAll" type="checkbox" value=""></th>
			<th class="header" style="width: 33%;" rowspan="1"><a class="null" href="https://bit.ly/shub_training_udemy" target="_blank" rel="noopener">Username</a></th>
			<th class="header" style="width: 20%;" rowspan="1"><a class="null" href="https://bit.ly/shub_training_udemy" target="_blank" rel="noopener">User Role</a></th>
			<th class="header" style="width: 33%;" rowspan="1"><a class="null" href="https://bit.ly/shub_training_udemy" target="_blank" rel="noopener">Employee Name</a></th>
			<th class="header" style="width: 14%;" rowspan="1"><a class="null" href="https://bit.ly/shub_training_udemy" target="_blank" rel="noopener">Status</a></th>
			</tr>
			</thead>
			<tbody>
			<tr class="usr_acn">
			<td><input id="ohrmList_chkSelectRecord_25" name="chkSelectRow[]" type="checkbox" value="25"></td>
			<td class="left"><a href="https://bit.ly/shub_training_udemy" target="_blank" rel="noopener">Garry.White</a></td>
			<td class="left">ESS</td>
			<td class="left">Garry White</td>
			<td class="left">Enabled</td>
			</tr>
			<tr class="usr_acn">
			<td><input id="ohrmList_chkSelectRecord_16" name="chkSelectRow[]" type="checkbox" value="16"></td>
			<td class="left"><a href="https://bit.ly/shub_training_udemy" target="_blank" rel="noopener">Jasmine.Morgan</a></td>
			<td class="left" style="">ESS</td>
			<td class="left">Jasmine Morgan</td>
			<td class="left">Enabled</td>
			</tr>
			</tbody>
			</table>
			</div>
		 
		*/
		
		/*
		1) /../: This part moves up one level in the DOM hierarchy from the previously selected <a> element. It navigates from the <a> element to its parent element.
		2) following-sibling::td[3]: After moving up to the parent element with /../, this part selects the third <td> element that is a sibling of the parent element. Specifically, it selects the third <td> element occurring after the parent element in the document structure.
		 */
		System.out.println(browser.findElement(By.xpath("//a[contains(text(),'Joe.Root')]")).getText());
		System.out.println(browser.findElement(By.xpath("//a[contains(text(),'Joe.Root')]/../following-sibling::td[1]")).getText());
		System.out.println(browser.findElement(By.xpath("//a[contains(text(),'Joe.Root')]/../following-sibling::td[2]")).getText());
		System.out.println(browser.findElement(By.xpath("//a[contains(text(),'Joe.Root')]/../following-sibling::td[3]")).getText());

		// //input[@id='ohrmList_chkSelectRecord_21']/../following-sibling::td[2]
		// To find li item who dont have any attribute value in "https://practicetestautomation.com/practice-test-exceptions/"
		// //h5[contains(text(),'Test case 2')]/following-sibling::ol[1]/li[2]
	}
}