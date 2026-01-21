package avajlauncher;

public class Coordinates {
	private int	longitude;
	private int	latitude;
	private int	height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public Coordinates	newCoordinates(int p_longitude, int p_latitude, int p_height) {
		int	newLongitude = this.longitude + p_longitude;
//		if (newLongitude < 0)
//			newLongitude = 100 + (newLongitude % 100);
//		else if (newLongitude > 100)
//			newLongitude %= 100;
		
		int	newLatitude = this.latitude + p_latitude;
//		if (newLatitude < 0)
//			newLatitude = 100 + (newLatitude % 100);
//		else if (newLatitude > 100)
//			newLatitude %= 100;

		int	newHeight = this.height + p_height;
//		if (newHeight < 0)
//			newHeight = 0;
//		else if (newHeight > 100)
//			newHeight = 100;
		
		return new Coordinates(newLongitude, newLatitude, newHeight);
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

	public String	toString() {
		return new String(this.longitude + ", "
			+ this.latitude + ", " + this.height);
	}
}