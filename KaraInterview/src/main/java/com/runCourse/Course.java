package com.runCourse;
import java.util.Objects;

class Course {

    public String title;
    public int obstacleCount;

    public Course(String courseTitle, int obstacles) {
        title = courseTitle;
        obstacleCount = obstacles;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Course)) {
            return false;
        }

        Course c = (Course) o;

        return Objects.equals(c.title, this.title)
                && c.obstacleCount == this.obstacleCount;
    }

    @Override
    public int hashCode() {
        return (title == null ? 0 : title.hashCode()) * obstacleCount;
    }
}