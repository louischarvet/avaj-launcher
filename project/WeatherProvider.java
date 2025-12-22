package avajlauncher;

// singleton

public class	WeatherProvider {
	private String	weather[];

	private WeatherProvider() {
		this.weather = new String[4];
		this.weather[0] = "RAIN";
		this.weather[1] = "FOG";
		this.weather[2] = "SUN";
		this.weather[3] = "SNOW";
	}

	public String	getCurrentWeather(Coordinates p_coordinates) {
		int	index = 0;
		// en fonction des coordonnees, retourner la String correspondante
		return weather[index];
	}
}