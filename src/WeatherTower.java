public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeatherCoordinates(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }
}
