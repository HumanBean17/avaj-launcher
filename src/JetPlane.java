public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = weatherTower.getWeather(coordinates).toUpperCase();
        switch (currentWeather) {
            case "SUN": {
                FileHandler.writeToFile(getFullName() + "Such a good weather, gonna be a very nice day today!");
                coordinates.changeCoordinates(0, 10, 2);
                break;
            }
            case "RAIN": {
                FileHandler.writeToFile(getFullName() + "Hopefully i don't need umbrella.");
                coordinates.changeCoordinates(0, 5, 0);
                break;
            }
            case "FOG": {
                FileHandler.writeToFile(getFullName() + "Tower says it's foggy today, i should land carefully.");
                coordinates.changeCoordinates(0, 1, 0);
                break;
            }
            case "SNOW": {
                FileHandler.writeToFile(getFullName() + "Hat wasn't a mistake, thanks mom!");
                coordinates.changeCoordinates(0, 0, -7);
                break;
            }
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
