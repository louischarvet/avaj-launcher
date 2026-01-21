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
	private static WeatherMap	weatherMap = new WeatherMap(100, 100, 100);

	private WeatherProvider() {
		super();
	}

	// public final static WeatherProvider	getInstance() { // inutile ?
	// 	if (WeatherProvider.instance == null) {
	// 		synchronized(WeatherProvider.class) {
	// 			if (WeatherProvider.instance == null)
	// 				WeatherProvider.instance = new WeatherProvider();
	// 		}
	// 	}
	// 	return WeatherProvider.instance;
	// }

	public static String	getCurrentWeather(Coordinates p_coordinates) {
		int	longitude = normalizeCoordinate(p_coordinates.getLongitude()),
			latitude = normalizeCoordinate(p_coordinates.getLatitude()),
			height = normalizeCoordinate(p_coordinates.getHeight());
		int	index = WeatherProvider.getIndex(longitude, latitude, height);

		return WeatherProvider.weather[index];
	}

	private static int	normalizeCoordinate(int coordinate) {
		if (coordinate < 0)
			return 100 + (coordinate % 100);
		else if (coordinate >= 100)
			return coordinate % 100;
		else
			return coordinate;
	}

	private static int	getIndex(int longitude, int latitude, int height) {
		return WeatherProvider.weatherMap.getValue(longitude, latitude, height);
	}

	private static class WeatherMap {
		private	int	map[][][];

		public WeatherMap(int longitude, int latitude, int height) {
			this.map = new int[longitude][latitude][height];
			Random	rand = new Random();

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100; k++) {
						this.map[i][j][k] = rand.nextInt(4);
					}
				}
			}
		}

		public int	getValue(int longitude, int latitude, int height) {
			return this.map[longitude][latitude][height];
		}
	}
}