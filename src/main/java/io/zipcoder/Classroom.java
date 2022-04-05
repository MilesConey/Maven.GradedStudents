package io.zipcoder;

import java.util.*;

public class Classroom {
    int maxNumberOfStudents;
    Student[] students;


    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }


    public double getAverageExamScore() {
        double sum = 0.0;
        for (Student average: students) {
            sum += average.getAverageExamScore() ;
        }
        return sum / students.length;
    }

    public void addStudent(Student student) {
        if (student == null) {
            List<Student> studentList = new ArrayList<>(Arrays.asList(students));
            studentList.add(student);
            students = studentList.toArray(new Student[0]);
        }
    }

    public Student[] removeStudent(String firstName, String lastName) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        for (Student student : students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                studentList.remove(student);
            }
        }
        return studentList.toArray(new Student[0]);
    }
    public Student[] getStudentByScore() {
        List<Student> students = new ArrayList<>(Arrays.asList(this.getStudents()));
        Comparator<Student> byScore = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> byFirstName = Comparator.comparing(Student::getLastName);
        Comparator<Student> byLastName = Comparator.comparing(Student::getFirstName);

        students.sort(byScore.thenComparing(byLastName).thenComparing(byFirstName));
        Collections.reverse(students);
        return students.toArray(new Student[0]);
    }


    public Map<Student, String> getGradeBook() {
        Student[] studentsByScore = this.getStudentByScore();
        Map<Student, String> gradebook = new HashMap<>();

        double percentile;
        for (int i = 0; i < studentsByScore.length; i++) {
            percentile = (double) (1 + ( (i + 1) / studentsByScore.length )) * 100;
            if (percentile > 90) {
                gradebook.put(studentsByScore[i], "A");
            } else if (percentile > 80) {
                gradebook.put(studentsByScore[i], "B");
            } else if (percentile > 70) {
                gradebook.put(studentsByScore[i], "C");
            } else if (percentile > 60) {
                gradebook.put(studentsByScore[i], "D");
            } else {
                gradebook.put(studentsByScore[i], "F");
            }
        }

        return gradebook;

    }



}
