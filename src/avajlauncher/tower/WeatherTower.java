package avajlauncher.tower;

import java.io.IOException;

import java.util.List;
import java.util.ListIterator;

import avajlauncher.WeatherProvider;

import avajlauncher.flyable.Coordinates;
import avajlauncher.flyable.Flyable;

public class WeatherTower extends Tower {
	public WeatherTower() {
		super();
	}

	public String	getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getCurrentWeather(p_coordinates);
	}

	public void	changeWeather() {
		this.conditionChanged();
	}
}