package avajlauncher.tower;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import avajlauncher.flyable.Flyable;
import avajlauncher.flyable.Aircraft;

public class Tower {
	private	Path	file;
	private List< String >	lines;

	private List< Flyable >	observers;
	private ListIterator< Flyable >	iterator;

	public Tower(){
		this.file = Paths.get("simulation.txt");
		this.lines = new ArrayList<>();

		this.observers = new ArrayList<>();
		this.iterator = null;
	}

	public void	register(Flyable p_flyable) {
		Aircraft	aircraft = (Aircraft) p_flyable;
		String	announcement = "Tower says: " + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") registered to weather tower.";

		this.observers.add(p_flyable);

		this.report(announcement);
	}

	public void	unregister(Flyable p_flyable) {
		Aircraft	aircraft = (Aircraft) p_flyable;
		String	announcement = "Tower says: " + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") unregistered from weather tower.";


		this.iterator.remove();

		this.report(announcement);
	}

	protected void	conditionChanged() {
		this.iterator = this.observers.listIterator();

		if (this.iterator.hasNext())
			this.lines.add("");

		while (this.iterator.hasNext()) {
			Flyable	observer = this.iterator.next();
			observer.updateConditions();
		}
	}

	public void	report(String announcement) {
		this.lines.add(announcement);
	}

	public void	write() {
		try {
			Files.write(
				file,
				lines,
				StandardOpenOption.TRUNCATE_EXISTING,
				StandardOpenOption.CREATE
			);
		} catch (IOException e) {
			System.err.println("Tower.write error: " + e.getMessage());
		}
	}
}