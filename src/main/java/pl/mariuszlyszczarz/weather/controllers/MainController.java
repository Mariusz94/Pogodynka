package pl.mariuszlyszczarz.weather.controllers;

import pl.mariuszlyszczarz.weather.models.SaveToFile;
import pl.mariuszlyszczarz.weather.models.services.WeatherService;
import pl.mariuszlyszczarz.weather.views.MainMenu;
import sun.applet.Main;

public class MainController {
    private WeatherService weatherService = WeatherService.getInstance();
    private SaveToFile saveToFile;

    public MainController() {
        saveToFile = new SaveToFile();
    }

    public void run() {
        //todo test
        System.out.println(weatherService.getWeather("Kraków"));

        MainMenu mainMenu = new MainMenu();
        mainMenu.printMenu();

        WeatherService weatherService = WeatherService.getInstance();
        String city = mainMenu.getCityFromUser();
        String result = weatherService.getWeather(city).toString();

        System.out.println(result);

        saveToFile.saveToFile(result, city);
    }
}
