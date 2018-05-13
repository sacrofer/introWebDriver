package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookAddFriend {

	static WebDriver driver; 

	public static void main(String[] args) { 

		//configurarNavegador 

		configurarNavegador(); 

		//login 

		logearFacebook("robert.glez.clase.selenium@gmail.com", "Test_1234"); 

		//buscar 

		buscarAmigo("mike hernandez"); 

		//agregar 

		agregarAmigo("nombreAmigo"); 
		
		destruirConfiguracion();

	} 


	private static void destruirConfiguracion() {
		//driver.close();
		
	}


	private static void configurarNavegador() {  

		System.setProperty("webdriver.chrome.driver", "C:\\testautomation\\libs\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.get("http://www.facebook.com"); 
		
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        
	} 

	private static void logearFacebook(String usuario, String password) { 
		WebElement campoUsuario; //id=email
		WebElement campoPassword; //id="pass"
		WebElement botonLogin; //data-testid="royal_login_button"
		
		campoUsuario = driver.findElement(By.id("email"));
		campoPassword = driver.findElement(By.id("pass"));
		botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usuario);
		campoPassword.clear();
		campoPassword.sendKeys(password);
		botonLogin.click();
	} 

	private static void agregarAmigo(String string) {
		

	}

	private static void buscarAmigo(String nameFriend) {
		WebElement search = driver.findElement(By.name("q"));
		search.clear();
		search.sendKeys(nameFriend);
		
		WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid=\"facebar_search_button\"]"));
		searchBtn.click();

	}


}
