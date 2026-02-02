package org.example;

import java.io.PrintWriter;

public record CommandTools(Database database, PrintWriter pw, int lineIndex) {}
