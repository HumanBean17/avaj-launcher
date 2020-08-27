package flyable;

import coordinates.Coordinates;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Aircraft {

    protected Long id;
    protected String name;
    protected Coordinates coordinates;

    private Long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private Long nextId() {
        throw new NotImplementedException(); // TODO
    }
}
