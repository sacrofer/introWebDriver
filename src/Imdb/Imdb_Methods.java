package Imdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Generics.Automation;

public class Imdb_Methods extends Automation {
		
	protected static void SearchMovie(String movie, String year) {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys(movie);
		
		WebElement searchBtn = driver.findElement(By.id("navbar-submit-button"));
		searchBtn.click();
		
		LocateCorrectMovie(movie, year);
	}
	
	protected static void LocateCorrectMovie(String movie, String year) {
		By by = By.className("result_text");
		WebElement correctElement = GetCorrectElement(by, movie, year);
		
		if (correctElement != null) {
			correctElement.findElement(By.linkText(movie)).click();
			System.out.println(movie + " from " + year + " found");
		}else{
			System.out.println("Test FAILED - " + movie + " from " + year + " NOT found");
			Babye();
		}
	}
	
	protected static void VerifyMovie (String movie, String year, String director) {
		if (driver.getTitle().contains(movie) && driver.getTitle().contains(year)) {
			VerifyDirector(director);
		}else {
			System.out.println("Looking for movie by name and year failed");
			Babye();
		}
	}
	
	protected static void VerifyDirector(String director) {
		if (IsDirectorInMainPage(director)) {
			System.out.println("Test Passed");
		}else if(IsDirectorInDetails(director)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test FAILED - Director not found");
			Babye();
		}
	}

	private static boolean IsDirectorInMainPage(String director) {
		By xPath = By.xpath("//span[@itemprop='director']");
		
		WebElement correctElement = GetCorrectElement (xPath, director);		
		
		return (correctElement != null) ?  true :  false;
	}

	private static boolean IsDirectorInDetails(String director) {
		System.out.println("Director is not in main page let's try in the details");		
		String xPath = "//a[@href='fullcredits/?ref_=tt_ov_st_sm']";
		
		try {			
			WebElement DetailsLink = driver.findElement(By.xpath(xPath));			
			DetailsLink.click();
		} catch (Exception e) {
			e.printStackTrace();
			Babye();
		}
		xPath = "//*[contains(text(), 'Directed by')]/following-sibling::table[1]//a[contains(text(), '" + director + "')]";
		
		if (driver.findElement(By.xpath(xPath)).isDisplayed())
			return true;
		
		return false;		
	}	
}
