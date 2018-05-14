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
	
	protected static WebElement LocateCorrectMovie(String movie, String year) {
		List<WebElement> Containers = driver.findElements(By.className("result_text"));
		
		for (WebElement container : Containers) {
			System.out.println(container.getText());
			if (container.getText().contains(movie) && container.getText().contains(year)) {
				container.findElement(By.linkText(movie)).click();
				return container;
			}
		}
		return null;
	}
	
	protected static void VerifyMovie (String movie, String year) {
		if (driver.getTitle().contains(movie) && driver.getTitle().contains(year)) {			
			System.out.println("Test Passed");
		}else {
			System.out.println("Test FAILED");
		}
	}
}
