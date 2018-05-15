package Imdb;

import java.util.List;

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
		//TODO: Clarify error with this xPath "Invalid XPath"
		String xPath = "//a[@href='fullcredits/?ref_=tt_ov_st_sm']";
		WebElement DetailsLink = driver.findElement(By.xpath(xPath));
		
		//TODO: Clarify this kind of assert
		//assert DetailsLink == null : String.format("Details link does not exist");
		if (DetailsLink != null)
			DetailsLink.click();
		
		if (driver.findElement(By.partialLinkText(director)).isDisplayed())
			return true;
		
		return false;
		
	}
	
	private static WebElement GetCorrectElement (By by, String textToFind) {
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			if (element.getText().contains(textToFind))
				return element;
		}
		return null;		
	}
	
	private static WebElement GetCorrectElement (By by, String textToFind, String textToFind2) {
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			if (element.getText().contains(textToFind) && element.getText().contains(textToFind2))
				return element;
		}
		return null;		
	}
}
