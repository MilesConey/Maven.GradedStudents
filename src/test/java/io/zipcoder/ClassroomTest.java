package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };//Sum = 250, average = 125
        Double[] s2Scores = { 225.0, 75.0 };// Sum = 300, Average = 150 Average of both students = 137.5

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        // Given
        Student student1 = new Student("Miles", "Coney", new Double[]{100.0, 60.0, 34.0});
        Student student2 = new Student("Tatiana", "DeAngelo", new Double[]{100.0, 25.0, 16.0});
        Student student3 = new Student("Travis", "Scott", new Double[]{100.0, 63.0, 43.0});
        Integer expectedLength = 2;

        // When
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] newArray = classroom.removeStudent(student3.getFirstName(), student3.getLastName());
        Integer actualLength = newArray.length;

        // Then
        Assert.assertEquals(expectedLength, actualLength);
    }


    @Test
    public void getStudentByScoreTest() {
        // Given
        Student student1 = new Student("Allen", "Shup", new Double[]{60.0, 88.0, 95.0});
        Student student2 = new Student("Ben", "Alpit", new Double[]{100.0, 90.0, 84.0});
        Student student3 = new Student("Charles", "Compton", new Double[]{100.0, 100.0, 90.0});
        Student[] expectedArray = new Student[]{student3, student2, student1};

        // When
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] actualArray = classroom.getStudentByScore();

        // Then
        Assert.assertArrayEquals(expectedArray, actualArray);
    }





}
