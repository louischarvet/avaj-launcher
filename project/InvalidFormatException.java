package avajlauncher;

import java.lang.Exception;

public class InvalidFormatException extends Exception {
	private String	message;
	private String	usage;

	public InvalidFormatException(String p_message) {
		this.usage = "\n<Positive integer> // Number of iterations\n"
			+ "<Type> <Name> <Longitude> <Latitude> <Height> // Scenario for each aircraft\n"
			+ "...";
		this.message = p_message;

		super("InvalidFormatException: " + this.message + this.usage);
	}
}