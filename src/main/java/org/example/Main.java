package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        Path inputFilePath = Paths.get(args[1] + ".in");
        Path outputFilePath = Paths.get(args[1] + ".out");
        int lineIndex = 0;
        try(Scanner sc = new Scanner(inputFilePath.toFile()) ; PrintWriter pw = new PrintWriter(outputFilePath.toFile())) {
            if (sc.hasNextLine())
                sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineIndex++;
                String[] tokens = line.split("\\|", -1);
                switch (tokens[0]) {
                    case "ADD SERVER":
                        try {
                            Location location = new Location.Builder(tokens[4]).setCity(tokens[5]).setAddress(tokens[6]).setLatitude(tokens[7]).setLongitude(tokens[8]).build();
                            User owner = UserFactory.create(tokens[9], tokens[10], tokens[11], tokens[12], tokens[13]);
                            Server server = new Server.Builder(tokens[2], location, owner).setHostName(tokens[1]).setStatus((ServerStatus.valueOf(tokens[3]))).setCpuCores(tokens[14]).setRamGb(tokens[15]).setStorageGb(tokens[16]).build();
                            database.addServer(server);
                            pw.println("ADD SERVER: " + tokens[2] + ": " + tokens[3]);
                            break;
                        } catch (MissingIpAddressException | UserException | LocationException e) {
                            pw.print("ADD SERVER: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                        break;
                    case "ADD GROUP":
                        try {
                            ResourceGroup group = new ResourceGroup(tokens[1]);
                            database.addResourceGroup((group));
                            pw.println("ADD GROUP: " + tokens[1]);
                        } catch (MissingIpAddressException e) {
                            pw.print("ADD GROUP: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                        break;
                    case "FIND GROUP":
                        try {
                            if (database.findGroup(tokens[1]))
                                pw.println("FIND GROUP: " + tokens[1]);
                            else pw.println("FIND GROUP: Group was not found: ipAddress = " + tokens[1]);
                        } catch (MissingIpAddressException e) {
                            pw.print("FIND GROUP: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                        break;
                    case "REMOVE GROUP":
                        try {
                            if (!database.findGroup(tokens[1]))
                                pw.println("FIND GROUP: Group was not found: ipAddress = " + tokens[1]);
                            else {
                                pw.println("REMOVE GROUP: " + tokens[1]);
                                database.removeResourceGroup(tokens[1]);
                            }
                        } catch (MissingIpAddressException e) {
                            pw.print("REMOVE GROUP: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                        break;
                    case "ADD MEMBER":
                        try {
                            if (!database.findGroup(tokens[1]))
                                pw.println("ADD MEMBER: Group was not found: ipAddress = " + tokens[1]);
                            else {
                                ResourceGroup targetGroup = database.getResourceGroup(tokens[1]);
                                User member = UserFactory.create(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
                                targetGroup.addMember(member);
                                pw.println("ADD MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                            }
                        } catch (MissingIpAddressException e) {
                            pw.print("ADD MEMBER: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                        break;
                    case "FIND MEMBER":
                        try {
                            if (!database.findGroup(tokens[1]))
                                pw.println("FIND MEMBER: Group was not found: ipAddress = " + tokens[1]);
                            else {
                                ResourceGroup targetGroup = database.getResourceGroup(tokens[1]);
                                if (targetGroup.findMember(tokens[2], tokens[3]) != null) {
                                    pw.println("FIND MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                                } else {
                                    pw.println("FIND MEMBER: Member not found: ipAddress = " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                                }
                            }
                        } catch (MissingIpAddressException | UserException e) {
                            pw.print("FIND MEMBER: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                        break;
                    case "REMOVE MEMBER":
                        try {
                            if (!database.findGroup(tokens[1]))
                                pw.println("REMOVE MEMBER: Group was not found: ipAddress = " + tokens[1]);
                            else {
                                ResourceGroup targetGroup = database.getResourceGroup(tokens[1]);
                                User targetMember = targetGroup.findMember(tokens[2], tokens[3]);
                                if (targetMember != null) {
                                    pw.println("REMOVE MEMBER: " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                                    targetGroup.removeMember(targetMember);
                                } else {
                                    pw.println("REMOVE MEMBER: Member not found: ipAddress = " + tokens[1] + ": name = " + tokens[2] + " && role = " + tokens[3]);
                                }
                            }
                        } catch (MissingIpAddressException | UserException e) {
                            pw.print("REMOVE MEMBER: " + e.getMessage());
                            pw.println(" ## line no: " + lineIndex);
                        }
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {

        }
        System.out.println(System.getProperty("user.dir"));
    }
}