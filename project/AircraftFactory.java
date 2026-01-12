package avajlauncher;

public class AircraftFactory {
	public Flyable*	newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		static long	id = 1;

		switch (p_type) {
			case "Helicopter":
				return new Helicopter(id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(id++, p_name, p_coordinates);
			case "Baloon":
				return new Baloon(id++, p_name, p_coordinates);
			default:
				return null;
		}
	}
}