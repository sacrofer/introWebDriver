package sinatra;

public class Sinatra extends SinatraMethods {
	private static final String URL = "http://songs-by-sinatra.herokuapp.com";
	private static final String BROWSER = "Chrome";
	private static final String SUSER = "frank";
	private static final String SPASS = "sinatra";
	private static final String TITLE = "Another song";
	private static final int DURATION = 120;
	private static final String DATE = "05/20/1943";
	private static final String LYRICS = "Just another song";

	public static void main(String[] args) {		
		
		StartBrowser(BROWSER, URL);	
		LoginToSinatra(SUSER, SPASS);
		AddSong (TITLE, DURATION, DATE, LYRICS);
		ValidateSong(TITLE, DURATION, DATE, LYRICS);
	}
}
