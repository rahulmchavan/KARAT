package com.practice.chatgpt01;

import java.util.ArrayList;
import java.util.List;

public class StudentCollection {

    List<ScoreRecord> records = new ArrayList<>();

    void add(ScoreRecord record) {
        records.add(record);
    }

    double averageScore() {

        int total = records.stream()
                .mapToInt(r -> r.score)
                .sum();

        return total / records.size();
    }

    // TODO
    double highestScore() {

        return records.stream()
                .mapToInt(r -> r.score)
                .max()
                .orElse(-1);
    }
}