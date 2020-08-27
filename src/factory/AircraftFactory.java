package factory;

import coordinates.Coordinates;
import flyable.*;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name,
                                      Integer longitude, Integer latitude, Integer height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "HELICOPTER":
                return new Helicopter(name, coordinates);
            case "BALLOON":
                return new Balloon(name, coordinates);
            case "JET_PLANE":
                return new JetPlane(name, coordinates);
        }
        return null;
    }
}
