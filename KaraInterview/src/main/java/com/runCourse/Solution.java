package com.runCourse;
public class Solution {

    public static void main(String[] argv) {

        testRun();

        testRunCollection();

        System.out.println("All tests passed");
    }

    public static void testRun() {

        System.out.println("Running testRun");

        Course testCourse = new Course("Test course", 2);

        Run testRun = new Run(testCourse);

        testRun.addObstacleTime(3);

        assert !testRun.complete :
                "Test run should not be complete";

        testRun.addObstacleTime(5);

        assert testRun.complete :
                "Test run should be complete";

        assert testRun.obstacleTimes.equals(
                java.util.List.of(3, 5))
                : "obstacleTimes should be [3, 5]";

        assert testRun.getRunTime() == 8
                : "getRunTime should return 8";

        try {

            testRun.addObstacleTime(4);

            assert false :
                    "adding obstacle time to complete run should throw";

        } catch (IllegalStateException e) {

            // expected
        }
    }

    public static RunCollection makeRunCollection(
            Course course,
            int[][] obstacleData) {

        RunCollection runCollection =
                new RunCollection(course);

        for (int[] runData : obstacleData) {

            Run run = new Run(course);

            for (int obstacleTime : runData) {

                run.addObstacleTime(obstacleTime);
            }

            runCollection.addRun(run);
        }

        return runCollection;
    }

    public static void testRunCollection() {

        System.out.println("Running testRunCollection");

        int[][] obstacleData = new int[][]{
                {3, 4, 5, 6},
                {4, 4, 4, 5},
                {4, 5, 4, 6},
                {5, 5, 3}
        };

        Course testCourse =
                new Course("Test course", 4);

        RunCollection runCollection =
                makeRunCollection(testCourse, obstacleData);

        int numRuns = obstacleData.length;

        assert runCollection.getNumRuns() == numRuns
                : "number of runs should be " + numRuns;

        assert runCollection.personalBest() == 17
                : "personalBest should be 17";

        assert runCollection.bestOfBests() == 15
                : "bestOfBests should be 15";
    }
}