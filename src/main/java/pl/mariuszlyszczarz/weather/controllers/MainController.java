package pl.mariuszlyszczarz.weather.controllers;

import pl.mariuszlyszczarz.weather.models.SaveToFile;
import pl.mariuszlyszczarz.weather.models.services.ForNext5DaysWeather;
import pl.mariuszlyszczarz.weather.models.services.WeatherService;
import pl.mariuszlyszczarz.weather.views.MainMenu;

public class MainController {
    private WeatherService weatherService = WeatherService.getInstance();
    private ForNext5DaysWeather forNext5DaysWeather = ForNext5DaysWeather.getInstance();
    private SaveToFile saveToFile;
    private MainMenu mainMenu;
    private String result;
    private String city;
    private boolean exit;

    public MainController() {
        saveToFile = new SaveToFile();
        mainMenu = new MainMenu();
        exit = false;
    }

    public void run() {
        //todo test
        while (!exit) {
            mainMenu.printMenu();

            switch (mainMenu.getNumberMenu()) {
                case 1:
                    result = weatherService.getWeather(city).toString();
                    printAndSave();
                    break;
                case 2:
                    for (int i = 4; i < 39; i += 8) {
                        result = forNext5DaysWeather.getWeather(city, i).toString();
                        printAndSave();
                    }
                    break;
                case 0:
                    exit = true;
                    continue;
            }

            WeatherService weatherService = WeatherService.getInstance();
            city = mainMenu.getCityFromUser();
        }
    }

    public void printAndSave() {
        System.out.println(result);

        saveToFile.saveToFile(result, city);
    }
}
