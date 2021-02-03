public class Validation {

    public static void coordinatesValidation(Integer longitude, Integer latitude, Integer height) throws BadCoordinatesException {
        if (longitude < 0) {
            throw new BadCoordinatesException(longitude);
        } else if (latitude < 0) {
            throw new BadCoordinatesException(latitude);
        } else if (height < 0 || height > 100) {
            throw new BadCoordinatesException(height);
        }
    }

    public static void typeValidation(String type) throws BadTypeException {
        type = type.toUpperCase();
        if (!(type.equals("HELICOPTER") || type.equals("JETPLANE") ||
                type.equals("BALLOON"))) {
            throw new BadTypeException(type);
        }
    }

}
