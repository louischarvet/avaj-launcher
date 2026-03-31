package avajlauncher.flyable;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void	updateConditions() {
		String	currentWeather = this.weatherTower.getWeather(this.coordinates);
		String	announcement = new String();
		String	previousCoordinates = this.coordinates.toString();

		switch (currentWeather) {
			case "RAIN":
				announcement = "Mum, it's raining, please make it stop.";
				this.updateCoordinates(5, 0, 0);
				break;
			case "FOG":
				announcement = "I can't see anything ! Where did the world go ?";
				this.updateCoordinates(0, 1, 0);
				break;
			case "SUN":
				announcement = "Oh, someone finally changed the light bulb.";
				this.updateCoordinates(0, 10, -2);
				break;
			case "SNOW":
				announcement = "Did I let the fridge open ?";
				this.updateCoordinates(0, 0, -7);
				break;
			default:
				break;
		}

		this.weatherTower.report(this.getClass().getSimpleName() + "#" + this.getName()
			+ "(" + this.getId() + "): " + announcement);

		if (this.coordinates.getHeight() <= 0) {
			this.flying = false;
			this.weatherTower.report(
				this.getClass().getSimpleName() + "#" + this.getName()
				+ "(" + this.getId() + ") landing."
			);
			this.weatherTower.unregister(this);
		} else
			this.flying = true;
	}
}