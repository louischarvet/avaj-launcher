package avajlauncher;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import avajlauncher.Parser;
import avajlauncher.AircraftPlan;

import avajlauncher.AircraftFactory;

import avajlauncher.flyable.Flyable;

import avajlauncher.tower.WeatherTower;

public class AvajLauncher {
	private static	Parser	parser = null;
	private static	List< Flyable >	flyables = new ArrayList<>();
	private static	WeatherTower	weatherTower = new WeatherTower();

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Wrong number of arguments.\n"
				+ "Usage: java Parser <file path>");
			return ;
		}
	
		parser = new Parser(args[0]);
		if (parser == null || !parser.isOk())
			return ;

		setFlyables(parser.getAircraftPlans());
		register();
		runSimulation(parser.getNumberOfIterations());
	}

	private static void	setFlyables(List< AircraftPlan > aircraftPlans) {
		for (AircraftPlan aircraftPlan : aircraftPlans) {
			flyables.add(AircraftFactory.newAircraft(
				aircraftPlan.getType(),
				aircraftPlan.getName(),
				aircraftPlan.getCoordinates()
			));
		}
	}

	private static void	register() {
		for (Flyable flyable : flyables) {
			weatherTower.register(flyable);
			flyable.registerTower(weatherTower);
		}
	}

	private static void	runSimulation(int n) {
		for (int i = 0; i < n; i++)
			weatherTower.changeWeather();
	}
}