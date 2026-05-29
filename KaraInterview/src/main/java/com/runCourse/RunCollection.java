package com.runCourse;
import java.util.ArrayList;
import java.util.List;

class RunCollection {

    public Course course;
    public List<Run> runs;

    public RunCollection(Course collectionCourse) {
        course = collectionCourse;
        runs = new ArrayList<>();
    }

    public int getNumRuns() {
        return runs.size();
    }

    public void addRun(Run run) {

        if (!run.course.equals(course)) {
            throw new IllegalArgumentException(
                    "run's Course is not the same as the RunCollection's");
        }

        runs.add(run);
    }

    // NEW METHOD
    public int bestOfBests() {

        int total = 0;

        for (int i = 0; i < course.obstacleCount; i++) {

            int bestTime = Integer.MAX_VALUE;

            for (Run run : runs) {

                if (i < run.obstacleTimes.size()) {

                    bestTime = Math.min(
                            bestTime,
                            run.obstacleTimes.get(i)
                    );
                }
            }

            total += bestTime;
        }

        return total;
    }

    public int personalBest() {

        return runs.stream()
                .filter(run -> run.complete)
                .mapToInt(run -> run.getRunTime())
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}