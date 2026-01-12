package avajlauncher;

import java.lang.Exception;

public class InvalidValueException extends Exception {
	private String	param;
	private String	value;
	private String	usage;

	public	InvalidValueException(String p_param, String p_value, String p_usage) {
		this.param = p_param;
		this.value = p_value;
		this.usage = p_usage;

		super("InvalidValueException: "
			+ this.param + " is " + this.value
			+ "\nUsage: " + this.usage);
	}
}