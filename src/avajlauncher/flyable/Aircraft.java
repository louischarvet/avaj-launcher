package avajlauncher.flyable;

import avajlauncher.Coordinates;

public abstract class Aircraft extends Flyable {
	protected long	id;
	protected String	name;
	protected Coordinates	coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
		this.flying = false;
	}

	protected void	updateCoordinates(int longitude, int latitude, int height) {
		this.coordinates = coordinates.newCoordinates(longitude, latitude, height);
	}

	public long	getId() {
		return this.id;
	}

	public String	getName() {
		return this.name;
	}

	public Coordinates	getCoordinates() {
		return this.coordinates;
	}
}