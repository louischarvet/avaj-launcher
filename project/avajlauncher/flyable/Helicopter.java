package avajlauncher.flyable;

//import avajlauncher.Aircraft;
import avajlauncher.Coordinates;

import avajlauncher.WeatherProvider;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void	updateConditions() {
		String	currentWeather = this.weatherTower.getWeather(this.coordinates);
		String	announcement = new String();
		String	previousCoordinates = this.coordinates.toString();

		switch (currentWeather) {
			case "RAIN":
				announcement = "Helicopter rain ";
				this.updateCoordinates(5, 0, 0);
				break;
			case "FOG":
				announcement = "Helicopter fog ";
				this.updateCoordinates(1, 0, 0);
				break;
			case "SUN":
				announcement = "Helicopter sun ";
				this.updateCoordinates(10, 0, 2);
				break;
			case "SNOW":
				announcement = "Helicopter snow ";
				this.updateCoordinates(0, 0, -12);
				break;
			default:
				break;
		}

		System.out.println(
			this.getClass().getSimpleName() + "#" + this.getName()
			+ "(" + this.getId() + "): "
			+ announcement
		);

		System.out.println("\t" + previousCoordinates + " -> " + this.coordinates.toString());

		if (this.coordinates.getHeight() <= 0) {
			this.flying = false;
			System.out.println(
				this.getClass().getSimpleName() + "#" + this.getName()
				+ "(" + this.getId() + ") landing"
			);
		} else
			this.flying = true;
	}
}