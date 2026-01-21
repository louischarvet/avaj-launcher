package avajlauncher.flyable;

import avajlauncher.Coordinates;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void	updateConditions() {
		String	currentWeather = this.weatherTower.getWeather(this.coordinates);
		String	announcement = new String();
		String	previousCoordinates = this.coordinates.toString();

		switch (currentWeather) {
			case "RAIN":
				announcement = "I already took a shower this morning, thank you.";
				this.updateCoordinates(0, 0, -5);
				break;
			case "FOG":
				announcement = "What the fog ?";
				this.updateCoordinates(0, 0, -3);
				break;
			case "SUN":
				announcement = "Like father like sun ! I have to write this one.";
				this.updateCoordinates(2, 0, 4);
				break;
			case "SNOW":
				announcement = "It's so cold my balloon is retracting !";
				this.updateCoordinates(0, 0, -15);
				break;
			default:
				break;
		}

		System.out.println(
			this.getClass().getSimpleName() + "#" + this.getName()
			+ "(" + this.getId() + "): " + announcement
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