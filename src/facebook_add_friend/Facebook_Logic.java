package facebook_add_friend;

public class Facebook_Logic extends Facebook_Methods {
	private static final String URL = "https://www.facebook.com/";
	private static final String BROWSER = "Chrome";
	private static final String FRIEND_NAME = "Michel Palencia";
	private static final String FRIEND_DETAILS = "CECYT 5 \"BENITO JUAREZ\"";
	private static final String FUSER = "robert.glez.clase.selenium@gmail.com";
	private static final String FPASS = "Test_1234";
	
	public static void main(String[] args) {
		StartBrowser(BROWSER, URL);
		
		if (LoginSucceeds(FUSER, FPASS)) {
			System.out.println("We're in!");
			AddFriend(FRIEND_NAME, FRIEND_DETAILS);
		}else {
			System.out.println("Something went wrong : (");
			Babye();
		}		
	}	
}
