package pl.mariuszlyszczarz.weather.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class SaveToFile {
    private LocalDateTime localDateTime = LocalDateTime.now();

    public void saveToFile(String string, String city){
        File file =new File("D:\\Akademia kodu\\5.03.2018 Zajęcia\\Pogodynka - Copy\\src\\main\\java\\pl\\mariuszlyszczarz\\weather\\models\\Log.txt");

        String toPrint = "\r\n" + localDateTime.toString() + "     " +  string;

        try {
            Files.write(file.toPath(), toPrint.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
