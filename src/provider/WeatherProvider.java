package provider;

import coordinates.Coordinates;

public class WeatherProvider {

    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() { }

    public static WeatherProvider getWeatherProvider() {
        return weatherProvider;
    }

    public String getCurrentWeatherCoordinates(Coordinates coordinates) {
        return weather[(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4];
    }
}
