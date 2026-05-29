package com.runCourse;
import java.util.ArrayList;
import java.util.List;

class Run {

    public Course course;
    public boolean complete;
    public List<Integer> obstacleTimes;

    public Run(Course runCourse) {
        course = runCourse;
        complete = false;
        obstacleTimes = new ArrayList<>();
    }

    public void addObstacleTime(int obstacleTime) {

        if (complete) {
            throw new IllegalStateException(
                    "Cannot add obstacle to complete run");
        }

        obstacleTimes.add(obstacleTime);

        if (obstacleTimes.size() == course.obstacleCount) {
            complete = true;
        }
    }

    public int getRunTime() {
        return obstacleTimes.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}