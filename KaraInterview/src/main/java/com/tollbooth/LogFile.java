package com.tollbooth;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogFile {
	/*
	* Represents a file containing a number of log lines, converted to LogEntry
	* objects.
	*/
    List<LogEntry> logEntries;

    public LogFile(BufferedReader reader) throws IOException {

        this.logEntries = new ArrayList<>();

        String line = reader.readLine();

        while (line != null) {

            LogEntry logEntry = new LogEntry(line.strip());

            this.logEntries.add(logEntry);

            line = reader.readLine();
        }
    }

    public LogEntry get(int index) {
        return this.logEntries.get(index);
    }

    public int size() {
        return this.logEntries.size();
    }

    public int countJourneys() {

        int successJourneysCount = 0;

        // Vehicles currently on highway
        Set<String> activeVehicles = new HashSet<>();

        for (LogEntry entry : logEntries) {

            String licensePlate = entry.getLicensePlate();

            String boothType = entry.getBoothType();

            // ENTRY
            if (boothType.equals("ENTRY")) {

                activeVehicles.add(licensePlate);
            }

            // EXIT
            else if (boothType.equals("EXIT")) {

                if (activeVehicles.contains(licensePlate)) {

                    successJourneysCount++;

                    activeVehicles.remove(licensePlate);
                }
            }
        }

        return successJourneysCount;
    }
}