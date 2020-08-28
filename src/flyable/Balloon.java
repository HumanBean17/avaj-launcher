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
        String currentWeather = weatherTower.getWeather(coordinates).toUpperCase();
        System.out.print(getFullName());
        switch (currentWeather) {
            case "SUN":
                System.out.println("Oh, that's hot.");
                coordinates.changeCoordinates(2, 0, 4);
                break;
            case "RAIN":
                System.out.println("Damn you, rain!");
                coordinates.changeCoordinates(0, 0, -5);
                break;
            case "FOG":
                System.out.println("So, fog isn't so bad. It could be snow.");
                coordinates.changeCoordinates(0, 0, -3);
                break;
            case "SNOW":
                System.out.println("DAFUQ?? SNOW?? WE GONNA CRASH.");
                coordinates.changeCoordinates(0, 0 ,-15);
                break;
        }
        if (coordinates.getHeight() <= 0) {
            System.out.println(getFullName() + "Landing at " +
                    coordinates.getLongitude() + " " +
                    coordinates.getLatitude() + " " +
                    coordinates.getHeight());
            //weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
