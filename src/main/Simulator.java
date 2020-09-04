package main;

import com.sun.org.apache.bcel.internal.generic.FADD;
import factory.AircraftFactory;
import flyable.Flyable;
import tower.WeatherTower;

import java.io.*;

public class Simulator {

    static private class BadCoordinatesException extends Throwable {

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

    static private class BadTypeException extends Throwable {

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

    private static final String simulationFile = "simulation.txt";
    private static boolean isFileExists = false;
    private static FileWriter fileWriter = null;

    private Integer weatherChangesCount;
    private static final WeatherTower tower = new WeatherTower();

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

    private void coordinatesValidation(Integer longitude, Integer latitude, Integer height) throws BadCoordinatesException {
        if (longitude < 0) {
            throw new BadCoordinatesException(longitude);
        } else if (latitude < 0) {
            throw new BadCoordinatesException(latitude);
        } else if (height < 0 || height > 100) {
            throw new BadCoordinatesException(height);
        }
    }

    private void typeValidation(String type) throws BadTypeException {
        type = type.toUpperCase();
        if (!(type.equals("HELICOPTER") || type.equals("JETPLANE") ||
        type.equals("BALLOON"))) {
            throw new BadTypeException(type);
        }
    }

    private Flyable parseLine(String line) throws BadCoordinatesException, BadTypeException {
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
            coordinatesValidation(longitude, latitude, height);
            typeValidation(type);
        }
        return AircraftFactory.newAircraft(type, name, longitude, latitude, height);
    }

    private void runInit(FileReader fileReader) throws IOException, BadCoordinatesException, BadTypeException {
        String line;
        try (BufferedReader br = new BufferedReader(fileReader)) {
            if ((line = br.readLine()) != null) {
                weatherChangesCount = Integer.parseInt(line.split(" ")[0]);
            }
            while ((line = br.readLine()) != null) {
                Flyable aircraft = parseLine(line);
                aircraft.registerTower(tower);
                tower.register(aircraft);
            }
        }
    }

    public void run(String[] args) throws IOException, BadCoordinatesException, BadTypeException {
        runInit(new FileReader(args[0]));
        while (weatherChangesCount > 0) {
            tower.changeWeather();
            weatherChangesCount--;
        }
    }

    public static void main(String[] args) throws IOException, BadCoordinatesException, BadTypeException {
        if (args.length < 1)
            return;
        Simulator simulator = new Simulator();
        simulator.run(args);
    }
}
