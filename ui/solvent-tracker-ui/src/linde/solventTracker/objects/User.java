package linde.solventTracker.objects;

public class User {

	public static final User BLANK = new User("NTNU      ", "NONAME");
	public final String code;
	public final String name;

	public User(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public boolean isValidUser() {
		if (code == null || code.length() != 10)
			return false;
		if (name == null)
			return false;
		
		return true;
	}

}
