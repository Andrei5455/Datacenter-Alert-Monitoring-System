package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        Path inputFilePath = Paths.get(args[1] + ".in");
        Path outputFilePath = Paths.get(args[1] + ".out");
        try(Scanner sc = new Scanner(inputFilePath.toFile()) ; PrintWriter pw = new PrintWriter(outputFilePath.toFile())) {
            if (sc.hasNextLine())
                sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split("\\|", -1);
                switch (tokens[0]) {
                    case "ADD SERVER":
                        Location location = new Location.Builder(tokens[4]).setCity(tokens[5]).setAddress(tokens[6]).setLatitude(tokens[7]).setLongitude(tokens[8]).build();
                        User owner = UserFactory.create(tokens[9], tokens[10], tokens[11], tokens[12], tokens[13]);
                        Server server = new Server.Builder(tokens[2], location, owner).setHostName(tokens[1]).setStatus((ServerStatus.valueOf(tokens[3]))).setCpuCores(tokens[14]).setRamGb(tokens[15]).setStorageGb(tokens[16]).build();
                        database.addServer(server);
                        pw.println("ADD SERVER: " + tokens[2] + ": " + tokens[3]);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {

        }
        System.out.println(System.getProperty("user.dir"));
    }
}