import java.io.*;

public class Simulator {

    private Integer weatherChangesCount;
    private static final WeatherTower tower = new WeatherTower();


    private boolean runInit(FileReader fileReader) {
        String line;
        try (BufferedReader br = new BufferedReader(fileReader)) {
            if ((line = br.readLine()) != null) {
                weatherChangesCount = Integer.parseInt(line.split(" ")[0]);
                if (weatherChangesCount <= 0)
                    throw new BadWeatherChangesCountException();
            } else
                throw new EmptyFileException();
            while ((line = br.readLine()) != null) {
                Flyable aircraft = FileHandler.parseLine(line);
                aircraft.registerTower(tower);
                tower.register(aircraft);
            }
            if (tower.getObservers().isEmpty())
                throw new NoAircraftsProvidedException();
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void run(String[] args) {
        try {
            if (!runInit(new FileReader(args[0])))
                return;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        while (weatherChangesCount > 0) {
            tower.changeWeather();
            weatherChangesCount--;
        }
    }

    public static void main(String[] args) throws NoArgsException {
        if (args.length < 1)
            throw new NoArgsException();
        Simulator simulator = new Simulator();
        simulator.run(args);
        FileHandler.writeToFile("");
    }
}
