package tower;

import flyable.Aircraft;
import flyable.Flyable;

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
        System.out.println(towerSays + flyable.getFullName() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
