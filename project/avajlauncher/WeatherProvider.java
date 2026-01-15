package avajlauncher;

import java.util.Random;

// singleton

public class	WeatherProvider {
	private String	weather[];
	private int	weatherMap[][][];

	public WeatherProvider() { // private constructor
		this.weather = new String[4];
		this.weather[0] = "RAIN";
		this.weather[1] = "FOG";
		this.weather[2] = "SUN";
		this.weather[3] = "SNOW";

		Random	rand = new Random(); //

		this.weatherMap = new int[100][100][100]; //
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					this.weatherMap[i][j][k] = rand.nextInt(4);
				//	System.out.println("rand = " + this.weatherMap[i][j][k]);
				}
			}
		}
	}

	public String	getCurrentWeather(Coordinates p_coordinates) {
		int	longitude = p_coordinates.getLongitude(),
			latitude = p_coordinates.getLatitude(),
			height = p_coordinates.getHeight();
		int	weatherIndex = this.weatherMap[longitude][latitude][height];

		// en fonction des coordonnees, retourner la String correspondante
		return this.weather[weatherIndex];
	}
}