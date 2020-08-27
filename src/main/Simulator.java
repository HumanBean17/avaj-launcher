package main;

import factory.AircraftFactory;
import flyable.Flyable;
import tower.WeatherTower;

import java.io.*;

public class Simulator {

    private static final String simulationFile = "simulation.txt";

    private Integer weatherChangesCount;
    private static final WeatherTower tower = new WeatherTower();

    private Flyable parseLine(String line) {
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
        }
        return AircraftFactory.newAircraft(type, name, longitude, latitude, height);
    }

    private void runInit(FileReader fileReader) throws IOException {
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

    public void run(String[] args) throws IOException {
        runInit(new FileReader(args[0]));
        while (weatherChangesCount > 0) {
            tower.changeWeather();
            weatherChangesCount--;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1)
            return;
        Simulator simulator = new Simulator();
        simulator.run(args);
    }
}
