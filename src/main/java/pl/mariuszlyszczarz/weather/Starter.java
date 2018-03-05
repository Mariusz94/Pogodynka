package pl.mariuszlyszczarz.weather;

import pl.mariuszlyszczarz.weather.controllers.MainController;
import pl.mariuszlyszczarz.weather.models.WeatherModel;

public class Starter {
    public static void main(String[] args) {
        new MainController().run();

    }
}
