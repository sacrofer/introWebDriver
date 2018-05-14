package Imdb;

public class Imdb_main extends Imdb_Methods {

	private static final String MOVIE_NAME = "It";
	private static final String MOVIE_YEAR = "1990";
	private static final String URL = "http://imdb.com";
	private static final String BROWSER = "Chrome";

	public static void main(String[] args) {
		StartBrowser(BROWSER, URL);
		SearchMovie(MOVIE_NAME, MOVIE_YEAR);
		VerifyMovie (MOVIE_NAME, MOVIE_YEAR);
		driver.quit();
	}
}
