package avajlauncher.flyable;

//import avajlauncher.Aircraft;
import avajlauncher.Coordinates;

import avajlauncher.WeatherProvider;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	public void	updateConditions() {
		String	currentWeather = WeatherProvider.getCurrentWeather(this.coordinates);
		String	announcement = new String();

		switch (currentWeather) {
			case "RAIN":
				announcement = "Helicopter rain";
				this.updateCoordinates(0, 5, 0);
				break;
			case "FOG":
				announcement = "Helicopter fog";
				this.updateCoordinates(0, 1, 0);
				break;
			case "SUN":
				announcement = "Helicopter sun";
				this.updateCoordinates(0, 10, -2);
				break;
			case "SNOW":
				announcement = "Helicopter snow";
				this.updateCoordinates(0, 0, -7);
				break;
			default:
		}

		System.out.println(
			this.getType() + "#" + this.getName()
			+ "(" + this.getId() + "): "
			+ announcement
		);

		if (this.coordinates.getHeight() <= 0) {
			System.out.println(
				this.getType() + "#" + this.getName()
				+ "(" + this.getId() + ") landing"
			);
		}
	}
}