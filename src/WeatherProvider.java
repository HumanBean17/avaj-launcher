import java.util.Random;

public class WeatherProvider {

    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static final Random rand = new Random();

    private WeatherProvider() { }

    public static WeatherProvider getWeatherProvider() {
        return weatherProvider;
    }

    public String getCurrentWeatherCoordinates(Coordinates coordinates) {
        return weather[abs(rand.nextInt()) % 4];
    }

    int abs(int i) {
        return i < 0 ? -i : i;
    }
}
