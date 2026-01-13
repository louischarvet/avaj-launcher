package avajlauncher;

import java.lang.Exception;

public class InvalidValueException extends Exception {
	public	InvalidValueException(String p_param, String p_value, String p_usage) {
		super(p_param + " is " + p_value
			+ "\nUsage: " + p_usage);
	}
}