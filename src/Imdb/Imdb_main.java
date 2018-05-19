package Imdb;

public class Imdb_main extends Imdb_Methods {

	private static final String URL = "http://imdb.com";
	private static final String BROWSER = "Chrome";
	private static final String MOVIE_NAME = "Stranger Things";
	private static final String MOVIE_YEAR = "2016";	
	private static final String MOVIE_DIRECTOR = "Matt Duffer";

	public static void main(String[] args) {
		StartBrowser(BROWSER, URL);
		SearchMovie(MOVIE_NAME, MOVIE_YEAR);
		VerifyMovie (MOVIE_NAME, MOVIE_YEAR, MOVIE_DIRECTOR);
		Babye();
	}
}
