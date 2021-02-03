import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private static final String simulationFile = "simulation.txt";
    private static boolean isFileExists = false;
    private static FileWriter fileWriter = null;

    public static boolean writeToFile(String info) {
        try {
            if (!isFileExists) {
                isFileExists = true;
                fileWriter = new FileWriter(simulationFile, false);
            }
            fileWriter.write(info);
            fileWriter.append('\n');
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public static Flyable parseLine(String line) throws BadCoordinatesException, BadTypeException {
        String[] splitLine = line.split(" ");
        if (splitLine.length != 5)
            throw new RuntimeException();
        String type = null;
        String name = null;
        int longitude = 0;
        int latitude = 0;
        int height = 0;
        for (int i = 0; i < splitLine.length; i++) {
            switch (i) {
                case 0: type = splitLine[0];
                case 1: name = splitLine[1];
                case 2: longitude = Integer.parseInt(splitLine[2]);
                case 3: latitude = Integer.parseInt(splitLine[3]);
                case 4: height = Integer.parseInt(splitLine[4]);
            }
            Validation.coordinatesValidation(longitude, latitude, height);
            Validation.typeValidation(type);
        }
        return AircraftFactory.newAircraft(type, name, longitude, latitude, height);
    }

}
