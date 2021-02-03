public class BadCoordinatesException extends Throwable {

        private final Integer coordinate;

        BadCoordinatesException(Integer coordinate) {
            this.coordinate = coordinate;
        }

        @Override
        public String toString() {
            return "BadCoordinates{" +
                    "coordinate=" + coordinate +
                    '}';
        }
    }