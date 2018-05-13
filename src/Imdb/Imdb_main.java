package Imdb;

public class Imdb_main extends Imdb_Methods {

	public static void main(String[] args) {
		StartBrowser("Chrome", "http://imdb.com");
		SearchMovie("It");
	}
}
