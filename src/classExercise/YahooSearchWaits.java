package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooSearchWaits {
	protected static WebDriver driver = null;
	protected static WebDriverWait wait;
	private static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	private static final String GENERIC_DRIVER_LOCATION = "C:\\testautomation\\libs\\drivers\\";
	private static final String CHROME_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "chromedriver.exe";

	public static void main(String[] args) {
		navigateToYahoo();
		searchKeyword("Selenium");
		validateSearchResults("Selenium");
		openLink ("selenium", 3);
		closeBrowser();
	}

	private static void navigateToYahoo() {
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
		System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_LOCATION);
	    driver = new ChromeDriver(ops);	
	    wait = new WebDriverWait(driver, 20);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://espanol.yahoo.com/");
	}

	private static void searchKeyword(String keyword) {
		//Searchbox id="uh-search-box"
		// button id="uh-search-button"
		WebElement searchTxt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uh-search-box")));
		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("uh-search-button")));
		
		searchTxt.clear();
		searchTxt.sendKeys(keyword);
		
		searchBtn.click();
	}

	private static void validateSearchResults(String string) {
		//Search results container: id='main'
		
	}

	private static void openLink(String keyword, int numlink) {
		// TODO Auto-generated method stub
		//results.get(numlink);
		
	}

	private static void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

}
