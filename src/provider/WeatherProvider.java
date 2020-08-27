package provider;

import coordinates.Coordinates;

public class WeatherProvider {

    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() { }

    public WeatherProvider getWeatherProvider() {
        return weatherProvider;
    }

    public String getCurrentWeatherCoordinates(Coordinates coordinates) {
        return null;
    }
}
