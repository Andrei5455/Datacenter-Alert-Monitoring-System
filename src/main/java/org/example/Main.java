package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = Database.getInstance();

        for (int i = 1; i < args.length; i++) {
            Path inputFilePath = Paths.get(args[i] + ".in");
            Path outputFilePath = Paths.get(args[i] + ".out");
            int lineIndex = 0;
            try (Scanner sc = new Scanner(inputFilePath.toFile()); PrintWriter pw = new PrintWriter(outputFilePath.toFile())) {
                if (sc.hasNextLine())
                    sc.nextLine();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    lineIndex++;
                    String[] tokens = line.split("\\|", -1);
                    Command command = CommandFactory.create(tokens[0]);
                    if (command == null) {
                        System.out.println("Unknown command");
                        continue;
                    }
                    CommandTools tools = new CommandTools(database, pw, lineIndex);
                    try {
                        command.execute(tokens, tools);
                    } catch (MissingIpAddressException | UserException | LocationException e) {
                        pw.println(tokens[0] + ": " + e.getMessage() + " ## line no: " + lineIndex);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + inputFilePath);
            }
        }
    }
}