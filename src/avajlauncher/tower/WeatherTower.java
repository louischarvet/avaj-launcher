package avajlauncher.tower;

import java.util.List;
import java.util.ListIterator;

import avajlauncher.Coordinates;
import avajlauncher.WeatherProvider;
import avajlauncher.flyable.Flyable;

public class WeatherTower extends Tower {
	public String	getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void	changeWeather() {
		this.conditionChanged();
	}
}