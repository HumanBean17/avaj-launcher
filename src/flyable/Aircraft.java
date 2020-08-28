package flyable;

import coordinates.Coordinates;

public class Aircraft {

    protected final Long id;
    protected final String name;
    private final String fullName;

    protected Coordinates coordinates;

    private static Long idCounter = 0L;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
        fullName = this.getClass().getSimpleName() + "#" + name + "(" + id + "): ";
    }

    public boolean isLanded() {
        return coordinates.getHeight() <= 0;
    }

    private Long nextId() {
        return idCounter++;
    }

    public String getFullName() {
        return fullName;
    }
}
