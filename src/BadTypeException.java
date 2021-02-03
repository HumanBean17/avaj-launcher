public class BadTypeException extends Throwable {

    private final String type;

    BadTypeException(String type) {
            this.type = type;
        }

    @Override
    public String toString() {
        return "BadType{" +
                    "type=" + type +
                    "}";
    }
}