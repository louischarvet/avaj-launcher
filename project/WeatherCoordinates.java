package avajlauncher;

public abstract class WeatherCoordinates extends Coordinates {
	private	String weather;

	default	WeatherCoordinates(String p_weather, int p_longitude, int p_latitude, int p_height) {
		super(p_longitude, p_latitude, p_height);
		this.weather = p_weather;
	}

	public int	getWeather() {
		return weather;
	}
}