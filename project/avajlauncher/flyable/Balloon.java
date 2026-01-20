package avajlauncher.flyable;

//import avajlauncher.Aircraft;
import avajlauncher.Coordinates;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void	updateConditions() {
		// String	currentWeather = WeatherProvider.getCurrentWeather(this.coordinates);
		String	currentWeather = this.weatherTower.getWeather(this.coordinates);
		String	announcement = new String();

		switch (currentWeather) {
			case "RAIN":
				announcement = "Balloon rain";
				this.updateCoordinates(0, 0, -5);
				break;
			case "FOG":
				announcement = "Balloon fog";
				this.updateCoordinates(0, 0, 3);
				break;
			case "SUN":
				announcement = "Balloon sun";
				this.updateCoordinates(2, 0, 4);
				break;
			case "SNOW":
				announcement = "Balloon snow";
				this.updateCoordinates(0, 0, 15);
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
			System.out.println(
				this.getClass().getSimpleName() + "#" + this.getName()
				+ "(" + this.getId() + ") landing"
			);
		}
	}
}