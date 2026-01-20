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
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Wrong number of arguments.\n"
				+ "Usage: java Parser <file path>");
			return ;
		}
	
		Parser	parser = new Parser(args[0]);
		if (!parser.isOk())
			return ;

		System.out.println(parser.getLines());
//		System.out.println();
//		System.out.println(parser.getAircraftPlans());

//		AircraftFactory	aircraftFactory = AircraftFactory.getInstance();
		List< Flyable >	flyables = new ArrayList<>();
		List< AircraftPlan >	aircraftPlans = parser.getAircraftPlans();
		// ListIterator< AircraftPlan >	it = aircraftPlans.listIterator();

		// while (it.hasNext()) {
			// AircraftPlan	aircraftPlan = it.next();
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

		weatherTower.changeWeather();
	}
}