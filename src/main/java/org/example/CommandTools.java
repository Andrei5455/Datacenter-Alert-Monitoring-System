package org.example;

import java.io.PrintWriter;

public class CommandTools {
    private final Database database;
    private final PrintWriter pw;
    private final int lineIndex;

    public CommandTools(Database database, PrintWriter pw, int lineIndex) {
        this.database = database;
        this.pw = pw;
        this.lineIndex = lineIndex;
    }
    public Database getDatabase() {
        return database;
    }
    public PrintWriter pw() {
        return pw;
    }
    public int getLineIndex() {
        return lineIndex;
    }
}
