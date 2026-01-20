package avajlauncher;

import java.util.List;
import java.util.ListIterator;

import avajlauncher.flyable.Flyable;
import avajlauncher.WeatherProvider;

public class WeatherTower extends Tower {
	public String	getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void	changeWeather() {
		this.conditionChanged();
	}
}