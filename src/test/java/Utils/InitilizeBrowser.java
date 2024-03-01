package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InitilizeBrowser {
	public WebDriver mbrowser;
	public String mBrowserType;
	
	public WebDriver BrowserManager() throws IOException
	{
		String mURL ="";
		FileInputStream mfis = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\global.properties");
		
		Properties mProp = new Properties();
		mProp.load(mfis);

		// Use below code to run:
		//mvn test -Denv=QA -Dbrowser=Chrome -PFunctionalTest
		//mBrowserType = System.getProperty("browser");
		//String mEnv = System.getProperty("env");
		
		mBrowserType = mProp.getProperty("browser");		
		String mEnv = mProp.getProperty("env");

		if (mBrowserType == null)
		{
			mBrowserType = "Chrome";
		}
		
		switch (mEnv)
		{
			case "QA":
				mURL = mProp.getProperty("QAurl");
				break;
			case "PROD":
				mURL = mProp.getProperty("ProdUrl");
				break;
			default:
				mURL = mProp.getProperty("QAurl");
				break;				
		}
		
		/* if (mEnv.equals("QA"))
		{
			mURL = mProp.getProperty("QAurl");
		}
		else if (mEnv.equals("PROD"))
		{
			mURL = mProp.getProperty("ProdUrl");
		}
		else
		{
			mURL = mProp.getProperty("QAurl");
		} */
				
		//System.out.println("mURL "+ mURL);
		
		if (System.getProperty("SOP") == "TRUE")
		{
			System.out.println("mBrowserType :"+ mBrowserType);
		}
		
		if (mbrowser == null) // If one browser is already initialized then no need to open another browser
		{
			if (System.getProperty("SOP") == "TRUE")
			{
				System.out.println("InitilizeBrowser class object BrowserManager()");
			}
			switch (mBrowserType)
			{
				case "Chrome":
					//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
					mbrowser = new ChromeDriver();					
					break;
				case "Firefox":
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\resources\\geckodriver.exe");
					mbrowser = new FirefoxDriver();
					break;
				case "Edge":
					System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\resources\\msedgedriver.exe");					
					mbrowser = new EdgeDriver();
					break;
				default:
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
					mbrowser = new ChromeDriver();					
					break;					
			}
			//To set 5 second wait for all framework requests
			mbrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			mbrowser.get(mURL);
		}
		
		return mbrowser;
	}
}
