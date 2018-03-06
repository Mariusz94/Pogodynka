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

    public MainController() {
        saveToFile = new SaveToFile();
        mainMenu = new MainMenu();
    }

    public void run() {
        //todo test
        while (true) {
            mainMenu.printMenu();

            WeatherService weatherService = WeatherService.getInstance();
            city = mainMenu.getCityFromUser();
            if (city.equals("exit")) break;
            switch (mainMenu.getNumberMenu()) {
                case 1:
                    result = weatherService.getWeather(city).toString();
                    printAndSave();
                    break;
                case 2:

                    break;
                case 3:
                    for (int i = 4; i < 39; i += 8) {
                        result = forNext5DaysWeather.getWeather(city, i).toString();
                        printAndSave();
                    }
                    break;
            }
        }
    }

    public void printAndSave() {
        System.out.println(result);

        saveToFile.saveToFile(result, city);
    }
}
