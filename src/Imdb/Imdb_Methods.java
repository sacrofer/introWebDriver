package Imdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Generics.Automation;

public class Imdb_Methods extends Automation {
	
	protected static void SearchMovie(String movie) {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys(movie);
	}
}
