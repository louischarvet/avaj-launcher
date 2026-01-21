package avajlauncher;

import java.util.List;
import java.util.ListIterator;

import avajlauncher.flyable.Flyable;
import avajlauncher.flyable.Helicopter;
import avajlauncher.flyable.JetPlane;
import avajlauncher.flyable.Balloon;

public final class AircraftFactory {
	private static volatile	AircraftFactory instance = null;
	private	static long	id = 1;

	private AircraftFactory() {
		super();
	}

	// public final static AircraftFactory	getInstance() { // inutile ?
	// 	if (AircraftFactory.instance == null) {
	// 		synchronized(AircraftFactory.class) {
	// 			if (AircraftFactory.instance == null)
	// 				AircraftFactory.instance = new AircraftFactory();
	// 		}
	// 	}
	// 	return AircraftFactory.instance;
	// }

	public static Flyable	newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		switch (p_type) {
			case "Helicopter":
				return new Helicopter(AircraftFactory.id++, p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(AircraftFactory.id++, p_name, p_coordinates);
			case "Balloon":
				return new Balloon(AircraftFactory.id++, p_name, p_coordinates);
			default:
				return null;
		}
	}
}