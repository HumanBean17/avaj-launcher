package flyable;

import coordinates.Coordinates;
import tower.WeatherTower;

public class Balloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates);
        System.out.println(currentWeather);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
