package Generics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation {
	private static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	private static final String GENERIC_DRIVER_LOCATION = "C:\\testautomation\\libs\\drivers\\";
	private static final String CHROME_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "chromedriver.exe";
	private static final String FIREFOX_DRIVER_NAME = "webdriver.gecko.driver";
	private static final String FIREFOX_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "geckodriver.exe";
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
				ChromeOptions ops = new ChromeOptions();
		        ops.addArguments("--disable-notifications");
				System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_LOCATION);
			    driver = new ChromeDriver(ops);			    
			    break;
			case "Firefox":
				System.setProperty(FIREFOX_DRIVER_NAME, FIREFOX_DRIVER_LOCATION);
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
	
	protected static void Babye() {		
		driver.quit();
		System.exit(-1);
	}
	
	public static WebElement GetCorrectElement (By by, String textToFind) {
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			if (element.getText().contains(textToFind))
				return element;
		}
		return null;		
	}
	
	public static WebElement GetCorrectElement (By by, String textToFind, String textToFind2) {
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			if (element.getText().contains(textToFind) && element.getText().contains(textToFind2))
				return element;
		}
		return null;		
	}
}
