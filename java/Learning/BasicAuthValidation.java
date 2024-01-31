package Learning;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v87.network.Network;
import org.openqa.selenium.devtools.v87.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthValidation
{
	public static ChromeDriver browser;
	public static String mUserName ="admin";
	public static String mPassword ="admin";

	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome-114\\chromedriver.exe");	
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver ().clearCache();
		
		ChromeDriver mDriver = new ChromeDriver();
		
		String auth = mUserName +":"+mPassword;

        // Get the devtools from the running driver and create a session
        DevTools devTools = mDriver.getDevTools();
        devTools.createSession();
        
        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        String mEncodedString = Base64.getEncoder().encodeToString(auth.getBytes());
        System.out.println("Encoded string "+ mEncodedString);
        
        Map<String,Object> mHeaders = new HashMap<>();
        mHeaders.put("Authorization","Basic "+mEncodedString);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(mHeaders)));
        
        mDriver.get("https://the-internet.herokuapp.com/basic_auth");
	}
}