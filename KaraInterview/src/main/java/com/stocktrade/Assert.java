package com.stocktrade;
class Assert {

    static void assertEquals(int expected, int actual) {

        if (expected != actual) {

            throw new AssertionError(
                    "Expected: " + expected + " but got: " + actual);
        }
    }

    static void assertEquals(String expected, String actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError(
                    "Expected: " + expected + " but got: " + actual);
        }
    }

    static void assertEquals(Object expected, Object actual) {

        if (!expected.equals(actual)) {

            throw new AssertionError(
                    "Expected: " + expected + " but got: " + actual);
        }
    }

    static void assertEquals(double expected,
                             double actual,
                             double delta) {

        if (Math.abs(expected - actual) > delta) {

            throw new AssertionError(
                    "Expected: " + expected + " but got: " + actual);
        }
    }
}