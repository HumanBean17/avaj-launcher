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

    public void changeCoordinates(Integer longitude, Integer latitude, Integer height) {
        this.longitude += longitude;
        this.latitude += latitude;
        this.height += height;
        this.height = height > 100 ? 100 : height;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
