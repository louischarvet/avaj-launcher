package avajlauncher;

import java.util.List;
import java.util.ListIterator;

public class AircraftFactory {

	public AircraftFactory(List< String > parsedLines) {
		ListIterator< String >	it = parsedLines.listIterator(1);

		while (it.hasNext()) {
			String	splittedLine = it.next().split(" ");
			String	type = splittedLine[0],
				name = splittedLine[1];
			int	longitude = Integer.parseInt(splittedLine[2]),
				latitude = Integer.parseInt(splittedLine[3]),
				height = Integer.parseInt(splittedLine[4]);
			Coordinates	coordinates = new Coordinates(longitude, latitude, height);
			
		}
	}

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