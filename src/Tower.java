import java.util.LinkedList;
import java.util.List;

public class Tower {

    private List<Flyable> observers;
    private static final String towerSays = "Tower says: ";

    public Tower() {
        this.observers = new LinkedList<>();
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
        FileHandler.writeToFile(towerSays + flyable.getFullName() + "registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        FileHandler.writeToFile(towerSays + flyable.getFullName() + "unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        List<Flyable> landed = new LinkedList<>();
        for (Flyable flyable : observers) {
            flyable.updateConditions();
            if (flyable.isLanded()) {
                landed.add(flyable);
            }
        }
        for (Flyable flyable : landed) {
            unregister(flyable);
        }
    }

    public List<Flyable> getObservers() {
        return observers;
    }
}
