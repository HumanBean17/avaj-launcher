public class Balloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates).toUpperCase();
        switch (currentWeather) {
            case "SUN":
                FileHandler.writeToFile(getFullName() + "Oh, that's hot.");
                coordinates.changeCoordinates(2, 0, 4);
                break;
            case "RAIN":
                FileHandler.writeToFile(getFullName() + "Damn you, rain!");
                coordinates.changeCoordinates(0, 0, -5);
                break;
            case "FOG":
                FileHandler.writeToFile(getFullName() + "So, fog isn't so bad. It could be snow.");
                coordinates.changeCoordinates(0, 0, -3);
                break;
            case "SNOW":
                FileHandler.writeToFile(getFullName() + "DAFUQ?? SNOW?? WE GONNA CRASH.");
                coordinates.changeCoordinates(0, 0 ,-15);
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
