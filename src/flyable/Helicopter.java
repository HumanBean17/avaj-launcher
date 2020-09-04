package flyable;

import coordinates.Coordinates;
import main.Simulator;
import tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates).toUpperCase();
        switch (currentWeather) {
            case "SUN":
                Simulator.writeToFile(getFullName() + "Sunny today? Thanks, weatherman, have a nice day!");
                coordinates.changeCoordinates(10, 0, 2);
                break;
            case "RAIN":
                Simulator.writeToFile(getFullName() + "There is no bad weather.. Except of rain!");
                coordinates.changeCoordinates(5, 0, 0);
                break;
            case "FOG":
                Simulator.writeToFile(getFullName() + "There is one nice thing in fog, it sounds a bit like frog.");
                coordinates.changeCoordinates(1, 0, 0);
                break;
            case "SNOW":
                Simulator.writeToFile(getFullName() + "Let it snow!");
                coordinates.changeCoordinates(0, 0 ,-12);
                break;
        }
        if (coordinates.getHeight() <= 0) {
            Simulator.writeToFile(getFullName() + "Landing at " +
                    coordinates.getLongitude() + " " +
                    coordinates.getLatitude() + " " +
                    coordinates.getHeight());
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
