package pl.mariuszlyszczarz.weather.views;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {
    private Scanner scanner;

    public MainMenu() {
        scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("=-----------------------------=");
        System.out.println("=----Wtaj w  Pogodynce--------=");
    }

    public String getCityFromUser() {
        System.out.println("=----Podaj miasto: ");
        String city = scanner.nextLine();
        while (!Pattern.matches("[a-zA-Z]{1,}", city )) {
            city = scanner.nextLine();
        }
        return city;
    }

    public void cleanConsole(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public void sendMessageToConsole(String message) {
        System.out.println(message);
    }
}
