package sinatra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Generics.Automation;

public class SinatraMethods extends Automation {
	
	public static void ValidateSong(String title, int duration, String date, String lyrics) {
		String xPath = "//h1[text()='" + title + "']";		
		boolean titleIsDisplayed = driver.findElement(By.xpath(xPath)).isDisplayed();
		xPath = "//p [contains (text(), 'Release Date:')]";
		boolean dateIsDisplayed = driver.findElement(By.xpath(xPath)).getText().contains(date);
		
		WebElement weDate = driver.findElement(By.xpath(xPath));
		
		
		xPath = "//p [contains (text(), 'Length:')]";
		
		WebElement weLength = driver.findElement(By.xpath(xPath));		
		if (weLength.isDisplayed()) 
			System.out.println("The song has this date: " + weLength.getText());		
				
		xPath = "//pre";
		boolean lyricIsDisplayed = driver.findElement(By.xpath(xPath)).getText().contains(lyrics); 
		
		if (titleIsDisplayed && dateIsDisplayed && weLength.isDisplayed() && lyricIsDisplayed) {
			System.out.println("Song " + title + " was added");									
		}
	}

	public static void AddSong(String title, int duration, String date, String lyrics) {
		WebElement wTitle = driver.findElement(By.id("title"));
		wTitle.clear();
		wTitle.sendKeys(title);
		
		WebElement wduration = driver.findElement(By.id("length"));
		wduration.clear();		
		wduration.sendKeys(Integer.toString(duration));
		
		WebElement wDate = driver.findElement(By.id("released_on"));
		wDate.clear();	
		wDate.sendKeys(date);
		//In case that date box covers the rest of the buttons. We have to click somewhere else.
		//TODO select month year and day by clicking
		wTitle.click();
		
		WebElement wLyrics = driver.findElement(By.id("lyrics"));
		wLyrics.clear();	
		wLyrics.sendKeys(lyrics);
		
		String xPath = "//input[@type='submit']";
		driver.findElement(By.xpath(xPath)).click();
		
		System.out.println("Song sent");
	}

	public static void LoginToSinatra(String suser, String spass) {
		String xPath = "//a[@href='/login']";		
		driver.findElement(By.xpath(xPath)).click();
		
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys(suser);
		
		WebElement pass = driver.findElement(By.id("password"));
		pass.clear();
		pass.sendKeys(spass);
		
		xPath = "//input[@type='submit']";
		driver.findElement(By.xpath(xPath)).click();
		
		xPath = "//a[@href='/logout']";
		if (driver.findElement(By.xpath(xPath)).isDisplayed()) {
			System.out.println("We're in!");
			xPath = "//a[@href='/songs']";
			driver.findElement(By.xpath(xPath)).click();
			
			xPath = "//a[@href='/songs/new']";
			driver.findElement(By.xpath(xPath)).click();
		}else {
			System.out.println("Login failed");
			Babye();
		}
	}
}
