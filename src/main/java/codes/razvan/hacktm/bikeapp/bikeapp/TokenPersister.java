package codes.razvan.hacktm.bikeapp.bikeapp;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TokenPersister {

    public static String token;
    private static File file;

    @SneakyThrows
    public static void load() {
        file = new File("bikeid.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        token = reader.readLine();
    }

}
