package avajlauncher;

import java.lang.Exception;

public class InvalidFormatException extends Exception {
	public InvalidFormatException(String p_message) {
		super(p_message
			+ "\n<Positive integer> // Number of iterations\n"
			+ "<Type> <Name> <Longitude> <Latitude> <Height> // Scenario for each aircraft\n"
			+ "...");
	}
}