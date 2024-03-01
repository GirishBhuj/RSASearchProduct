package Learning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksChecking
{
    public static void main(String[] args)
    {
        // Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page you want to check
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links: " + links.size());

        // Iterate through each link and check its status
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyLink(url);
        }

        driver.quit();
    }

    private static void verifyLink(String url) {
        try {
            // Create a URL object
            URL linkURL = new URL(url);

            // Open a connection to the URL
            HttpURLConnection httpConn = (HttpURLConnection) linkURL.openConnection();

            // Set the timeout for the connection
            httpConn.setConnectTimeout(5000);

            // Connect to the URL
            httpConn.connect();           

            // Get the HTTP response code
            int responseCode = httpConn.getResponseCode();

            // Print the result based on the response code
            if (responseCode >= 200 && responseCode < 300) {
                System.out.println(url + " - " + "Link is valid");
            } else {
                System.out.println(url + " - " + "Link is broken with response code: " + responseCode);
                System.out.println(httpConn.getResponseMessage());
            }

            // Disconnect the connection
            httpConn.disconnect();

        } catch (IOException e) {
            System.out.println(url + " - " + "Link is broken with exception: " + e.getMessage());
        }
    }
}