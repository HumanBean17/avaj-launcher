package tower;

import flyable.Flyable;

import java.util.LinkedList;
import java.util.List;

public class Tower extends WeatherTower {

    private List<Flyable> observers;

    public Tower() {
        this.observers = new LinkedList<>();
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {

    }
}
