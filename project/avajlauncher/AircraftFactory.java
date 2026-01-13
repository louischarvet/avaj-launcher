package avajlauncher;

import java.util.List;
import java.util.ListIterator;

public class AircraftFactory {
	private	long	id;

	public AircraftFactory() {
		this.id = 1;
	}

	public Flyable	newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(this.id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(this.id++, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(this.id++, p_name, p_coordinates);
			default:
				return null;
		}
	}
}