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
                FileHandler.writeToFile(getFullName() + "Sunny today? Thanks, weatherman, have a nice day!");
                coordinates.changeCoordinates(10, 0, 2);
                break;
            case "RAIN":
                FileHandler.writeToFile(getFullName() + "There is no bad weather.. Except of rain!");
                coordinates.changeCoordinates(5, 0, 0);
                break;
            case "FOG":
                FileHandler.writeToFile(getFullName() + "There is one nice thing in fog, it sounds a bit like frog.");
                coordinates.changeCoordinates(1, 0, 0);
                break;
            case "SNOW":
                FileHandler.writeToFile(getFullName() + "Let it snow!");
                coordinates.changeCoordinates(0, 0 ,-12);
                break;
        }
        if (coordinates.getHeight() <= 0) {
            FileHandler.writeToFile(getFullName() + "Landing at " +
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
