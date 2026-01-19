package avajlauncher.flyable;

import avajlauncher.WeatherTower;

public interface Flyable {
	protected WeatherTower	weatherTower;

	public abstract void	updateConditions();

	public	registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
//		p_tower.register(this);
	}
}