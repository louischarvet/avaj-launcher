package avajlauncher.tower;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import avajlauncher.flyable.Flyable;
import avajlauncher.flyable.Aircraft;

public class Tower {
	private List< Flyable >	observers;
	private ListIterator< Flyable >	iterator;

	public Tower() {
		this.observers = new ArrayList<>();
		this.iterator = null;
	}

	public void	register(Flyable p_flyable) {
		Aircraft	aircraft = (Aircraft) p_flyable;
		String	announcement = "Tower says: " + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") registered to weather tower.";

		this.observers.add(p_flyable);
		System.out.println(announcement);
	}

	public void	unregister(Flyable p_flyable) {
		Aircraft	aircraft = (Aircraft) p_flyable;
		String	announcement = "Tower says: " + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") unregistered from weather tower.";

		if (this.iterator != null && this.iterator.hasNext())
			this.iterator.remove();
		System.out.println(announcement);
	}

	protected void	conditionChanged() {
		System.out.println();
		this.iterator = this.observers.listIterator();

		while (this.iterator.hasNext()) {
			Flyable	observer = this.iterator.next();
			observer.updateConditions();
		}
	}
}