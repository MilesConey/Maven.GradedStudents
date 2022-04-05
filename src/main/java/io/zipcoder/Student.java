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
        double score;
        StringBuilder stringOfScores = new StringBuilder();

        for (int i = 0; i < getNumberOfExamsTaken(); i++){
            score = examScores.get(i);
            stringOfScores.append(score);
       }
        return String.valueOf(stringOfScores);
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            average += examScores.get(i);
        }
        return average / examScores.size();
    }

}

