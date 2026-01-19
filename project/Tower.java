package avajlauncher;

import java.util.List;
import java.util.ArrayList;

import avajlauncher.flyable.Flyable;

public class Tower {
	private List< Flyable >	observers;

	public Tower() {
		this.observers = new ArrayList<>();
	}

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);
		String	announcement = "Tower says:" + p_flyable.getType()
			+ "#" + p_flyable.getName() + "(" + p_flyable.getId
			+ ") registered to weather tower.";

		System.out.println(announcement);
	}

	public void	unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);
		String	announcement = "Tower says:" + p_flyable.getType()
			+ "#" + p_flyable.getName() + "(" + p_flyable.getId
			+ ") unregistered from weather tower.";

		System.out.println(announcement);
	}

	protected void	conditionChanged();
}