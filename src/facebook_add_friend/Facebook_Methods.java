package facebook_add_friend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Generics.Automation;

public class Facebook_Methods extends Automation {
	public static boolean LoginSucceeds(String usr, String pwd) {		
		WebElement campoUsuario = driver.findElement(By.id("email"));
		WebElement campoPassword = driver.findElement(By.id("pass"));
		WebElement botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usr);
		campoPassword.clear();
		campoPassword.sendKeys(pwd);
		botonLogin.click();
		
		String xPath = "//div[@data-click='profile_icon']";
		return (driver.findElement(By.xpath(xPath)).isDisplayed()) ? true : false;			
	}
	
	private static boolean NameExists(String name) {
		WebElement search = driver.findElement(By.name("q"));
		search.clear();
		search.sendKeys(name);
		
		try {
			WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid='facebar_search_button']"));
			searchBtn.click();
		} catch (Exception e) {
			System.out.println("Search button not found");
			e.printStackTrace();
			Babye();
		}
		
		return (driver.findElement(By.partialLinkText(name)).isDisplayed()) ? true : false;
	}
	
	public static void AddFriend(String name, String details) {
		if (NameExists(name)) {
			System.out.println("Name found");
			String xPath = "//div[contains(@class, '_2yer')]";
			WebElement myFriend = GetCorrectElement(By.xpath(xPath), details);			
			
			if (myFriend != null) {
				xPath = "//button[contains(@class, 'FriendRequestAdd')]";
				myFriend.findElement(By.xpath(xPath)).click();
				System.out.println("Congratulations!\nYou have sent a friend request to: " + name + " / " + details);
				Babye();
			} else {
				System.out.println("I found at least one " + name + " but none with these details: " + details);
				Babye();
			}
		}else {
			System.out.println("I couldn't find this name: " + name);
			Babye();
		}
	}
}
