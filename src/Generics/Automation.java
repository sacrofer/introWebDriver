package Generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation {
	protected static WebDriver driver = null;
	
	private static boolean OpenUrl (String url) {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
			
			if (!url.isEmpty()) {
				driver.get(url);
				return true;
			}else {
				System.out.println("URL cannot be empty");
				System.exit(-1);
				return false;			
			}
		}else {
			System.out.println("Driver is not initialized");
			System.exit(-1);
			return false;
		}
	}
	
	private static void SetupDriver (String browser) {		
		switch (browser){
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\testautomation\\libs\\drivers\\chromedriver.exe");
			    driver = new ChromeDriver();
			    break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\testautomation\\libs\\drivers\\geckodriver.exe");
		        driver = new FirefoxDriver();
		        break;
			default:
				System.out.println("Driver cannot be initialized");
				driver = null;
				System.exit(-1);
				break;		
		}
	}
	
	protected static void StartBrowser (String browser, String url) {
		
		try {
			SetupDriver(browser);
			OpenUrl(url);
		}catch (Exception e){
			System.out.println("An error happened trying to open the url");
			System.exit(-1);

		}
	}

}
