public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    boolean isLanded();
    String getFullName();
}
