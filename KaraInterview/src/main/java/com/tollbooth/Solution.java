package com.tollbooth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {

        testLogEntry();

        testLogFile();

        testCountJourneys();

        System.out.println("All Tests Passed Successfully");
    }

    public static void testLogEntry() {

        System.out.println("Running testLogEntry");

        String logLine = "44776.619 KTB918 310E MAINROAD";

        LogEntry logEntry = new LogEntry(logLine);

        assertEquals(44776.619f, logEntry.getTimestamp(), 0.0001f);

        assertEquals("KTB918", logEntry.getLicensePlate());

        assertEquals(310, logEntry.getLocation());

        assertEquals("EAST", logEntry.getDirection());

        assertEquals("MAINROAD", logEntry.getBoothType());

        logLine = "52160.132 ABC123 400W ENTRY";

        logEntry = new LogEntry(logLine);

        assertEquals(52160.132f, logEntry.getTimestamp(), 0.0001f);

        assertEquals("ABC123", logEntry.getLicensePlate());

        assertEquals(400, logEntry.getLocation());

        assertEquals("WEST", logEntry.getDirection());

        assertEquals("ENTRY", logEntry.getBoothType());
    }

    public static void testLogFile() throws IOException {

        System.out.println("Running testLogFile");

        try (
                BufferedReader reader =
                		new BufferedReader(new FileReader("src/main/resources/tollbooth_small.log"))
        ) {

            LogFile logFile = new LogFile(reader);

            System.out.println("Log Size: " + logFile.size());
        }
    }

    public static void testCountJourneys() throws IOException {

        System.out.println("Running testCountJourneys");

        try (
        		BufferedReader reader =
                new BufferedReader(
                        new FileReader("src/main/resources/tollbooth_small.log")
                );
        ) {

            LogFile logFile = new LogFile(reader);

            int journeys = logFile.countJourneys();

            System.out.println("Journey Count: " + journeys);

            assertEquals(3, journeys);
        }
    }

    // Custom assert methods

    public static void assertEquals(int expected, int actual) {

        if (expected != actual) {

            throw new RuntimeException(
                    "Expected: " + expected + " but got: " + actual
            );
        }
    }

    public static void assertEquals(
            float expected,
            float actual,
            float delta
    ) {

        if (Math.abs(expected - actual) > delta) {

            throw new RuntimeException(
                    "Expected: " + expected + " but got: " + actual
            );
        }
    }

    public static void assertEquals(
            String expected,
            String actual
    ) {

        if (!expected.equals(actual)) {

            throw new RuntimeException(
                    "Expected: " + expected + " but got: " + actual
            );
        }
    }
}