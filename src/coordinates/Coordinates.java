package coordinates;

public class Coordinates {

    private Integer longitude;
    private Integer latitude;
    private Integer height;

    public Coordinates(Integer longitude, Integer latitude, Integer height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getHeight() {
        return height;
    }
}
