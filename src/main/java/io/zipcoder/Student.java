package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() { //  string method representing all exams taken
        return examScores.toString();
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
        this.examScores.set(examNumber - 1 ,newScore);
    }

    public Double getAverageExamScore() {
        double sumOfExamScores = 0.0;
        for (Double examScore : examScores) {
            sumOfExamScores += examScore;
        }
        double average = sumOfExamScores / getNumberOfExamsTaken();
        return average;
    }

    @Override
    public String toString() {
        return "Student Name: " +
                firstName +  " " +
                lastName +
                ", Average Exam Score: " + getAverageExamScore() +
                ", Exam Scores: " + getExamScores();
    }
}

