package pl.mariuszlyszczarz.weather.views;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {
    private Scanner scanner;
    private int numberMenu;

    public MainMenu() {
        scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("=-----------------------------=");
        System.out.println("=----Wtaj w  Pogodynce--------=");
        System.out.println("=----1 Aktualna pogoda--------=");
        System.out.println("=----2 Pogoda z zeszłych 5 dni=");
        System.out.println("=----3 Pogoda na przyszle 5 dni");
        while(!Pattern.matches("[123]", Integer.toString(numberMenu))) {
            numberMenu = Integer.parseInt(scanner.nextLine());
        }
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

    public int getNumberMenu() {
        return numberMenu;
    }
}
