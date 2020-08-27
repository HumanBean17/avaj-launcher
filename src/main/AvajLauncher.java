package main;

import factory.AircraftFactory;
import flyable.Flyable;
import tower.Tower;

import java.io.*;

public class AvajLauncher {

    private static final String simulationFile = "simulation.txt";

    private Integer weatherChangesCount;

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
        Tower tower = new Tower();
        try (BufferedReader br = new BufferedReader(fileReader)) {
            if ((line = br.readLine()) != null) {
                weatherChangesCount = Integer.parseInt(line.split(" ")[0]);
            }
            while ((line = br.readLine()) != null) {
                tower.register(parseLine(line));
            }
        }
    }

    public void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }
        runInit(new FileReader(args[0]));
        while (weatherChangesCount > 0) {
            weatherChangesCount--;
        }
    }
}
