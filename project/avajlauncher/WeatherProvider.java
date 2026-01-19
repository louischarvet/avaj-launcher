package avajlauncher;

import java.util.Random;

public final class	WeatherProvider {
	private static volatile WeatherProvider	instance = null;
	private static String	weather[] = {
		"RAIN",
		"FOG",
		"SUN",
		"SNOW"
	};
	private static int	weatherMap[][][] = new int[100][100][100];

	private WeatherProvider() { // private constructor
		super();

		setWeatherMap();
	}

	public final static WeatherProvider	getInstance() {
		if (WeatherProvider.instance == null) {
			synchronized(WeatherProvider.class) {
				if (WeatherProvider.instance == null)
					WeatherProvider.instance = new WeatherProvider();
			}
		}
		return WeatherProvider.instance;
	}

	private static void	setWeatherMap() {
		Random	rand = new Random();

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					WeatherProvider.weatherMap[i][j][k] = rand.nextInt(4);
				}
			}
		}
	}

	public String	getCurrentWeather(Coordinates p_coordinates) {
		int	longitude = p_coordinates.getLongitude(),
			latitude = p_coordinates.getLatitude(),
			height = p_coordinates.getHeight();
		int	weatherIndex = WeatherProvider.weatherMap[longitude][latitude][height];

		// en fonction des coordonnees, retourner la String correspondante
		return WeatherProvider.weather[weatherIndex];
	}
}