package avajlauncher;

public class Coordinates {
	private int	longitude;
	private int	latitude;
	private int	height;

	default Coordinates(int p_longitude, int p_latitude, int p_height) {
	//	try {
	//		if (p_longitude < 0)
	//			throw new InvalidValueException("Coordinates constructor", "longitude", p_longitude);
	//		if (p_latitude < 0)
	//			throw new InvalidValueException("Coordinates constructor", "latitude", p_latitude);

			this.longitude = p_longitude;
			this.latitude = p_latitude;
			this.height = p_height;
	/*	} catch (InvalidValueException e) { // hors du constructeur
			e.print("Coordinates constructor");
		} */
	}

	public int	getLongitude() {
		return longitude;
	}
	public int	getLatitude() {
		return latitude;
	}
	public int	getHeight() {
		return height;
	}
}