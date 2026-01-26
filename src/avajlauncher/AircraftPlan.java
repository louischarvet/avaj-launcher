package avajlauncher;

import avajlauncher.Coordinates;

public class AircraftPlan {
	private String	type,
		name;
	private int	longitude,
		latitude,
		height;
	private	Coordinates	coordinates;			
	
	public AircraftPlan(String p_type, String p_name,
			int p_longitude, int p_latitude, int p_height) {
		this.type = p_type;
		this.name = p_name;
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;

		this.coordinates = new Coordinates(
			p_longitude,
			p_latitude,
			p_height
		);
	}

	public String	getType() {
		return this.type;
	}

	public String	getName() {
		return this.name;
	}

	public int	getLongitude() {
		return this.longitude;
	}

	public int	getLatitude() {
		return this.latitude;
	}

	public int	getHeight() {
		return this.height;
	}

	public Coordinates	getCoordinates() {
		return this.coordinates;
	}
}