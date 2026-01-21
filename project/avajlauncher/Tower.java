package avajlauncher;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import avajlauncher.flyable.Flyable;
import avajlauncher.flyable.Aircraft;

public class Tower {
	private List< Flyable >	observers;
	private ListIterator< Flyable >	removeIt;

	public Tower() {
		this.observers = new ArrayList<>();
		this.removeIt = null;
	}

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);
		Aircraft	aircraft = (Aircraft) p_flyable;
		String	announcement = "Tower says: " + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") registered to weather tower.";

		System.out.println(announcement);
	}

	public void	unregister(Flyable p_flyable) {
		// ListIterator< Flyable >	it = observers.listIterator(
			// observers.indexOf(p_flyable)
		// );
		if (this.removeIt != null) {
			this.removeIt.remove();
			this.removeIt = null;
		}
	//	this.observers.remove(p_flyable);
		Aircraft	aircraft = (Aircraft) p_flyable;
		String	announcement = "Tower says: " + aircraft.getClass().getSimpleName()
			+ "#" + aircraft.getName() + "(" + aircraft.getId()
			+ ") unregistered from weather tower.";

		System.out.println(announcement);
	}

	protected void	conditionChanged() {
		System.out.println();
		ListIterator< Flyable >	it = this.observers.listIterator();

		while (it.hasNext()) {
			Flyable	observer = it.next();
			observer.updateConditions();
			
			if (observer.flying == false) {
				removeIt = it;
				this.unregister(observer);
			}
		}
	}
}