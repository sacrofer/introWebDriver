package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddSongBySinatra {
	
	private static WebDriver driver;
	
	public static void main(String[] args) {
		
		String user="frank";
		String pwd="sinatra";
		String titulo="Moon River";
		int duracion= 120;
		String fecha="05/19/2018";
		String letra="Moon river, wider than a mile I'm crossin' you in style some day Old dream maker, you heartbreaker";
		
		navegarPagina();
		login(user,pwd);
		agregarCancion(titulo,duracion,fecha,letra);
		existeCancion(titulo,duracion,fecha,letra);
		cerrarNavegador();
		
	}

		private static void navegarPagina() {
			System.setProperty("webdriver.chrome.driver", "C:\\testautomation\\libs\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			driver.get("http://songs-by-sinatra.herokuapp.com/"); 
		}
		
		private static void login(String user, String pwd) {
			driver.findElement(By.xpath("//a[@href='/login']")).click();
			driver.findElement(By.id("username")).sendKeys(user);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
						
			if (driver.findElement(By.xpath("//a[@href='/logout']")).isDisplayed())
				   System.out.println("Login exitoso");
				  else {
				   System.out.println("Login no exitoso");
				   System.exit(-1);
			}
		}
	
		private static void agregarCancion(String titulo, int duracion, String fecha, String letra) {
			driver.findElement(By.xpath("//a[@href='/songs']")).click();
			driver.findElement(By.xpath("//a[@href='/songs/new']")).click();
			driver.findElement(By.id("title")).sendKeys(titulo);
			driver.findElement(By.id("length")).sendKeys(duracion + "");//se castea el campo
			driver.findElement(By.id("released_on")).sendKeys(fecha);
			driver.findElement(By.id("lyrics")).sendKeys(letra);
			driver.findElement(By.xpath("//input[@value='Save Song']")).click();
			
			
			
			
			
			
			
			
			
		}
		
		private static void existeCancion(String titulo, int duracion, String fecha, String letra) {
			
			//xpath de titulo de la canción agregada
			
			WebElement tituloCancionLbl = driver.findElement(By.xpath("//h1[text()='"+titulo+"']"));
			if(tituloCancionLbl.isDisplayed()) {
				System.out.println("La canción "+ tituloCancionLbl.getText() +" existe");
			}
			
			WebElement fechaCancionLbl = driver.findElement(By.xpath("//p[contains(text(),'Release Date')]"));
			if(fechaCancionLbl.isDisplayed()) {
				System.out.println("La fecha de la canción agregada "+ fechaCancionLbl.getText() +" existe");
				String date = transformDate(fecha);
				if (fechaCancionLbl.getText().contains(date)) {
					System.out.println("La cancion muestra la fecha correcta");					
				}else {
					System.out.println("La cancion no muestra la fecha correcta");
				}
			}
			
			WebElement duracionCancionLbl = driver.findElement(By.xpath("//p[contains(text(),'Length')]"));
			if(duracionCancionLbl.isDisplayed()) {
				System.out.println("La duración de la canción agregada "+ duracionCancionLbl.getText() +" existe");
				String duracionTransformada = transformarDuracion(duracion);
				if (duracionCancionLbl.getText().contains(duracionTransformada)) {
					System.out.println("La cancion muestra la duracion correcta");
				}else {
					System.out.println("La cancion no muestra la duracion correcta");
				}
			}
			
			
			WebElement letraCancionLbl = driver.findElement(By.xpath("//pre"));
			if(letraCancionLbl.isDisplayed()) {
				System.out.println("La letra de la canción agregada "+ letraCancionLbl.getText() +" existe");
			}
			
			WebElement borrarCancionBtn = driver.findElement(By.xpath("//input[@value='delete this song']"));
			if(borrarCancionBtn.isDisplayed()) {
				System.out.println("El botón Delete this song existe");
			}
			
			WebElement editarCancionLnk = driver.findElement(By.xpath("//a[text()='edit this song']"));
			if(editarCancionLnk.isDisplayed()) {
				System.out.println("El link Edit this song existe");
			}
			
			
		
		}

		
		private static String transformarDuracion(int duracion) {
			// TODO Auto-generated method stub
			return "";
		}

		private static String transformDate(String date) {
						
			String[] elementosFecha = date.split("/");
			String fecha = elementosFecha[1] + "";
			String[] meses = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
			
			int month = Integer.parseInt(elementosFecha[0]);
			
			fecha = fecha + meses[month] + " ";
			fecha = fecha + elementosFecha[2];
			
			return fecha;
		}

		private static void cerrarNavegador() {
		//driver.close();
		
		}

	

}
