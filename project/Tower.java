package avajlauncher;

public class Tower {
	private List< Flyable* >	observers;

	public Tower() {
		this.observers = new ArrayList<>();
	}

	public void	register(Flyable* p_flyable) {
		this.observers.add(p_flyable);
	}

	public void	unregister(Flyable* p_flyable) {
		this.observers.remove(p_flyable);
	}

	protected void	conditionChanged();
}