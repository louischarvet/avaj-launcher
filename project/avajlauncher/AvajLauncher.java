package avajlauncher;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import avajlauncher.Parser;
import avajlauncher.AircraftPlan;

import avajlauncher.AircraftFactory;

import avajlauncher.flyable.Flyable;

import avajlauncher.WeatherProvider;

public class AvajLauncher {
	private static	Parser	parser = null;
	private static	List< Flyable >	flyables = new ArrayList<>();

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Wrong number of arguments.\n"
				+ "Usage: java Parser <file path>");
			return ;
		}
	
		parser = new Parser(args[0]);
		if (parser == null || !parser.isOk())
			return ;

//		List< Flyable >	flyables = new ArrayList<>();
		List< AircraftPlan >	aircraftPlans = parser.getAircraftPlans();

		WeatherTower	weatherTower = new WeatherTower();

		for (AircraftPlan aircraftPlan : aircraftPlans) {
			flyables.add(AircraftFactory.newAircraft(
				aircraftPlan.getType(),
				aircraftPlan.getName(),
				aircraftPlan.getCoordinates()
			));
		}

		for (Flyable flyable : flyables) {
			weatherTower.register(flyable);
			flyable.registerTower(weatherTower);
		}

		// run simulation
		int	n = parser.getNumberOfIterations();
		for (int i = 0; i < n; i++)
			weatherTower.changeWeather();
	}
}