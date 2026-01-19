package avajlauncher.flyable;

//import avajlauncher.Flyable;
import avajlauncher.Coordinates;

public abstract class Aircraft implements Flyable {
	protected long	id;
	protected String	name;
	protected Coordinates	coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	protected void	updateCoordinates(int longitude, int latitude, int height) {
		this.coordinates = coordinates.newCoordinates(longitude, latitude, height);
	}

	protected long	getId() {
		return this.id;
	}

	protected String	getName() {
		return this.name;
	}

	protected Coordinates	getCoordinates() {
		return this.coordinates;
	}
}