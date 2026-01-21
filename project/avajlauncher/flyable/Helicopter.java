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
				announcement = "I like rain. Okamari no suzuki.";
				this.updateCoordinates(5, 0, 0);
				break;
			case "FOG":
				announcement = "Ninja fog, you can't see me !";
				this.updateCoordinates(1, 0, 0);
				break;
			case "SUN":
				announcement = "Sun is so overrated man.";
				this.updateCoordinates(10, 0, 2);
				break;
			case "SNOW":
				announcement = "Huh... my heart is colder than this.";
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

		if (this.coordinates.getHeight() <= 0) {
			this.flying = false;
			System.out.println(
				this.getClass().getSimpleName() + "#" + this.getName()
				+ "(" + this.getId() + ") landing."
			);
			this.weatherTower.unregister(this);
		} else
			this.flying = true;
	}
}