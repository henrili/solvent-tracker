package linde.solventTracker.objects;

public class Solvent {

	public static final Solvent BLANK = new Solvent("", "");
	public final String code;
	public final String name;

	private Solvent(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
