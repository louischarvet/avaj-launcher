package avajlauncher.flyable;

import avajlauncher.WeatherTower;

public abstract class Flyable {
	protected WeatherTower	weatherTower;
	public boolean	flying;

	public abstract void	updateConditions();

	public void	registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
	}
}