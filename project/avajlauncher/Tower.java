package avajlauncher;

import java.util.List;
import java.util.ArrayList;

import avajlauncher.flyable.Flyable;
import avajlauncher.flyable.Aircraft;

public class Tower {
	private List< Flyable >	observers;

	public Tower() {
		this.observers = new ArrayList<>();
	}

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);
		Aircraft	aircraft = (Aircraft) p_flyable;
//		String	announcement = ((Aircraft)p_flyable).getName()
		String	announcement = "Tower says:" + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") registered to weather tower.";

		System.out.println(announcement);
	}

	public void	unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);
		Aircraft	aircraft = (Aircraft) p_flyable;
//		String	announcement = ((Aircraft)p_flyable).getName()
		String	announcement = "Tower says:" + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") unregistered from weather tower.";

		System.out.println(announcement);
	}

	protected void	conditionChanged() {
		for (Flyable observer : this.observers)
			observer.updateConditions();
	}
}