package com.practice.chatgpt01;
public class Solution {

    public static void main(String[] args) {

        testStudentCollection();
    }

    static void testStudentCollection() {

        Student s1 =
                new Student("1","Rahul");

        StudentCollection collection =
                new StudentCollection();

        assert collection.averageScore() == -1 :
                "Average should be -1";

        collection.add(
                new ScoreRecord(s1,90));

        collection.add(
                new ScoreRecord(s1,95));

        collection.add(
                new ScoreRecord(s1,80));

        assert collection.averageScore()
                == 88.33 :
                "Average should be 88.33";

        assert collection.highestScore()
                == 95 :
                "Highest score should be 95";
    }
}